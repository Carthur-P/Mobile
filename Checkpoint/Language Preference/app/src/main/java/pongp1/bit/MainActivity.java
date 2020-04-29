package pongp1.bit;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor prefEditor;
    RadioGroup language;
    RadioGroup colour;
    Button submit;
    TextView appGreeting;
    Resources resourceResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resourceResolver = getResources();
        appGreeting = findViewById(R.id.textView1);
        language = findViewById(R.id.languageGroup);
        colour = findViewById(R.id.colourGroup);
        submit = findViewById(R.id.button1);

        pref = getSharedPreferences("appSetting", MODE_PRIVATE);
        prefEditor = pref.edit();

        String languagePeference = pref.getString("language", null);
        if(languagePeference != null){
            appGreeting.setText(setLanguage(languagePeference));
        }

        String colourPeference = pref.getString("colour", null);
        if(colourPeference != null){
            appGreeting.setTextColor(setColour(colourPeference));
        }

        submit.setOnClickListener(new OnSubmitButtonClickHandler());
    }

    public class OnSubmitButtonClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            RadioButton checkedLanguage = findViewById(language.getCheckedRadioButtonId());
            RadioButton checkedColour = findViewById(colour.getCheckedRadioButtonId());
            prefEditor.putString("language", checkedLanguage.getText().toString());
            prefEditor.putString("colour", checkedColour.getText().toString());
            prefEditor.commit();

            String languagePeference = pref.getString("language", null);
            if(languagePeference != null){
                appGreeting.setText(setLanguage(languagePeference));
            }

            String colourPeference = pref.getString("colour", null);
            if(colourPeference != null){
                appGreeting.setTextColor(setColour(colourPeference));
            }
        }
    }

    public String setLanguage(String language){
        String greeting = " ";

        switch (language){
            case "English":
                greeting = "Hello Wolrd!";
                break;

            case "German":
                greeting = "Hallo Welt!";
                break;

            case "Spanish":
                greeting = "Hola Mundo!";
                break;
        }
        return greeting;
    }

    public int setColour(String colour){
        int textColour = 0;

        switch (colour){
            case "Black":
                textColour = Color.BLACK;
                break;

            case "Green":
                textColour = Color.GREEN;
                break;

            case "Red":
                textColour = Color.RED;
                break;
        }
        return textColour;
    }
}
