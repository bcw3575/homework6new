import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;




public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -87769764270612228L;
	
	private ArrayList<Building> buildings;
	private ArrayList<Person> students;
	private ArrayList<Person> faculty;
	private Calendar calendar;
	
	public GameState(ArrayList<Building> buildings, ArrayList<Person> faculty, ArrayList<Person> students, Calendar calendar){
		this.buildings = buildings;
		this.faculty = faculty;
		this.students  = students;
		this.calendar = calendar;	
	}
	
	
	public ArrayList<Building> getBuildings() {
		return buildings;
	}

	public ArrayList<Person> getStudents() {
		return students;
	}

	public ArrayList<Person> getFaculty() {
		return faculty;
	}

	public Calendar getCalendar() {
		return calendar;
	}

}
