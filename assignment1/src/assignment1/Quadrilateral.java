package assignment1;

import java.awt.Graphics;
import java.util.ArrayList;

public class Quadrilateral extends GeometricObject{
	public ArrayList<Point> points;
	
	public Quadrilateral(ArrayList<Point> points) {
		this.points = points;
	}
	
	public Point getVertex(int i) {
		return points.get(i);
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
						(int)points.get(2).getX(),
						(int)points.get(3).getX()
				},
				new int[] {
						(int)points.get(1).getY(),
						(int)points.get(1).getY(),
						(int)points.get(2).getY(),
						(int)points.get(3).getY()
				},
				points.size());
		
		g.setColor(getBoundaryColor());
		g.drawPolygon(
				new int[] {
						(int)points.get(0).getX(), 
						(int)points.get(1).getX(), 
						(int)points.get(2).getX(),
						(int)points.get(3).getX()
				},
				new int[] {
						(int)points.get(1).getY(),
						(int)points.get(1).getY(),
						(int)points.get(2).getY(),
						(int)points.get(3).getY()
				},
				points.size());
	}
	
	public String toString() {
		String str = "Non-Rectangle Quadrilateral " + super.toString() + "\n";
		str += getVertex(0) + "\n" + getVertex(1) + "\n" + getVertex(2) + "\n" + getVertex(3);
		return str;
	}
}
