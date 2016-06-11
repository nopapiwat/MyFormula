public class Main {
	public static void main(String[] args){
		int teamNum = 5;
		double distance = 3000.0; //meter
					
		Racing r = new Racing(teamNum, distance);
		r.run();
	}
}
