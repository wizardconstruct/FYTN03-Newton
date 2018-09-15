// Callable version of RK

public class RungeKutta {

	private double B1 = 0;
	private double B2 = 0;

	public RungeKutta(double B1, double B2) {		
		this.B1 = B1;
		this.B2 = B2;		
	}

	public double step_v(double v_a, double v_b, double a, double h) {
		double k1 = h*(-a-B1*v_a-B2*Math.sqrt(Math.pow(v_b, 2)+Math.pow(v_a, 2))*v_a);
		double k2 = h*(-a-B1*(v_a+k1/2)-B2*Math.sqrt(Math.pow(v_b, 2)+Math.pow(v_a+k1/2, 2))*(v_a+k1/2));
		double k3 = h*(-a-B1*(v_a+k2/2)-B2*Math.sqrt(Math.pow(v_b, 2)+Math.pow(v_a+k2/2, 2))*(v_a+k2/2));
		double k4 = h*(-a-B1*(v_a+k3)-B2*Math.sqrt(Math.pow(v_b, 2)+Math.pow(v_a+k3, 2))*(v_a+k3));
		return k1/6+k2/3+k3/3+k4/6;
	}

}
