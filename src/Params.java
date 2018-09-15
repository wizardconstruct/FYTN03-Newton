
public class Params {

	// Simulation

	public double h = 1e-3;			// [s]
	public double y_0 = 0.001;		// [m]

	public double v = 15.0;			// Initial velocity magnitude
	public double phi = 45.0;		// Initial angle of trajectory

	public double v_x_0 = 0.0 + v*Math.cos(Math.PI*phi/180); 		// Initial velocity in x
	public double v_y_0 = 0.0 + v*Math.sin(Math.PI*phi/180);		// Initial velocity in y

	//Experiment

	public double r = 0.11; 		// [m]
	public double m = 0.45;			// [kg]
	public double R = 15.08;		// [m]
	public double maxHeight = 2.51;	// [m]
	public double T = 1.667;		// [s]

	// Constants

	public double g = 9.81; 		// [m/s]
	public double eta = 1.8e-5;		// [kg/(m*s)]
	public double rho = 1.2;		// [kg/m^3]        
	public double Cd = 0.13;		// Used this as source https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3657093/
}
