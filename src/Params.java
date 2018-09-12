
public class Params {
	
	// Simulation
	
	public double h = 1e-2;			// [s]
	public double v_x_0 = 3.0; 		// Initial velocity in x
	public double v_y_0 = 5.0;		// Initial velocity in y
	
	// Constants
	
	public double g = 9.81; 		// [m/s]
	public double eta = 1.8e-5; 	// [kg/(m*s)]
	
	public double r = 0.22; 			// [m]
	public double m = 0.45;			// [kg]
	public double c = 0.47;			// [-]
	
	public double y_0 = 2.0;		// [m]
        
        public double rho = 1.225;              // [kg/m^3]        
        public double Cd = 0.13;                // Used this as source https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3657093/
        public double A = Math.PI*Math.pow(r, 2);
        public double B2 = 0.5*Cd*rho*A;
        
        //Experiment
        
        public double R = 15.08;                // [m]
        public double maxHeight = 2.51;         // [m]
        public double T = 16.67;                // [s]
}
