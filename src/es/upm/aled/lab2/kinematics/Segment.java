package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing one node in the GUI that paints the exoskeleton bones on
 * the screen. Each node is identified by its absolute coordinates (remember
 * that in screen space, positive Y points down). Every Node has a List of their
 * children Nodes; those it's connected to.
 * 
 * @author rgarciacarmona
 */

public class Segment {
	private double lenght;
	private double angle;
	private List<Segment> children;
	
	/**
	 * Builds a new Node from its absolute position.
	 * 
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 */
	public Segment(double lenght, double angle) {
		this.lenght = lenght;
		this.angle = angle;
		this.children = new ArrayList<>();
	}
	
	/**
	 * Returns the lenght.
	 * 
	 * @return lenght in cm of the segment.
	 */
	public double getLenght() {
		return lenght;
	}
	
	/**
	* Returns the angle the segment forms with the father segment.
	 * 
	 * @return The angle.
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * Returns the angle the segment forms with the father segment.
	 * 
	 * @return The angle.
	 */
	public List<Segment> getChildren() {
		return children;
	}
	
	/**
	 * Returns the X coordinate.
	 * 
	 * @return The X coordinate.
	 */
	public void setLenght(double lenght) {
		this.lenght = lenght;
	}
	
	/**
	 * Returns the X coordinate.
	 * 
	 * @return The X coordinate.
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	/**
	 * Adds a new Node to the List of Nodes this one is connected to. Each Node can
	 * only appear as a child once.
	 * 
	 * @param measurement The Node to be added.
	 */
	public void addChild(Segment child) {
		if(children.contains(child)) {
			System.out.println("El segmento ya está incluido");
		}else
		children.add(child);
	}

	
}
