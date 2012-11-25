import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * A building is essentially a rectangle.
 * 
 * @author Brian Walker
 * 
 */
public class Building implements Serializable{

	protected int upperX;
	protected int upperY;
	protected int lowerX;
	protected int lowerY;

	protected int theDrawingTool;

	/**
	 * The constructor saves the upper and lower corner points of the rectangle.
	 * 
	 * @param x1
	 *            The x-coord of the upper point.
	 * @param y1
	 *            The y-coord of the upper point.
	 * @param x2
	 *            The x-coord of the lower point.
	 * @param y2
	 *            The y-coord of the lower point.
	 * @param drawingTool
	 *            The tool used to draw this building
	 */
	public Building(int x1, int y1, int x2, int y2, int drawingTool) {
		upperX = x1;
		upperY = y1;
		lowerX = x2;
		lowerY = y2;
		theDrawingTool = drawingTool;

	}

	/**
	 * Get the upper x-coord.
	 * 
	 * @return the upperX
	 */
	public int getUpperX() {
		return upperX;
	}

	/**
	 * Set the upper x-coord.
	 * 
	 * @param x
	 *            the upperX to set
	 */
	public void setUpperX(int x) {
		this.upperX = x;
	}

	/**
	 * Return the upper y-coord.
	 * 
	 * @return the upperY
	 */
	public int getUpperY() {
		return upperY;
	}

	/**
	 * Set the upper y-coord.
	 * 
	 * @param y
	 *            the upperY to set
	 */
	public void setUpperY(int y) {
		this.upperY = y;
	}

	/**
	 * Return the lower x-coord.
	 * 
	 * @return the lowerX
	 */
	public int getLowerX() {
		return lowerX;
	}

	/**
	 * Set the lower x-coord.
	 * 
	 * @param x
	 *            the lowerX to set
	 */
	public void setLowerX(int x) {
		this.lowerX = x;
	}

	/**
	 * Return the lower y-coord.
	 * 
	 * @return the lowerY
	 */
	public int getLowerY() {
		return lowerY;
	}

	/**
	 * Set the lower y-coord.
	 * 
	 * @param y
	 *            the lowerY to set
	 */
	public void setLowerY(int y) {
		this.lowerY = y;
	}

	/**
	 * Calculates the width of the rectangle.
	 * 
	 * @return The width (in pixels)
	 */
	public int width() {
		return lowerX - upperX;
	}

	/**
	 * Calculates the height of the rectangle.
	 * 
	 * @return The height (in pixels)
	 */
	public int height() {
		return lowerY - upperY;
	}

	/**
	 * Calculates the area of the rectangle.
	 * 
	 * @return The area (in pixels)
	 */
	public int area() {
		return width() * height();
	}
	
	/**
	 * returns boolean of whether building contains point.
	 * 
	 * @param p
	 * 		The point to test.
	 * 
	 * @return
	 * 		If building contains point boolean.
	 */

	/**
	 * How to draw a rectangle. By default, it is cyan.
	 * 
	 * @param g
	 *            The graphics object of the surface to draw on.
	 */
	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(upperX, upperY, lowerX - upperX, lowerY - upperY);
	}

}
