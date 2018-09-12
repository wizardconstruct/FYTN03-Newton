import java.io.*;




public class ThrowBall {

	public static void main(String[] arg){

		Simulation sim_resist = new Simulation(true, true);				// Simulate with B1 and B2
		Simulation sim_partialresist = new Simulation(true, false);		// Simulate with B2 but no B1
		Simulation sim_noresist = new Simulation(false);				// Simulate with neither one
		try {
			sim_resist.run();
			sim_partialresist.run();
			sim_noresist.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
