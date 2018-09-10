
public class NewtonODE {
	
	public NewtonODE() {
		
	}
	
	
	
	public double solve_vy(Params params, double velocity) {
		
		return velocity - params.g * params.h; 
		
	}

}
