import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * A student is a kind of person. The only difference (now) between a student
 * and a Person is what happens during update.
 * 
 * @author Brian Walker
 * 
 */
public class Faculty extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6076709783275444403L;

	/**
	 * Call the parent constructor.
	 * 
	 * @param x
	 *            The x-coord.
	 * @param y
	 *            The y-coord.
	 */
	public Faculty(int x, int y) {
		super(x, y);
	}

	/**
	 * Draw the person image.
	 * 
	 * @param g
	 *            The graphics object.
	 */
	public void draw(Graphics g) {
		g.drawImage(SimU.walkingFaculty.getImage(), // the image
				x, y, // the upper left corner
				null); // the listener (none)
	}

	/**
	 * Update the Student based on the calendar.
	 * 
	 * @param cal
	 *            The current date and time.
	 */
	public void update(Calendar cal) {

		int hour = cal.get(Calendar.HOUR);
		int amPM = cal.get(Calendar.AM_PM);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		/* Time for teaching! */
		if (!isMoving && dayOfWeek >= Calendar.MONDAY
				&& dayOfWeek <= Calendar.FRIDAY && hour >= 10 && hour <= 12
				&& amPM == Calendar.AM) {

			// find an academic building

			// get all the academic buildings
			ArrayList<AcademicBuilding> academics = new ArrayList<AcademicBuilding>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof AcademicBuilding) {
					academics.add((AcademicBuilding) DrawingPanel.buildings
							.get(i));
				}
			}
			// pick one of them at random
			if (academics.size() > 0) {
				int ran = (int) (academics.size() * Math.random());
				destinationX = academics.get(ran).getUpperX();
				destinationY = academics.get(ran).getUpperY();
			} else {

				destinationX = 10; // run to corner
				destinationY = 10;
			}
		}

		/* Time for work (?) */
		if (!isMoving && hour >= 8 && amPM == Calendar.AM) { // go to bed

			// find a student center

			// get all the student center buildings
			ArrayList<StudentCenter> studentCenter = new ArrayList<StudentCenter>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof StudentCenter) {
					studentCenter.add((StudentCenter) DrawingPanel.buildings
							.get(i));
				}
			}
			// pick one of them at random
			if (studentCenter.size() > 0) {
				int ran = (int) (studentCenter.size() * Math.random());
				destinationX = studentCenter.get(ran).getUpperX();
				destinationY = studentCenter.get(ran).getUpperY();
			} else {

				destinationX = 550; // run to corner
				destinationY = 550;
			}
		}
		
		/* Time for the Administrative Work */
		if (!isMoving && dayOfWeek >= Calendar.MONDAY
				&& dayOfWeek <= Calendar.FRIDAY && hour >= 4 && hour <= 5
				&& amPM == Calendar.PM) {

			// find a Administrative building

			// get all the administrative buildings
			ArrayList<AdministrativeBuilding> administrativeBuilding = new ArrayList<AdministrativeBuilding>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof AdministrativeBuilding) {
					administrativeBuilding.add((AdministrativeBuilding) DrawingPanel.buildings
							.get(i));
				}
			}
			// pick one of them at random
			if (administrativeBuilding.size() > 0) {
				int ran = (int) (administrativeBuilding.size() * Math.random());
				destinationX = administrativeBuilding.get(ran).getUpperX();
				destinationY = administrativeBuilding.get(ran).getUpperY();
			} else {

				destinationX = 10; // run to corner
				destinationY = 10;
			}
		}

		/* Are we there yet? */
		if (!isClose(x, destinationX) || !isClose(y, destinationY)) {
			isMoving = true;
			if (x < destinationX)
				x += 2;
			if (x > destinationX)
				x -= 2;
			if (y > destinationY)
				y -= 2;
			if (y < destinationY)
				y += 2;
		} else {
			isMoving = false;
		}
	}

}
