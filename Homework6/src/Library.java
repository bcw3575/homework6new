import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * A particular kind of building where books are stored.
 * 
 * @author Brian Walker
 * 
 */
public class Library extends Building implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8042846148614298488L;

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
	public Library(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2, ControlPanel.library);
	}

	/**
	 * How to draw an library by using the image of a library building.
	 * 
	 * @param g
	 *            The graphics object within which to draw the library.
	 */
	public void draw(Graphics g) {
		g.drawImage(SimU.libraryImage.getImage(), // the image
				upperX, upperY, // the upper left corner
				(lowerX - upperX), (lowerY - upperY), // the width and height
				null, null); // the color of the background, and the
									// listener (none)
	}

}
