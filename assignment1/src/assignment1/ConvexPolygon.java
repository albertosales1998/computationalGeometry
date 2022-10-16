package assignment1;

import java.awt.Graphics;
import java.util.ArrayList;

public class ConvexPolygon extends GeometricObject{
	private ArrayList<Point> points;
	
	public ConvexPolygon(ArrayList<Point> points) {
		this.points = points;
	}

	public Point getVertex(int i) {
		return points.get(i);
	}
	
	private int[] getXCoordinates() {
		int[] xCoordinates = new int[points.size()];
		for(int i = 0; i < points.size(); i++) xCoordinates[i] = (int) points.get(i).getX(); 
		return xCoordinates;
	}
	
	private int[] getYCoordinates() {
		int[] yCoordinates = new int[points.size()];
		for(int i = 0; i < points.size(); i++) yCoordinates[i] = (int) points.get(i).getY(); 
		return yCoordinates;
	}
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		//setting x and y value arrays for parameters in the method
		g.setColor(getInteriorColor());
		g.fillPolygon(getXCoordinates(), getYCoordinates(), points.size());
		
		g.setColor(getBoundaryColor());
		g.drawPolygon(getXCoordinates(), getYCoordinates(), points.size());
	}

	public String getShapeName(){
		return "This shape is a convex polygon";
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Convex Polygon " + super.toString() + "\n");
		for(int i = 0; i < points.size(); i++) str.append(getVertex(i)).append("\n");
		
		return str.toString();
	}
}

