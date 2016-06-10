import java.util.ArrayList;


public class Racing {
	
	private RacingCar[] rcars;
	private int carNum;
	private double distance;
	
	public Racing(int carNum, double distance){
		this.carNum = carNum;
		this.distance = distance;
		
		this.rcars = RacingCarFactory.importRacingCars(carNum);
		this.setLineup(distance);	
	}
	
	private void setLineup(double distance){		
		double cumDist = 0;		
		for(int i = this.carNum; i > 0; i--){
			this.rcars[i-1].setLineup(cumDist);
			cumDist += 200*(i-1);
		}
	}
	
	/*public void run(){
		int sec = 0;
		this.printDetail();
		do{
			for(int i = 0; i < this.cars.size(); i++){
				this.cars.get(i).update();
			}
			sec += 2;
			System.out.println("\n==== Second "+sec+" ====\n");
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
	}*/
	
}
