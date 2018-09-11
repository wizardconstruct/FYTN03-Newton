// In case we want to run multiple simulations at the same time (such as with and without air resistance) this could be its own module

public class Simulation {
	private Params params;
	private boolean useResistance;
	
	public Simulation(boolean useResistance) {
		
		this.params = new Params();
		this.useResistance = useResistance;
		
	};
	
	public void run() {
		
		Ball ball = new Ball(params.m, params.r);
		
	}
	
}
