import java.io.*;




public class ThrowBall {
	private Params params;
		
	public ThrowBall() {
		
		this.params = new Params();
		
	};
	
	
	
	// Main function of the simulation here
	private void run() throws IOException, FileNotFoundException {
		double t = 0;
		double y = 0;
		double v_y = 0;
		y += this.params.y_0;
		v_y += this.params.v_y_0;
		
		BufferedWriter w = new BufferedWriter(new FileWriter("out.dat"));

		NewtonODE newton = new NewtonODE();
		
		while (y >= 0) {

			t += params.h;
			y += v_y * params.h;
			v_y = newton.solve_vy(params, v_y);
					
			if (y >= 0) {
				w.write(t+"\t"+y+"\t"+v_y);
				w.newLine();
			}
		}
		
		w.close();	
				
	}
		
	
	
	public static void main(String[] arg){
		
		ThrowBall sim = new ThrowBall();
		
		try {
			sim.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
