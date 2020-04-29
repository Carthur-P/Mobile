package pongp1.bit;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor proximitySensor;
    private TextView xAxis, yAxis, zAzis, proximity;
    private ListView sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if(accelerometerSensor != null){
            sensorManager.registerListener(new AccelerometerListener(), accelerometerSensor, sensorManager.SENSOR_DELAY_NORMAL);
        }

        if(proximitySensor != null){
            sensorManager.registerListener(new ProximityListener(), proximitySensor, sensorManager.SENSOR_DELAY_NORMAL);
        }

        Log.i("Message", String.valueOf(accelerometerSensor));
        xAxis = findViewById(R.id.textView2);
        yAxis = findViewById(R.id.textView3);
        zAzis = findViewById(R.id.textView4);
        proximity = findViewById(R.id.textView6);
        sensorList= findViewById(R.id.listView1);
        sensorList.setAdapter(new ArrayAdapter<>(this, R.layout.listview_layout, R.id.tv, getSensors()));
    }

    public ArrayList<String> getSensors(){
        ArrayList<String> sensorArray = new ArrayList<>();
        List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(int i = 0; i < list.size(); i++){
            sensorArray.add(list.get(i).getName());
        }
        return  sensorArray;
    }

    public class AccelerometerListener implements SensorEventListener{
        @Override
        public void onSensorChanged(SensorEvent event){
            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                DecimalFormat formatter = new DecimalFormat("##.##");
                xAxis.setText("Axis X: " + formatter.format(event.values[0]));
                yAxis.setText("Axis Y: " + formatter.format(event.values[1]));
                zAzis.setText("Axis Z: " + formatter.format(event.values[2]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1)
        {
            //Do nothing
        }
    }

    public class ProximityListener implements SensorEventListener{
        @Override
        public void onSensorChanged(SensorEvent event){
            if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
                if(event.values[0] < 2){
                    proximity.setText("You are near");
                } else {
                    proximity.setText("You are far");
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1)
        {
            //Do nothing
        }
    }
}
