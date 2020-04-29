package pongp1.bit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ArtistData> artistDataArray;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistDataArray = new ArrayList<>();
        listView = findViewById(R.id.listView1);
        getAPIData thread = new getAPIData();
        thread.execute();
    }

    class getAPIData extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String JSONString = " ";
            try{
                URL urlObject = new URL("https://ws.audioscrobbler.com/2.0/?method=chart.getTopArtists&api_key=58384a2141a4b9737eacb9d0989b8a8c&format=json");
                HttpURLConnection connection  = (HttpURLConnection) urlObject.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader ir = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(ir);

                String currentLine;
                StringBuilder stringBuilder = new StringBuilder();
                while ((currentLine = reader.readLine()) != null) {
                    stringBuilder.append(currentLine);
                }
                JSONString = stringBuilder.toString();
            }

            catch (Exception e){
                Log.i("API Reading Error", e.getMessage());
            }
            return JSONString;
        }

        @Override
        protected void onPostExecute(String JSONString) {
            super.onPostExecute(JSONString);

            try{
                JSONObject data = new JSONObject(JSONString);
                JSONObject artists = data.getJSONObject("artists");
                JSONArray artistsArray = artists.getJSONArray("artist");
                for(int i = 0; i < artistsArray.length(); i++){
                    JSONObject currentArtist = artistsArray.getJSONObject(i);
                    artistDataArray.add(new ArtistData(currentArtist.getString("name"), currentArtist.getInt("listeners")));
                }

                listView.setAdapter(new CustomArtistDataAdapter(MainActivity.this, R.layout.listview_layout, artistDataArray));
            }

            catch(Exception e){
                Log.i("Error:", e.getMessage());
            }
        }
    }
}
