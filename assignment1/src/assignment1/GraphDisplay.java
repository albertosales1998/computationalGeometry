package assignment1;

import javax.swing.*;
import java.awt.*;


/**
 * Defines the panel the drawings will be made in.
 * 
 * @author Prof. Antonio Hernandez
 */
public class GraphDisplay extends JPanel
{   
    Point p;
    GeometricObject[] objects;
    GeometricObject object;
    
    
    public GraphDisplay(int frameWidth, int frameHeight, Point p) {
    	this.p = p;
    	
    	Dimension d = new Dimension(frameWidth, frameHeight);
    	setPreferredSize(d);
    }

    public GraphDisplay(int width, int height, GeometricObject[] g) {
		// TODO Auto-generated constructor stub
    	this.objects = g;
    	
    	Dimension d = new Dimension(width, height);
    	setPreferredSize(d);
	}
    
    public GraphDisplay(int width, int height, GeometricObject g) {
		// TODO Auto-generated constructor stub
    	this.object = g;
    	
    	Dimension d = new Dimension(width, height);
    	setPreferredSize(d);
	}

	/**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    public void paint(Graphics g)
    {        
        super.paint(g);
        object.draw(g);
    }
}