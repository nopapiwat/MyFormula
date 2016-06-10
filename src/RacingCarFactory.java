import java.util.ArrayList;


public class RacingCarFactory {	
	
	public static RacingCar[] importRacingCars(int num){
		ArrayList<RacingCar> rcars = new ArrayList<RacingCar>();
		
		for(int i = 1; i <= num; i++){
			RacingCar rc = new RacingCar(i);
			rc.setCar(CarFactory.createCar(i));
			rcars.add(rc);
		}
		
		return (RacingCar[]) rcars.toArray();
	}
}
