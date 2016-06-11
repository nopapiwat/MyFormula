import static org.junit.Assert.*;

import org.junit.Test;


public class RacingTest {
	
	@Test
	public void testLineup() {
		assertTrue("1 car 100 meter", TestLineup1());		
		assertTrue("2 car 300 meter", TestLineup2());
	}
	
	private boolean TestLineup1(){
		Racing r = new Racing(1, 100);
		return r.getRacingCar(1).getCurDist()==0.0;
	}
	
	private boolean TestLineup2(){
		Racing r = new Racing(2, 300);
		return r.getRacingCar(2).getCurDist()==0.0 &&
				r.getRacingCar(1).getCurDist()==200.0;
	}


}
