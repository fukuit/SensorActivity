package jp.gr.java_conf.fukuit.sensoractivity;
/**
 * SensorListActivity
 *   Set ListView to SensorName and Status
 */

import java.util.ArrayList;
import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SensorListActivity extends ListActivity {
    private SensorManager sensorManager;
    private ArrayAdapter<String> adapter;
    private ArrayList<SensorItem> sensorList;
    private void initSensorList(){
        sensorList = new ArrayList<SensorItem>();
        sensorList.add( new SensorItem(Sensor.TYPE_ACCELEROMETER, "ACCELEROMETER"));
        sensorList.add( new SensorItem(Sensor.TYPE_AMBIENT_TEMPERATURE,"AMBIENT_TEMPERATURE"));
        sensorList.add( new SensorItem(Sensor.TYPE_DEVICE_PRIVATE_BASE,"DEVICE_PRIVATE_BASE"));
        sensorList.add( new SensorItem(Sensor.TYPE_GAME_ROTATION_VECTOR,"GAME_ROTATION_VECTOR"));
        sensorList.add( new SensorItem(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,"GEOMAGNETIC_ROTATION_VECTOR"));
        sensorList.add( new SensorItem(Sensor.TYPE_GRAVITY, "GRAVITY"));
        sensorList.add( new SensorItem(Sensor.TYPE_GYROSCOPE, "GYROSCOPE"));
        sensorList.add( new SensorItem(Sensor.TYPE_GYROSCOPE_UNCALIBRATED, "GYROSCOPE_UNCALIBRATED"));
        sensorList.add( new SensorItem(Sensor.TYPE_HEART_BEAT, "HEART_BEAT"));
        sensorList.add( new SensorItem(Sensor.TYPE_HEART_RATE, "HEART_RATE"));
        sensorList.add( new SensorItem(Sensor.TYPE_LIGHT, "LIGHT"));
        sensorList.add( new SensorItem(Sensor.TYPE_LINEAR_ACCELERATION, "LINEAR_ACCELERATION"));
        sensorList.add( new SensorItem(Sensor.TYPE_MAGNETIC_FIELD, "MAGNETIC_FIELD"));
        sensorList.add( new SensorItem(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED, "MAGNETIC_FIELD_UNCALIBRATED"));
        sensorList.add( new SensorItem(Sensor.TYPE_MOTION_DETECT, "MOTION_DETECT"));
        sensorList.add( new SensorItem(Sensor.TYPE_POSE_6DOF, "POSE_6DOF"));
        sensorList.add( new SensorItem(Sensor.TYPE_PRESSURE, "PRESSURE"));
        sensorList.add( new SensorItem(Sensor.TYPE_PROXIMITY, "PROXIMITY"));
        sensorList.add( new SensorItem(Sensor.TYPE_RELATIVE_HUMIDITY, "RELATIVE_HUMIDITY"));
        sensorList.add( new SensorItem(Sensor.TYPE_ROTATION_VECTOR, "ROTATION_VECTOR"));
        sensorList.add( new SensorItem(Sensor.TYPE_SIGNIFICANT_MOTION, "SIGNIFICANT_MOTION"));
        sensorList.add( new SensorItem(Sensor.TYPE_STEP_COUNTER, "STEP_COUNTER"));
        sensorList.add( new SensorItem(Sensor.TYPE_STEP_DETECTOR, "STEP_DETECTOR"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        initSensorList();
        listSensors();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listSensors();
    }

    @Override
    protected void onListItemClick(ListView lv, View v, int position, long id) {
        String sensorName = (String) lv.getAdapter().getItem(position);
        Sensor sensor = sensorManager.getDefaultSensor((sensorList.get(position)).getSensor());
        StringBuilder sb = new StringBuilder();
        if (sensor != null) {
            sb.append(sensor.toString());
        } else {
            sb.append(getString(R.string.empty_text));
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
    }

    /**
     * SensorMangerからsensorListにあるsensorがあるかどうかを判断してlistViewのadapterにadd()する
     */
    private void listSensors(){
        for(int i=0; i < sensorList.size(); i++) {
            SensorItem si = sensorList.get(i);
            Sensor sensor = sensorManager.getDefaultSensor(si.getSensor());
            if (sensor != null) {
                si.setStatus(true);
            } else {
                si.setStatus(false);
            }
            adapter.add(si.toString());
            (sensorList.get(i)).setStatus(si.getStatus());
        }
    }

}
