public class Car {
	
	public static final double hf = 0.8;
	private int number;
	private double topSpd; 	// m/s
	private double accel; 	// m/s^2
	
	private double curDist; // meter from backline
	private double curSpd; 	// m/s
	private boolean nitro; 	// true mean can use
	
	public Car(int num){
		this.number = num;
		this.setTopSpd(num);
		this.setAccel(num);	
		this.curSpd = 0;
		this.nitro = true;
	}
	
	public void update(){
		this.updateSpd();
		this.updateDist();
		
		this.assetmemt();
	}
	
	private void assetmemt(){
		//check hf
		//check nitro
	}
	
	private void updateSpd(){		
		this.curSpd += this.accel*2;
	}
	
	private void updateDist(){
		this.curDist += this.curSpd*2 - 0.5*this.accel*4;
	}
	
	private void useNitro(){
		this.nitro = false;
	}
	
	public void setLineup(double dist){
		this.curDist = dist;
	}
	
	private void setTopSpd(int num){
		this.topSpd = (150+num*10)*5.0/18;
	}
	
	private void setAccel(int num){
		this.accel = 2.0*num;
	}
	
	public void printDetail(){
		System.out.println("Car "+this.number+" : Now at "+this.curDist);
		System.out.println("        Current Speed "+this.curSpd);
	}
}
