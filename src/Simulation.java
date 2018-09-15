
import java.io.*;

// In case we want to run multiple simulations at the same time (such as with and without air resistance) this could be its own module

public class Simulation {
	private Params params;
	private boolean useResistance;
	private boolean useB1;
        private double phi;
        private double v_start;
        private String name;
        private double y_max;

	public Simulation(boolean useResistance, double phi, double v_start) {
            
                this(useResistance, false, phi, v_start);

	};
	
	public Simulation(boolean useResistance, boolean useB1, double phi, double v_start) {

		this.params = new Params();
		this.useResistance = useResistance;
		this.useB1 = useB1;
                this.phi = phi;
                this.v_start = v_start;
                name = "_v"+v_start+"_phi"+phi;

	};

	public Simulation(boolean useResistance, boolean useB1, double phi, double v_start, double h) {
		this.params = new Params();
		this.useResistance = useResistance;
		this.useB1 = useB1;
                this.phi = phi;
                this.v_start = v_start;
                this.params.h = h;
	}

	public double run() throws IOException, FileNotFoundException{
		
//		String filename;
//		if(useResistance){
//			if (useB1) {
//				filename = "resistance"+name+".dat";
//			} else {
//				filename = "partialresistance"+name+".dat";
//			}
//		} else {
//			filename = "noresistance"+name+".dat";
//		}

//		BufferedWriter w = new BufferedWriter(new FileWriter(filename));
//		BufferedWriter errorw = new BufferedWriter(new FileWriter("error_"+filename));

		Ball ball = new Ball(params.m, params.r, params.Cd);
		ball.setV_x(v_start*Math.cos(Math.PI*phi/180));
		ball.setV_y(v_start*Math.sin(Math.PI*phi/180));
		ball.setY(params.y_0);
		
		// Second ball that moves with twice the step length for error calculation
		Ball ball_2h = new Ball(params.m, params.r, params.Cd);
		ball_2h.setV_x(v_start*Math.cos(Math.PI*phi/180));
		ball_2h.setV_y(v_start*Math.sin(Math.PI*phi/180));
		ball_2h.setY(params.y_0);

		// Couldn't decide if this is for the ball or for the simulation object to keep track of
		double B1 = 6.*Math.PI*params.eta*ball.getR()/ball.getM();
		double B2 = 0.5*ball.getCd()*params.rho*ball.getA()/ball.getM();
		if (!useResistance) {
			B1 = 0;
			B2 = 0;
		} else if (!useB1) {
			B1 = 0;
		}
		
		RungeKutta rk = new RungeKutta(B1, B2);
		double error_x = 0;
		double error_y = 0;

//		w.write("Time\tX position\tY position\t");
//		w.newLine();

                y_max = 0;
                
		int iteration = 0;		
		while(ball.getY() > 0){
			iteration++;
//			System.out.println("loop "+iteration);
//			w.write(ball.getT()+"\t"+ball.getX()+"\t"+ball.getY()+"\t");
//			w.newLine();
                        
			double t = ball.getT()+params.h;
			double x  = ball.getX()+params.h*ball.getV_x();
			double y = ball.getY()+params.h*ball.getV_y();
                        
                        if(y>y_max){
                            y_max = y;
                        }

			// Runge-Kutta
//			double k1_v_x = params.h*(-B1*ball.getV_x()-B2*Math.sqrt(Math.pow(ball.getV_x(), 2)+Math.pow(ball.getV_y(), 2))*ball.getV_x());
//			double k2_v_x = params.h*(-B1*(ball.getV_x()+k1_v_x/2)-B2*Math.sqrt(Math.pow(ball.getV_x()+k1_v_x/2, 2)+Math.pow(ball.getV_y(), 2))*(ball.getV_x()+k1_v_x/2));
//			double k3_v_x = params.h*(-B1*(ball.getV_x()+k2_v_x/2)-B2*Math.sqrt(Math.pow(ball.getV_x()+k2_v_x/2, 2)+Math.pow(ball.getV_y(), 2))*(ball.getV_x()+k2_v_x/2));
//			double k4_v_x = params.h*(-B1*(ball.getV_x()+k3_v_x)-B2*Math.sqrt(Math.pow(ball.getV_x()+k3_v_x, 2)+Math.pow(ball.getV_y(), 2))*(ball.getV_x()+k3_v_x));
//			double v_x = ball.getV_x()+k1_v_x/6+k2_v_x/3+k3_v_x/3+k4_v_x/6;
//
//			double k1_v_y = params.h*(-params.g-B1*ball.getV_y()-B2*Math.sqrt(Math.pow(ball.getV_x(), 2)+Math.pow(ball.getV_y(), 2))*ball.getV_y());
//			double k2_v_y = params.h*(-params.g-B1*(ball.getV_y()+k1_v_y/2)-B2*Math.sqrt(Math.pow(ball.getV_x(), 2)+Math.pow(ball.getV_y()+k1_v_y/2, 2))*(ball.getV_y()+k1_v_y/2));
//			double k3_v_y = params.h*(-params.g-B1*(ball.getV_y()+k2_v_y/2)-B2*Math.sqrt(Math.pow(ball.getV_x(), 2)+Math.pow(ball.getV_y()+k2_v_y/2, 2))*(ball.getV_y()+k2_v_y/2));
//			double k4_v_y = params.h*(-params.g-B1*(ball.getV_y()+k3_v_y)-B2*Math.sqrt(Math.pow(ball.getV_x(), 2)+Math.pow(ball.getV_y()+k3_v_y, 2))*(ball.getV_y()+k3_v_y));
//			double v_y = ball.getV_y()+k1_v_y/6+k2_v_y/3+k3_v_y/3+k4_v_y/6;

                        double v_x = ball.getV_x()+rk.step_v(ball.getV_x(), ball.getV_y(), 0, params.h);
                        double v_y = ball.getV_y()+rk.step_v(ball.getV_y(), ball.getV_x(), params.g, params.h);

			ball.setT(t);
			ball.setX(x);
			ball.setY(y);
			ball.setV_x(v_x);
			ball.setV_y(v_y);
			
			// Every second iteration, record truncation error of the step
			if ((iteration % 2) == 0) {
				ball_2h.setT(t);
				ball_2h.setX(ball_2h.getX() + ball_2h.getV_x()*2*params.h); //rk.step_x(ball_2h.getV_x(), 2*params.h));
				ball_2h.setY(ball_2h.getY() + ball_2h.getV_y()*2*params.h); //rk.step_x(ball_2h.getV_y(), 2*params.h));
				ball_2h.setV_x(ball_2h.getV_x() + rk.step_v(ball_2h.getV_x(), ball_2h.getV_y(), 0, 2*params.h));
				ball_2h.setV_y(ball_2h.getV_y() + rk.step_v(ball_2h.getV_y(), ball_2h.getV_x(), params.g, 2*params.h));
				error_x = Math.abs(ball.getX()-ball_2h.getX())/(Math.pow(2, 5)-1);
				error_y = Math.abs(ball.getY()-ball_2h.getY())/(Math.pow(2, 5)-1);
				
//				errorw.write(ball.getT()+"\t"+error_x+"\t"+error_y);
//				errorw.newLine();
			}
		}
//		w.close();
//		errorw.close();
//                System.out.println("v = "+v_start+"\tphi = "+phi+"\tt = "+ball.getT()+"\ty = "+y_max);
                System.out.format("v = %.4f \tphi = %.4f \tt = %.4f \tR = %.4f\ty = %.4f%n", v_start, phi, ball.getT(),ball.getX(), y_max);
                
                return error_y;
	}

}
