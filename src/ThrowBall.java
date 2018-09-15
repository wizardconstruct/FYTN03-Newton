import java.io.*;




public class ThrowBall {

	public static void main(String[] arg){

		int v_steps = 10;
		double v_min = 14.39;
		double v_max = 14.49;
		double v_inc = (v_max-v_min)/(v_steps-1);
		double [] v_array = new double[v_steps];
		for(int i = 0; i < v_array.length; i++){
			v_array[i] = v_min+i*v_inc;
		}
		int phi_steps = 10;
		double phi_min = 36.8;
		double phi_max = 37.8;
		double phi_inc = (phi_max-phi_min)/(phi_steps-1);
		double [] phi_array = new double[phi_steps];
		for(int i = 0; i < phi_array.length; i++){
			phi_array[i] = phi_min+i*phi_inc;
		}

		for(double v : v_array){
			for(double phi : phi_array){
				Simulation sim = new Simulation(true, true, phi, v);
				try{
					sim.run();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("");
		}
		/*
                Params params = new Params();
		Simulation sim_resist = new Simulation(true, true, params.phi, params.v);				// Simulate with B1 and B2
		Simulation sim_partialresist = new Simulation(true, false, params.phi, params.v);                     // Simulate with B2 but no B1
		Simulation sim_noresist = new Simulation(false, params.phi, params.v);				// Simulate with neither one
		try {
			sim_resist.run();
			sim_partialresist.run();
			sim_noresist.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 */
	}
}
