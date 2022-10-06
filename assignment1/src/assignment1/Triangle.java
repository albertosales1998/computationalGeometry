package assignment1;

import java.awt.Graphics;
import java.util.ArrayList;

public class Triangle extends GeometricObject{
	ArrayList<Point> points;
	
	public Triangle(ArrayList<Point> points) {
		this.points = points;
	}
	
	public Point getBegin() {
		return points.get(0);
	}
	
	public Point getEnd() {
		return points.get(2);
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		//setting x and y value arrays for parameters in the method
		g.setColor(getInteriorColor());
		g.fillPolygon(
				new int[] {
						(int)points.get(0).getX(), 
						(int)points.get(1).getX(), 
						(int)points.get(2).getX()
				},
				new int[] {
						(int)points.get(1).getY(),
						(int)points.get(1).getY(),
						(int)points.get(2).getY()
				},
				points.size());
		
		g.setColor(getBoundaryColor());
		g.drawPolygon(
				new int[] {
						(int)points.get(0).getX(), 
						(int)points.get(1).getX(), 
						(int)points.get(2).getX(),
				},
				new int[] {
						(int)points.get(1).getY(),
						(int)points.get(1).getY(),
						(int)points.get(2).getY()
				},
				points.size());
	}
	
	public String toString() {
		String str = "Triangle " + super.toString() + "\n";
		str += getBegin() + "\n" + getEnd();
		return str;
	}
	

}
