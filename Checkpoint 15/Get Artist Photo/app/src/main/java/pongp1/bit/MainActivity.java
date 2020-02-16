package pongp1.bit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView artistImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        artistImageView = findViewById(R.id.imageView1);
        getAPIData thread = new getAPIData();
        thread.execute();
    }

    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte=Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    class getAPIData extends AsyncTask<Void, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(Void... voids) {

            Bitmap artistImage = null;

            try {
                URL urlObject = new URL("https://ws.audioscrobbler.com/2.0/?method=chart.getTopArtists&api_key=58384a2141a4b9737eacb9d0989b8a8c&limit=1&format=json");
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

                JSONObject data = new JSONObject(stringBuilder.toString());
                JSONObject artists = data.getJSONObject("artists");
                JSONArray artistsArray = artists.getJSONArray("artist");
                JSONObject currentArtist = artistsArray.getJSONObject(0);
                JSONArray images = currentArtist.getJSONArray("image");
                JSONObject image = images.getJSONObject(2);

                urlObject = new URL(image.getString("#text"));
                connection = (HttpURLConnection) urlObject.openConnection();
                artistImage = BitmapFactory.decodeStream(connection.getInputStream());

            } catch (Exception e) {
                Log.i("API Reading Error", e.getMessage());
            }
            return artistImage;
        }

        @Override
        protected void onPostExecute(Bitmap artistImage) {
            super.onPostExecute(artistImage);
            try {
                artistImageView.setImageBitmap(artistImage);
            }

            catch (Exception e) {
                Log.i("Error:", e.getMessage());
            }
        }
    }
}
