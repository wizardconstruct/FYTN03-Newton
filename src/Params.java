
public class Params {
    
//    v = 14.4233 	phi = 37.4667 	t = 1.6600 	R = 15.0797
	// Simulation

	public double h = 1e-2;			// [s]
	public double y_0 = 0.1;		// [m]
	
	public double v = 15.0;			// Initial velocity magnitude
	public double phi = 30.0;		// Initial angle of trajectory
	
	public double v_x_0 = 0.0 + v*Math.cos(Math.PI*phi/180); 		// Initial velocity in x
	public double v_y_0 = 0.0 + v*Math.sin(Math.PI*phi/180);		// Initial velocity in y

	//Experiment

	public double r = 0.22; 		// [m]
	public double m = 0.45;			// [kg]
	public double R = 15.08;		// [m]
	public double maxHeight = 2.51;	// [m]
	public double T = 1.667;		// [s]

	// Constants

	public double g = 9.81; 		// [m/s]
	public double eta = 1.8e-5;             // [kg/(m*s)]
	public double rho = 1.225;		// [kg/m^3]        
	public double Cd = 0.13;		// Used this as source https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3657093/
	
	// Derived constants
	
//	public double A = Math.PI*Math.pow(r, 2);
//	public double B2 = 0.5*Cd*rho*A;
}
