
public class RacingCar implements Comparable<RacingCar>{
	public static final double hf = 0.8;
	
	private int order;
	private Car car;
	
	private double oldSpd; 	// m/s
	
	private double curDist; // meter from backline
	private double curSpd; 	// m/s
	private boolean stateHF;
	private boolean nitro; 	// true mean can use	
	
	private boolean finish;
	private int timeToFin; // second
	
	public RacingCar(Car car){
		this.car = car;
		this.order = car.getCarNumber();
		this.curSpd = 0;
		this.stateHF = false;
		this.nitro = true;		
		this.finish = false;
	}
	
	public void useNitro(){
		if(this.nitro){
			this.curSpd*=2;
			this.limitSpd();
			this.nitro = false;			
		}
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
	
	public void inHF(){
		this.stateHF = true;
		this.curSpd *= RacingCar.hf;
		System.out.println("Car "+this.car.getCarNumber()+" in HF");
	}
	
	public void outHF(){
		this.stateHF = false;		
	}
	
	public boolean isInHF(){
		return this.stateHF;
	}
	
	public void update(){		
		this.updateSpd();
		this.updateDist();
	}
	
	private void limitSpd(){
		if(this.curSpd > this.car.getTopSpd()){
			this.curSpd = this.car.getTopSpd();
		}		
	}
	
	private void updateSpd(){
		this.oldSpd = this.curSpd;
		this.curSpd += this.car.getAccel()*2;
		this.limitSpd();
	}
	
	private void updateDist(){
		this.curDist += this.oldSpd*2 + (this.curSpd-this.oldSpd);		
	}
	
	public boolean isFinish(){
		return this.finish;
	}
	public void finish(){
		this.finish = true;
	}
	
	public void setFinishTime(int time){
		this.timeToFin = time;
	}
	
	public void printDetail(){
		System.out.println("Car "+this.car.getCarNumber()+" : Now at "+this.curDist);
		System.out.println("        Top Speed "+this.car.getTopSpd());
		System.out.println("        Current Speed "+this.curSpd);
		System.out.println("        Finish in "+this.timeToFin);
	}

	@Override
	public int compareTo(RacingCar o) {
		if(this.getCurDist()-o.getCurDist() >= 0){
			return -1;
		}
		else{
			return 1;
		}		
	}

}
