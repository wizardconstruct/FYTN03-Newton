
public class Params {
	
	// Simulation
	
	public double h = 1e-2;			// [s]
	public double v_x_0 = 0.0; 		// Initial velocity in x
	public double v_y_0 = 5.0;		// Initial velocity in y
	
	// Constants
	
	public double g = 9.81; 		// [m/s]
	public double eta = 1.8e-5; 	// [kg/(m*s)]
	
	public double r = 0.0; 			// [m]
	public double m = 0.0;			// [kg]
	public double c = 0.47;			// [-]
	
	public double y_0 = 2.0;		// [m]
        
        //Experiment
        
        public double R = 15.08;                // [m]
        public double maxHeight = 2.51;         // [m]
        public double T = 16.67;                // [s]
}
