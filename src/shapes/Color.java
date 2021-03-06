package src.shapes;

/*
 * A class with static methods for manipulating colors stored as standard RGB integers
 */
public class Color {
	public static final double RATIO = 1.0 / 255.0;
	
	// Methods to split the integer into its components
	public static int getR(int color) {return (color >> 16) & 0xff;}
	public static int getG(int color) {return (color >>  8) & 0xff;}
	public static int getB(int color) {return (color      ) & 0xff;}
	
	// Methods to merge three components into a color
	public static int toColor(int r, int g, int b) {return (r << 16) | (g << 8) | b;}
	public static int toColor(double r, double g, double b) {return ((int)(r * 255) << 16) | ((int)(g * 255) << 8) | (int)(b * 255);}
	
	// Shading a color by a value between 0 and 1
	public static int shade(int color, double shade) {
		return ((int)((double)getR(color) * shade) << 16) |
			   ((int)((double)getG(color) * shade) << 8) |
			   (int)((double)getB(color) * shade);
	}
	
	// Shading the components of a color by values between 0 and 1
	public static int shade(int color, double shadeR, double shadeG, double shadeB) {
		return ((int)((double)getR(color) * shadeR) << 16) |
			   ((int)((double)getG(color) * shadeG) << 8) |
			   (int)((double)getB(color) * shadeB);
	}
	
	// Shading the components of a color by corresponding components of a vector
	public static int shade(int color, Vector v) {
		return ((int)((double)getR(color) * v.getX()) << 16) |
			   ((int)((double)getG(color) * v.getY()) << 8) |
			   (int)((double)getB(color) * v.getX());
	}
	
	// Shading a color by another color
	public static int shade(int color, int shade) {
		return ((int)((double)(getR(color) * getR(shade)) * RATIO) << 16) |
			   ((int)((double)(getG(color) * getG(shade)) * RATIO) << 8) |
			   (int)((double)(getB(color) * getB(shade)) * RATIO);
	}
	
	public static int invert(int color) {return 0xffffff - color;}
}