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
public class Student extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8499428356567414067L;

	/**
	 * Call the parent constructor.
	 * 
	 * @param x
	 *            The x-coord.
	 * @param y
	 *            The y-coord.
	 */
	public Student(int x, int y) {
		super(x, y);
	}

	/**
	 * Draw the person image.
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
	 * Update the Student based on the calendar.
	 * 
	 * @param cal
	 *            The current date and time.
	 */
	public void update(Calendar cal) {

		int hour = cal.get(Calendar.HOUR);
		int amPM = cal.get(Calendar.AM_PM);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		/* Time for class! Monday - Friday 8am-12pm*/
		if (!isMoving && dayOfWeek >= Calendar.MONDAY
				&& dayOfWeek <= Calendar.FRIDAY && hour >= 8 && hour <= 12
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

		/* Time for water or green space! Monday - Friday 3pm-8pm*/
		if (!isMoving && dayOfWeek >= Calendar.MONDAY
				&& dayOfWeek <= Calendar.FRIDAY && hour > 3 && hour < 8
				&& amPM == Calendar.PM) {

			// find an academic building

			// get all the greenspace buildings
			ArrayList<GreenSpace> greenSpace = new ArrayList<GreenSpace>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof GreenSpace) {
					greenSpace.add((GreenSpace) DrawingPanel.buildings
							.get(i));
				}
			}
			
			//get all water
			ArrayList<Water> water = new ArrayList<Water>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof Water) {
					water.add((Water) DrawingPanel.buildings
							.get(i));
				}
			}
			
			//get all students
			ArrayList<Person> students = new ArrayList<Person>();
			for (int i = 0; i < DrawingPanel.students.size(); i++) {
				if (DrawingPanel.students.get(i) instanceof Student) {
					students.add((Person) DrawingPanel.students
							.get(i));
				}
			}
			
			// pick one of them at random
			if (greenSpace.size() > 0 && water.size() > 0) {
				int ran = (int) (water.size() * Math.random());
				int ran2 = (int) (greenSpace.size() * Math.random());
				for (int i = 1; i < students.size(); i++){
					int random1 = (int) (2 * Math.random());

					if(random1==1){
						destinationX = water.get(ran).getUpperX();
						destinationY = water.get(ran).getUpperY();
					}
					else{
					destinationX = greenSpace.get(ran2).getUpperX();
					destinationY = greenSpace.get(ran2).getUpperY();
					}
				}
			} 
			else {

				destinationX = 10; // run to corner
				destinationY = 10;
			}
		}
		
		
		/* Time for sleep (?) All Days 8pm-8am */
		if (!isMoving && hour >= 8 && amPM == Calendar.PM) { // go to bed

			// find a residence hall

			// get all the academic buildings
			ArrayList<ResidenceHall> residences = new ArrayList<ResidenceHall>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof ResidenceHall) {
					residences.add((ResidenceHall) DrawingPanel.buildings
							.get(i));
				}
			}
			// pick one of them at random
			if (residences.size() > 0) {
				int ran = (int) (residences.size() * Math.random());
				destinationX = residences.get(ran).getUpperX();
				destinationY = residences.get(ran).getUpperY();
			} else {

				destinationX = 550; // run to corner
				destinationY = 550;
			}
		}
		
		/* Time for the Library Monday - Friday 12pm - 3pm*/
		if (!isMoving && dayOfWeek >= Calendar.MONDAY
				&& dayOfWeek <= Calendar.FRIDAY && hour >= 12 && hour <= 3
				&& amPM == Calendar.PM) {

			// find a library building

			// get all the library buildings
			ArrayList<Library> library = new ArrayList<Library>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof Library) {
					library.add((Library) DrawingPanel.buildings
							.get(i));
				}
			}
			// get all the athletic fields
			ArrayList<AthleticFields> athleticFields = new ArrayList<AthleticFields>();
			for (int i = 0; i < DrawingPanel.buildings.size(); i++) {
				if (DrawingPanel.buildings.get(i) instanceof AthleticFields) {
					athleticFields.add((AthleticFields) DrawingPanel.buildings
							.get(i));
				}
			}
			
			//get all students
			ArrayList<Person> students = new ArrayList<Person>();
			for (int i = 0; i < DrawingPanel.students.size(); i++) {
				if (DrawingPanel.students.get(i) instanceof Student) {
					students.add((Person) DrawingPanel.students
							.get(i));
				}
			}
			
			// pick one of the destinations at random
			if (library.size() > 0 && athleticFields.size() > 0) {
				int ran = (int) (library.size() * Math.random());
				int random  = (int) (athleticFields.size() * Math.random());
				int randomPerson = (int) (students.size() * Math.random());
				int randomPerson2 = (int) (students.size() * Math.random());
				Person person1 = DrawingPanel.students.get(randomPerson);
				Person person2 = DrawingPanel.students.get(randomPerson2);
				destinationX = library.get(ran).getUpperX();
				destinationY = library.get(ran).getUpperY();
				
				//2 random students are going to same Library decide to go to a random athletic Field
				if (person1.destinationX==person2.destinationX){
					person1.destinationX = athleticFields.get(random).getUpperX();
					person1.destinationY = athleticFields.get(random).getUpperY();
					person2.destinationX = athleticFields.get(random).getUpperX();
					person2.destinationY = athleticFields.get(random).getUpperY();
				}
			
			}
			else if (library.size() > 0){
				int ran = (int) (library.size() * Math.random());
				destinationX = library.get(ran).getUpperX();
				destinationY = library.get(ran).getUpperY();
			}
			else if (athleticFields.size() > 0){
				int ran = (int) (library.size() * Math.random());
				destinationX = athleticFields.get(ran).getUpperX();
				destinationY = athleticFields.get(ran).getUpperY();
			}
			else {

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
