package assignment1;

import javax.swing.*;

/**
 * Defines a frame to which a panel with drawings will be added.
 * 
 * @author Prof. Antonio Hernandez
 */
public class FrameDisplay extends JFrame
{   
    
    int HEIGHT = 1000;
    int WIDTH = 1000;
    
    private GraphDisplay panel;
    
    public FrameDisplay(Point p) {
    	setTitle("Graph Display");
    	setSize(WIDTH, HEIGHT);
    	
    	panel = new GraphDisplay(WIDTH, HEIGHT, p);
    	add(panel);
    	pack();
    	
    }
    
    public FrameDisplay(GeometricObject[] g) {
		// TODO Auto-generated constructor stub
    	setTitle("Graph Display");
    	setSize(WIDTH, HEIGHT);
    	
    	panel = new GraphDisplay(WIDTH, HEIGHT, g);
    	add(panel);
    	pack();
	}
    
    public FrameDisplay(GeometricObject g) {
		// TODO Auto-generated constructor stub
    	setTitle("Graph Display");
    	setSize(WIDTH, HEIGHT);
    	
    	panel = new GraphDisplay(WIDTH, HEIGHT, g);
    	add(panel);
    	pack();
	}

	public void repaint()
    {
        panel.repaint();
    }
}