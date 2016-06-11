import java.util.Arrays;
import java.util.Comparator;


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
	
	public void run(){
		int sec = 0;
		this.printDetail();
		System.out.println("Start Racing!!");
		while(this.checkUnfinish(sec)){
			for(int i = 0; i < this.rcars.length; i++){
				this.rcars[i].update();
			}
			sec += 2;
			
			Arrays.sort(this.rcars);
			for(int i = 0; i < this.rcars.length-1; i++){
				if(Math.abs(this.rcars[i].getCurDist()-this.rcars[i+1].getCurDist()) <= 10.0){
					this.rcars[i].inHF();
					this.rcars[i+1].inHF();
				}else{
					if(this.rcars[i].isInHF()){
						this.rcars[i].outHF();
					}
				}
			}
			this.rcars[this.rcars.length-1].useNitro();			
		}		
		this.printDetail();
		System.out.println("Finish in "+sec+" seconds !!!");
	}
	
	private void printDetail(){
		for(int i = 0; i < this.rcars.length; i++){			
			this.rcars[i].printDetail();				
		}
	}
	
	private boolean checkUnfinish(int sec){
		boolean unfin = false;
		for(int i = 0; i < this.rcars.length; i++){
			if(!this.rcars[i].isFinish()){
				if(this.rcars[i].getCurDist() >= this.distance){
					this.rcars[i].setFinishTime(sec);
					this.rcars[i].finish();
				}else{
					unfin = true;
				}
			}
		}
		return unfin;
	}
	
	public RacingCar getRacingCar(int num){
		return this.rcars[num-1];
	}
	
}
