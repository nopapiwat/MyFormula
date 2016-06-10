import java.util.ArrayList;


public class Racing {
	
	private ArrayList<Car> cars;
	
	public Racing(int carNum, double distance){
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
		for(int i = 0; i < this.cars.size(); i++){
			this.cars.get(i).printDetail();
			this.cars.get(i).update();
		}
	}
	
}
