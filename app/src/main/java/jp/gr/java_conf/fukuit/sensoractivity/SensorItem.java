package jp.gr.java_conf.fukuit.sensoractivity;

/**
 * Created by toshi on 2017/06/03.
 */

public class SensorItem {
    private int sensor;
    private String sensorName;
    private boolean status;
    public int getSensor(){
        return this.sensor;
    }
    public void setSensor(int sensor){
        this.sensor = sensor;
    }

    public String getSensorName(){
        return this.sensorName;
    }
    public void setSensorName(String sensorName){
        this.sensorName = sensorName;
    }

    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public SensorItem(){
        super();
    }
    public SensorItem(int sensor, String sensorName){
        super();
        this.sensor = sensor;
        this.sensorName = sensorName;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("SensorType:").append(this.sensor);
        sb.append("/");
        sb.append("SensorName:").append(this.sensorName);
        sb.append("/");
        sb.append("Status:").append(this.status);
        return sb.toString();
    }
}
