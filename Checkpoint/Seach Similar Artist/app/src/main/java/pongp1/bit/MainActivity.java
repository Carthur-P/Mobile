package pongp1.bit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText artistName;
    ArrayList<String> similarArtistArray;
    ListView listView;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistName = findViewById(R.id.editText1);
        similarArtistArray = new ArrayList<>();
        listView = findViewById(R.id.listView1);
        searchButton = findViewById(R.id.button1);
        searchButton.setOnClickListener(new OnClickHandler());
    }

    class getAPIData extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... URLString) {
            String JSONString = " ";
            try {
                URL urlObject = new URL(URLString[0]);
                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
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
            } catch (Exception e) {
                Log.i("API Reading Error", e.getMessage());
            }
            return JSONString;
        }

        @Override
        protected void onPostExecute(String JSONString) {
            super.onPostExecute(JSONString);

            try {
                JSONObject data = new JSONObject(JSONString);
                JSONObject similarArtists = data.getJSONObject("similarartists");
                JSONArray artistsArray = similarArtists.getJSONArray("artist");
                for (int i = 0; i < artistsArray.length(); i++) {
                    JSONObject currentArtist = artistsArray.getJSONObject(i);
                    similarArtistArray.add(currentArtist.getString("name"));
                }

                listView.setAdapter(new ArrayAdapter(MainActivity.this, R.layout.listview_layout, R.id.tv1, similarArtistArray));
            } catch (Exception e) {
                Log.i("Error:", e.getMessage());
                Toast.makeText(MainActivity.this, "Please enter something in the artist name section", Toast.LENGTH_LONG).show();
            }
        }
    }

    public class OnClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String URL = "https://ws.audioscrobbler.com/2.0/?method=artist.getSimilar&artist=" + artistName.getText() + "&api_key=58384a2141a4b9737eacb9d0989b8a8c&limit=10&format=json";
            getAPIData thread = new getAPIData();
            thread.execute(URL);
        }
    }
}
