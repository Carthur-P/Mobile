package pongp1.bit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("database", MODE_PRIVATE, null);

        //drop table
        db.execSQL("DROP TABLE IF EXISTS Country");
        db.execSQL("DROP TABLE IF EXISTS City");
        db.execSQL("DROP TABLE IF EXISTS CityInCountry");

        //create table
        db.execSQL("CREATE TABLE Country(" +
                "countryID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "countryName VARCHAR NOT NULL)");

        db.execSQL("CREATE TABLE City(" +
                "cityID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "cityName VARCHAR NOT NULL)");

        db.execSQL("CREATE TABLE CityInCountry(" +
                "countryID INTEGER NOT NULL," +
                "cityID INTEGER NOT NULL," +
                "FOREIGN KEY(countryID) REFERENCES Country(countryID)," +
                "FOREIGN KEY(cityID) REFERENCES City(cityID))");

        //insert data
        db.execSQL("INSERT INTO Country(countryName) VALUES('New Zealand'),('Thailand'),('Brazil'),('America')");
        db.execSQL("INSERT INTO City(cityName) VALUES('Dunedin'),('Bangkok'),('Pai'),('Rio'),('New York')");
        db.execSQL("INSERT INTO CityInCountry VALUES(1,1),(2,2),(2,3),(3,4),(4,5)");

        Cursor countrySet = db.rawQuery("SELECT countryName FROM Country", null);
        ArrayList<String> countryArray = new ArrayList<>();
        countrySet.moveToFirst();
        for(int i = 0; i < countrySet.getCount(); i++){
            countryArray.add(countrySet.getString(countrySet.getColumnIndex("countryName")));
            countrySet.moveToNext();
        }
        Spinner countrySpinner = findViewById(R.id.spinner1);
        countrySpinner.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countryArray));
        countrySet.close();
    }

    public class OnSpinnerClick implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selectedCountry = parent.getItemAtPosition(position).toString();
            Cursor countrySet = db.rawQuery("SELECT ci.cityName FROM Country co JOIN ", null);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
