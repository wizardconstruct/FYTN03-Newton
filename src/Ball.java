// Ball object for containing dynamic variables and possibly if we want the ability to simulate multiple types of balls at the same time

public class Ball {
	
	// The convention in Java is to set all variables private and use get() and set() methods, but we don't have to worry about these things in this small of a project
	
	double t = 0;
	double x = 0;
	double y = 0;
	double v_x = 0;
	double v_y = 0;
	double m = 0;
	double r = 0;
        
        /*
        Todo: Add Cd, A and B2 as local variables?
        */
	
        Params params = new Params();
        
	public Ball (double mass, double radius) {
		
            this.m = params.m;
            this.r = params.r;
/*
		this.m = mass;
		this.r = radius;
*/
		
	}
        
    public double getV(){
        return Math.sqrt(Math.pow(v_x, 2)+Math.pow(v_y, 2));
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getV_x() {
        return v_x;
    }

    public void setV_x(double v_x) {
        this.v_x = v_x;
    }

    public double getV_y() {
        return v_y;
    }

    public void setV_y(double v_y) {
        this.v_y = v_y;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
