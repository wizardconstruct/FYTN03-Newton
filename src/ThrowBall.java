import java.io.*;




public class ThrowBall {

	public static void main(String[] arg){

		Simulation sim_resist = new Simulation(true, true);
		Simulation sim_partialresist = new Simulation(true, false);
		Simulation sim_noresist = new Simulation(false);
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
