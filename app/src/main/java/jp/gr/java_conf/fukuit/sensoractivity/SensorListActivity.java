package jp.gr.java_conf.fukuit.sensoractivity;
/**
 * SensorListActivity
 *   Set ListView to SensorName and Status
 */

import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class SensorListActivity extends ListActivity {
    private SensorManager sensorManager;
    private ArrayAdapter<String> adapter;

    private int sensorList[] = {
            Sensor.TYPE_ACCELEROMETER,
            Sensor.TYPE_AMBIENT_TEMPERATURE,
            Sensor.TYPE_DEVICE_PRIVATE_BASE,
            Sensor.TYPE_GAME_ROTATION_VECTOR,
            Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,
            Sensor.TYPE_GRAVITY,
            Sensor.TYPE_GYROSCOPE,
            Sensor.TYPE_GYROSCOPE_UNCALIBRATED,
            Sensor.TYPE_HEART_BEAT,
            Sensor.TYPE_HEART_RATE,
            Sensor.TYPE_LIGHT,
            Sensor.TYPE_LINEAR_ACCELERATION,
            Sensor.TYPE_MAGNETIC_FIELD,
            Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,
            Sensor.TYPE_MOTION_DETECT,
            Sensor.TYPE_POSE_6DOF,
            Sensor.TYPE_PRESSURE,
            Sensor.TYPE_PROXIMITY,
            Sensor.TYPE_RELATIVE_HUMIDITY,
            Sensor.TYPE_ROTATION_VECTOR,
            Sensor.TYPE_SIGNIFICANT_MOTION,
            Sensor.TYPE_STEP_COUNTER,
            Sensor.TYPE_STEP_DETECTOR
    };

    private String sensorNameList[] = {
            "ACCELEROMETER",
            "AMBIENT_TEMPERATURE",
            "DEVICE_PRIVATE_BASE",
            "GAME_ROTATION_VECTOR",
            "GEOMAGNETIC_ROTATION_VECTOR",
            "GRAVITY",
            "GYROSCOPE",
            "GYROSCOPE_UNCALIBRATED",
            "HEART_BEAT",
            "HEART_RATE",
            "LIGHT",
            "LINEAR_ACCELERATION",
            "MAGNETIC_FIELD",
            "MAGNETIC_FIELD_UNCALIBRATED",
            "MOTION_DETECT",
            "POSE_6DOF",
            "PRESSURE",
            "PROXIMITY",
            "RELATIVE_HUMIDITY",
            "ROTATION_VECTOR",
            "SIGNIFICANT_MOTION",
            "STEP_COUNTER",
            "STEP_DETECTOR"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        listSensors();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listSensors();
    }

    /**
     * SensorMangerからsensorListにあるsensorがあるかどうかを判断してlistViewのadapterにadd()する
     */
    private void listSensors(){
        StringBuilder sb = new StringBuilder();
        String sensorStatus = ": NG";
        for(int i=0; i < sensorList.length; i++) {
            sb.setLength(0);
            Sensor sensor = sensorManager.getDefaultSensor(sensorList[i]);
            if (sensor != null) {
                sensorStatus = getString(R.string.status_ok);
            } else {
                sensorStatus = getString(R.string.status_ng);
            }
            sb.append(sensorNameList[i]).append(": ").append(sensorStatus);
            adapter.add(sb.toString());
        }
    }

}
