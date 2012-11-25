import java.awt.Graphics;
import java.io.Serializable;
import java.util.Calendar;

/**
 * A Person object has a current location (x,y), a possible destination location
 * (destinationX, destinationY), and a flag to indicate whether the person is
 * moving or not (isMoving).
 * 
 * @author Brian Walker
 */
public class Person implements Serializable{

	protected int x;
	protected int y;

	protected int destinationX;
	protected int destinationY;

	protected boolean isMoving = false;

	/**
	 * Initialize the instance variables.
	 * 
	 * @param xCoord
	 *            The starting location x-coord.
	 * @param yCoord
	 *            The starting location y-coord.
	 */
	public Person(int xCoord, int yCoord) {
		this.x = xCoord;
		this.y = yCoord;

		destinationX = xCoord;
		destinationY = yCoord;

		isMoving = false;
	}

	/**
	 * Get the x-coord.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Change the x-coord.
	 * 
	 * @param xCoord
	 *            the x to set
	 */
	public void setX(int xCoord) {
		this.x = xCoord;
	}

	/**
	 * Get the y-coord.
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the y-coord.
	 * 
	 * @param yCoord
	 *            the y to set
	 */
	public void setY(int yCoord) {
		this.y = yCoord;
	}

	/**
	 * Draw a person.
	 * 
	 * @param g
	 *            The graphics object.
	 */
	public void draw(Graphics g) {
		g.drawImage(SimU.personImage.getImage(), // the image
				x, y, // the upper left corner
				null); // the listener (none)
	}

	/**
	 * How to update a Person based on the calendar.
	 * 
	 * @param cal
	 *            The current date and time.
	 */
	public void update(Calendar cal) {
		// do nothing for a generic person
	}

	/**
	 * Are two numbers within a random distance of 0 and 5 of each other?
	 * 
	 * @param a
	 *            The first number.
	 * @param b
	 *            The second number.
	 * @return True if "close"; false, otherwise.
	 */
	public boolean isClose(int a, int b) {
		int ran = (int) (5 * Math.random());
		if (Math.abs(a - b) < ran)
			return true;
		else
			return false;
	}

}
