import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CarTest {

	@Test
	public void testSpect() {
		assertTrue("Car number 1", TestSpect1());
		assertTrue("Car number 5", TestSpect2());
	}
	
	private boolean TestSpect1(){
		Car car = CarFactory.createCar(1);
		return car.getTopSpd() == 160*5.0/18 &&
				car.getAccel() == 2;
	}
	
	private boolean TestSpect2(){
		Car car = CarFactory.createCar(5);
		return car.getTopSpd() == 200*5.0/18 &&
				car.getAccel() == 10;
	}

}
