
public class Params {

	// Simulation

	public double h = 1e-2;			// [s]
	public double y_0 = 0.1;		// [m]
	public double v_x_0 = 10.5; 		// Initial velocity in x
	public double v_y_0 = 7.5;		// Initial velocity in y

	//Experiment

	public double r = 0.22; 		// [m]
	public double m = 0.45;			// [kg]
	public double R = 15.08;		// [m]
	public double maxHeight = 2.51;	// [m]
	public double T = 1.667;		// [s]

	// Constants

	public double g = 9.81; 		// [m/s]
	public double eta = 1.8e-5; 	// [kg/(m*s)]
	public double rho = 1.225;		// [kg/m^3]        
	public double Cd = 0.13;		// Used this as source https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3657093/
	
	// Derived constants
	
//	public double A = Math.PI*Math.pow(r, 2);
//	public double B2 = 0.5*Cd*rho*A;
}
