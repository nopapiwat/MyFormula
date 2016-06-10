public class Car {
		
	private int number;
	private double topSpd; 	// m/s
	private double accel; 	// m/s^2
	
	public Car(int num){
		this.number = num;
		this.setTopSpd(num);
		this.setAccel(num);			
	}
	
	private void setTopSpd(int num){
		this.topSpd = (150+num*10)*5.0/18;
	}
	
	private void setAccel(int num){
		this.accel = 2.0*num;
	}
	
	public int getCarNumber(){
		return this.number;
	}
	
	public double getTopSpd(){
		return this.topSpd;
	}
	
	public double getAccel(){
		return this.accel;
	}
}
