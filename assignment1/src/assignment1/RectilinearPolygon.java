package assignment1;

import java.awt.Graphics;
import java.util.ArrayList;

public class RectilinearPolygon extends GeometricObject{
	public ArrayList<Point> points;
	
	public RectilinearPolygon(ArrayList<Point> points) {
		this.points = points;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public Point getVertex(int i) {
		return points.get(i);
	}
	
	public int[] getXCoordinates() {
		int[] xCoordinates = new int[points.size()];
		for(int i = 0; i < points.size(); i++) xCoordinates[i] = (int) points.get(i).getX(); 
		return xCoordinates;
	}
	
	public int[] getYCoordinates() {
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
	
	public String toString() {
		String str = "Rectilinear Polygon " + super.toString() + "\n";
		for(int i = 0; i < points.size(); i++) str += getVertex(i) + "\n";
		
		return str;
	}
}
