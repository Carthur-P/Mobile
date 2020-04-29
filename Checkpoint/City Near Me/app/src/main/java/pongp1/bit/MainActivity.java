package pongp1.bit;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand;
    Button teleport;
    TextView latText;
    TextView lngText;
    TextView cityNearMe;
    double lat;
    double lng;
    LocationManager locationManager;
    String providerName;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();
        teleport = findViewById(R.id.button1);
        latText = findViewById(R.id.textView2);
        lngText = findViewById(R.id.textView3);
        cityNearMe = findViewById(R.id.textView4);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria defaultCriteria = new Criteria();
        providerName = locationManager.getBestProvider(defaultCriteria, false);
        progressDialog = new ProgressDialog(MainActivity.this);

        boolean locationPermissionsOk = checkLocationPermission();
        if (locationPermissionsOk) {
            teleport.setOnClickListener(new OnButtonClickHandler());
        }

        else {
            requestLocationPermission();
        }
    }

    public boolean checkLocationPermission() {
        int fineLocationOk = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int coarseLocationOk = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        return (fineLocationOk == PackageManager.PERMISSION_GRANTED) && (coarseLocationOk == PackageManager.PERMISSION_GRANTED);
    }

    public void requestLocationPermission() {
        String[] permissionsIWant = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        ActivityCompat.requestPermissions(this, permissionsIWant, 42);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (checkLocationPermission()) {
                providerName = locationManager.getBestProvider(new Criteria(), false);
                teleport.setOnClickListener(new OnButtonClickHandler());
            }
        }
    }

    public class OnButtonClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            getAPIData thread = new getAPIData();
            thread.execute();
        }
    }

    class getAPIData extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... Void) {
            String JSONString = "";
            do{
                try{
                    lat = -90 + (90 - -90) * rand.nextDouble();
                    lng = -180 + (180 - -180) * rand.nextDouble();
                    URL urlObject = new URL("http://www.geoplugin.net/extras/location.gp?lat=" + lat + "&long=" + lng + "&format=json");
                    HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
                    connection.connect();
                    int res = connection.getResponseCode();
                    if(res == 200) {
                        InputStream is = connection.getInputStream();
                        InputStreamReader ir = new InputStreamReader(is);
                        BufferedReader reader = new BufferedReader(ir);

                        String currentLine;
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((currentLine = reader.readLine()) != null) {
                            stringBuilder.append(currentLine);
                        }
                        JSONString = stringBuilder.toString();
                        Log.i("JSON String", JSONString);
                    }
                } catch (Exception e) {
                    Log.i("API Reading Error", e.getMessage());
                }
            }while(JSONString.equals("[[]]"));
            return JSONString;
        }

        @Override
        protected void onPreExecute(){
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Finding city... please wait");
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String JSONString) {
            super.onPostExecute(JSONString);
            progressDialog.cancel();
            try {
                JSONObject data = new JSONObject(JSONString);
                String city = data.getString("geoplugin_place");
                latText.setText("Latitude: " + new DecimalFormat(".000").format(lat));
                lngText.setText("Longitude: " + new DecimalFormat(".000").format(lng));
                cityNearMe.setText("City: " + city);
                cityNearMe.setVisibility(View.VISIBLE);
                latText.setVisibility(View.VISIBLE);
                lngText.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                Log.i("Error:", e.getMessage());
            }
        }
    }
}
