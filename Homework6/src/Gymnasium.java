import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * A particular kind of building where people play basketball and other sports.
 * 
 * @author Brian Walker
 * 
 */
public class Gymnasium extends Building implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7856710907202554416L;

	/**
	 * The constructor saves the upper and lower points of the rectangle.
	 * 
	 * @param x1
	 *            The x-coord of the upper point.
	 * @param y1
	 *            The y-coord of the upper point.
	 * @param x2
	 *            The x-coord of the lower point.
	 * @param y2
	 *            The y-coord of the lower point.
	 */
	public Gymnasium(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2, ControlPanel.gym);
	}

	/**
	 * How to draw an academic building by using the image of an 
	 * gymnasium.
	 * 
	 * @param g
	 *            The graphics object within which to draw the building.
	 */
	public void draw(Graphics g) {
		g.drawImage(SimU.gymnasium.getImage(), // the image
				upperX, upperY, // the upper left corner
				(lowerX - upperX), (lowerY - upperY), // the width and height
				Color.white, null); // the color of the background, and the
									// listener (none)
	}

}
