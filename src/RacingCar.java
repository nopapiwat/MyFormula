
public class RacingCar {
	public static final double hf = 0.8;
	
	private int order;
	private Car car;
	
	private double curDist; // meter from backline
	private double curSpd; 	// m/s
	private boolean nitro; 	// true mean can use	
	
	public RacingCar(Car car){
		this.car = car;
		this.order = car.getCarNumber();
		this.curSpd = 0;
		this.nitro = true;
	}
	
	public int getOrder(){
		return this.order;
	}
	
	public void setOrder(int order){
		this.order = order;
	}
	
	public void setLineup(double dist){
		this.curDist = dist;
	}
	
	public double getCurDist(){
		return this.curDist;
	}
	
	public void update(){
		this.updateSpd();
		this.updateDist();
		
		//check hf
		//check nitro
	}
	
	private void updateSpd(){
		this.curSpd += this.car.getAccel()*2;
		if(this.curSpd > this.car.getTopSpd()){
			this.curSpd = this.car.getTopSpd();
		}
	}
	
	private void updateDist(){
		this.curDist += this.curSpd*2 - 0.5*this.car.getAccel()*4;
	}
	
	public void printDetail(){
		System.out.println("Car "+this.car.getCarNumber()+" : Now at "+this.curDist);
		System.out.println("        Top Speed "+this.car.getTopSpd());
		System.out.println("        Current Speed "+this.curSpd);
	}

}
