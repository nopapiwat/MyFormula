import java.util.ArrayList;


public class Racing {
	
	private ArrayList<Car> cars;
	private int carNum;
	private double distance;
	
	public Racing(int carNum, double distance){
		this.carNum = carNum;
		this.distance = distance;
		
		this.createCars(carNum);
		this.setLineup(distance);	
	}
	
	private void createCars(int num){
		this.cars = new ArrayList<Car>();
		
		for(int i = 1; i <= num; i++){
			this.cars.add(new Car(i));
		}
	}
	
	private void setLineup(double distance){
		int num = this.cars.size();
		double cumDist = 0;		
		for(int i = num; i > 0; i--){
			this.cars.get(i-1).setLineup(cumDist);
			cumDist += 200*(i-1);
		}
	}
	
	public void run(){
		int sec = 0;
		this.printDetail();
		do{
			for(int i = 0; i < this.cars.size(); i++){
				this.cars.get(i).update();
			}
			sec += 2;
			System.out.println("\n==== Pass 2 sec ====\n");
			this.printDetail();
		}while(this.checkUnfinish());		
		System.out.println("Finish in "+sec+" seconds !!!");
	}
	
	private void printDetail(){
		for(int i = 0; i < this.cars.size(); i++){			
			this.cars.get(i).printDetail();				
		}
	}
	
	private boolean checkUnfinish(){	
		for(int i = 0; i < this.cars.size(); i++){
			if(this.cars.get(i).getCurDist() < this.distance){
				return true;
			}
		}
		return false;
	}
	
}
