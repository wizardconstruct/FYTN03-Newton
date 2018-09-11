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
	
	public Ball (double mass, double radius) {
		
		this.m = mass;
		this.r = radius;
		
	}

}
