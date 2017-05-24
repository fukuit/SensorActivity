package jp.gr.java_conf.fukuit.kitty;
public class KittyItem {
	private final double apple_weight=0.300;
	private final double apple_height=10.0;
	private double weight;
	private double height;
	private int convertedWeight;
	private int convertedHeight;
	public double getWeight() {
		return weight;
	}
	public int getConvertedWeight(){
		return convertedWeight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
		this.convertedWeight = (int)(weight/this.apple_weight);
	}
	public double getHeight() {
		return height;
	}
	public int getConvertedHeight(){
		return convertedHeight;
	}
	public void setHeight(double height) {
		this.height = height;
		this.convertedHeight = (int)(height/this.apple_height);
	}
	public KittyItem(double weight, double height) {
		super();
		this.weight = weight;
		this.height = height;
		this.convertedWeight = (int)(weight/this.apple_weight);
		this.convertedHeight = (int)(height/this.apple_height); 
	}
	public KittyItem() {
		super();
		this.weight = 0.0;
		this.height = 0.0;
		this.convertedWeight=0;
		this.convertedHeight=0;
	}	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("身長: りんご").append(this.convertedHeight).append("個分 / 体重: りんご").append(this.convertedWeight).append("個分");
		return sb.toString();
	}
}
