
import java.io.*;

// In case we want to run multiple simulations at the same time (such as with and without air resistance) this could be its own module

public class Simulation {
	private Params params;
	private boolean useResistance;
	
	public Simulation(boolean useResistance) {
		
		this.params = new Params();
		this.useResistance = useResistance;
		
	};
	
	public void run() throws IOException, FileNotFoundException{
            System.out.println("running");
            BufferedWriter w = new BufferedWriter(new FileWriter("resistance.dat"));
		
            Ball ball = new Ball(params.m, params.r);
            if(useResistance){
                ball.setV_x(params.v_x_0);
                ball.setV_y(params.v_y_0);
                ball.setY(params.y_0);

                w.write("Time\tX position\tY position\t");
                w.newLine();

                while(ball.getY() > 0){
                    System.out.println("loop");
                    w.write(ball.getT()+"\t"+ball.getX()+"\t"+ball.getY());
                    w.newLine();

/*
                    //Euler
                    // Calculate new values
                    double t = ball.getT()+params.h;
                    double x = ball.getX()+params.h*ball.getV_x();
                    double y = ball.getY()+params.h*ball.getV_y();
                    double v_x = ball.getV_x()-params.h*params.B2*ball.getV()*ball.getV_y()/ball.getM();
                    double v_y = ball.getV_y()-params.h*params.g-params.h*params.B2*ball.getV()*ball.getV_y()/ball.getM();

                    // Set new values
                    ball.setT(t);
                    ball.setX(x);
                    ball.setY(y);
                    ball.setV_x(v_x);
                    ball.setV_y(v_y);
*/
                    
                    // Runge-Kutta
                    double t = ball.getT()+params.h;
                    
                    double k1_x = params.h*ball.getV_x();
                    double k2_x = params.h*(ball.getV_x()+k1_x/2);
                    double k3_x = params.h*(ball.getV_x()+k2_x/2);
                    double k4_x = params.h*(ball.getV_x()+k3_x);
                    double x = ball.getX()+k1_x/6+k2_x/3+k3_x/3+k4_x/6;
                    
                    double k1_y = params.h*ball.getV_y();
                    double k2_y = params.h*(ball.getV_y()+k1_y/2);
                    double k3_y = params.h*(ball.getV_y()+k2_y/2);
                    double k4_y = params.h*(ball.getV_y()+k3_y);
                    double y = ball.getY()+k1_y/6+k2_y/3+k3_y/3+k4_y/6;
                    
                    double k1_v_x = params.h*-params.B2*Math.sqrt(Math.pow(ball.getV_x(), 2)+Math.pow(ball.getV_y(), 2))*ball.getV_y()/ball.getM();
                    double k2_v_x = params.h*-params.B2*Math.sqrt(Math.pow(ball.getV_x()+k1_v_x/2, 2)+Math.pow(ball.getV_y()+k1_v_x/2, 2))*(ball.getV_y()+k1_v_x/2)/ball.getM();
                    double k3_v_x = params.h*-params.B2*Math.sqrt(Math.pow(ball.getV_x()+k2_v_x/2, 2)+Math.pow(ball.getV_y()+k2_v_x/2, 2))*(ball.getV_y()+k2_v_x/2)/ball.getM();
                    double k4_v_x = params.h*-params.B2*Math.sqrt(Math.pow(ball.getV_x()+k3_v_x, 2)+Math.pow(ball.getV_y()+k3_v_x, 2))*(ball.getV_y()+k3_v_x)/ball.getM();
                    double v_x = ball.getV_x()+k1_v_x/6+k2_v_x/3+k3_v_x/3+k4_v_x/6;
                    
                    double k1_v_y = params.h*(-params.g-params.B2*Math.sqrt(Math.pow(ball.getV_y(), 2)+Math.pow(ball.getV_y(), 2))*ball.getV_y()/ball.getM());
                    double k2_v_y = params.h*(-params.g-params.B2*Math.sqrt(Math.pow(ball.getV_y()+k1_v_y/2, 2)+Math.pow(ball.getV_y()+k1_v_y/2, 2))*(ball.getV_y()+k1_v_y/2)/ball.getM());
                    double k3_v_y = params.h*(-params.g-params.B2*Math.sqrt(Math.pow(ball.getV_y()+k2_v_y/2, 2)+Math.pow(ball.getV_y()+k2_v_y/2, 2))*(ball.getV_y()+k2_v_y/2)/ball.getM());
                    double k4_v_y = params.h*(-params.g-params.B2*Math.sqrt(Math.pow(ball.getV_y()+k3_v_y, 2)+Math.pow(ball.getV_y()+k3_v_y, 2))*(ball.getV_y()+k3_v_y)/ball.getM());
                    double v_y = ball.getV_y()+k1_v_y/6+k2_v_y/3+k3_v_y/3+k4_v_y/6;
                    
                    ball.setT(t);
                    ball.setX(x);
                    ball.setY(y);
                    ball.setV_x(v_x);
                    ball.setV_y(v_y);
                }
            }
            w.close();
		
	}
	
}
