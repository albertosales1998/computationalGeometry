package assignment1;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends GeometricObject{
	
	private double x;
	private double y;
    private Color boundaryColor;  
    private Color interiorColor; 
	
	public Point() {
		x = y = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
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

	@Override
	public String toString() {
		return "Point (" + x + ", " + y + ") " + super.toString();
	}
	
	public void draw(Graphics g) {
		int radius = 5;
		
		g.setColor(getInteriorColor());
		g.fillOval((int)x - radius, (int)y - radius, 2*radius, 2*radius);
		g.setColor(getBoundaryColor());
		g.drawOval((int)x - radius, (int)y - radius, 2*radius, 2*radius);
	}

	public Color getBoundaryColor() {
		return this.boundaryColor;
	}
	
	public void setBoundaryColor(Color boundaryColor) {
		this.boundaryColor = boundaryColor;
	}

	public Color getInteriorColor() {
		// TODO Auto-generated method stub
		return this.interiorColor;
	}

	public void setInteriorColor(Color color) {
		// TODO Auto-generated method stub
		this.interiorColor = color;
	}

	@Override
	public String getShapeName(){
		return "This shape is a point";
	}
	
	public void rotate(double angle) {
		double angleRadians = Math.toRadians(angle);
		
		double sine = Math.sin(angleRadians);
		double cosine = Math.cos(angleRadians);
		
		double x1 = x*cosine - y*sine;
		double y1 = x*sine + y*cosine;
		
		x = x1;
		y = y1;
	}
}