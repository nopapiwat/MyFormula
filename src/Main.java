public class Main {
	public static void main(String[] args){
		int teamNum = 5;
		double distance = 5000.0; //meter
		
		System.out.println("Start Racing!!");
		Racing r = new Racing(teamNum, distance);
		r.run();
		System.out.println("\n=========== Pass 2 seconds ========\n");
		r.run();
		System.out.println("\n=========== Pass 2 seconds ========\n");
		r.run();
	}
}
