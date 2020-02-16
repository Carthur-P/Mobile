package pongp1.bit;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView1);
        list.setAdapter(new ArrayAdapter<String>(this, R.layout.listview_layout, R.id.textView1, loadData("animals.txt")));
    }

    public ArrayList<String> loadData(String fileName){
        AssetManager am = getAssets();
        ArrayList<String> stringArrayList = new ArrayList<>();

        try{
            InputStream is = am.open(fileName);
            InputStreamReader sr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(sr);

            String currentString;
            while ((currentString = br.readLine()) != null){
                stringArrayList.add(currentString);
            }
            br.close();

        } catch (IOException e){
            Log.e(e.toString(), "error message");
        }
        return stringArrayList;
    }
}
