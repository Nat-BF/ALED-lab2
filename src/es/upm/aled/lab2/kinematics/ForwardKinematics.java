package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree
	public static Node computePositions(Segment root, double originX, double originY) {
		// TODO: Implemente este método
		
		Node nodo = computePositions(root, originX, originY, 0.0);
		return nodo;
	}

	// Private helper method that implements the recursive algorithm
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
		Node nodoBase = new Node(baseX, baseY);
		accumulatedAngle += link.getAngle();
		double coordNodoX = baseX + link.getLenght()*Math.cos(accumulatedAngle);
		double coordNodoY = baseY + link.getLenght()*Math.sin(accumulatedAngle);
		Node nodoFinal = new Node(coordNodoX, coordNodoY);
		
		//Caso base: si el segmento no tiene hijos
		if (link.getChildren().size() == 0) {
			return nodoFinal;
		}
		
		nodoBase.getChildren().add(nodoFinal);

		for (Segment child : link.getChildren()) {
			computePositions(child, nodoFinal.getX(), nodoFinal.getY(), accumulatedAngle);
		}
		return nodoBase;
		
	}
}