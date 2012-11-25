import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.Timer;

/**
 * A simulated university.
 * 
 * @author Brian Walker
 * 
 */
public class SimU extends JFrame implements ActionListener {

	public static ImageIcon academicImage = new ImageIcon(
			"AcademicBuilding.jpg");
	public static ImageIcon libraryImage = new ImageIcon("bookstacks2.gif");
	public static ImageIcon personImage = new ImageIcon("manWalking2.gif");
	public static ImageIcon residenceImage = new ImageIcon("residenceHall2.jpg");
	public static ImageIcon administrativeBuilding = new ImageIcon(
			"administrativeBuilding2.gif");
	public static ImageIcon athleticFields = new ImageIcon("athleticVenue2.jpg");
	public static ImageIcon footballStadium = new ImageIcon(
			"footballStadium2.gif");
	public static ImageIcon greenSpace = new ImageIcon("greenSpace2.jpg");
	public static ImageIcon gymnasium = new ImageIcon("gymnasium2.jpg");
	public static ImageIcon studentCenter = new ImageIcon("studentCenter2.jpg");
	public static ImageIcon water = new ImageIcon("water2.jpg");
	public static ImageIcon walkingMan = new ImageIcon("walkingFaculty.gif");
	public static ImageIcon sidewalks = new ImageIcon("sidewalk.jpg");
	public static ImageIcon walkingFaculty = new ImageIcon("womanWalking.gif");
	public static ImageIcon backgroundCampus = new ImageIcon(
			"campusbackground.jpg");

	//state to save
	private ArrayList<Building> buildings;
	private ArrayList<Person> students;
	private ArrayList<Person> faculty;
	static Timer timer;
	//don't save
	public static JSlider slider;
	public static DrawingPanel drawing;
	public static JButton timerStop;
	public static JButton timerGo;
	public static JPanel sliderPanel;
	public static int studentCounter;
	public static int facultyCounter;


	/**
	 * Creates the window and adds the two panels.
	 * 
	 * @param args
	 *            Ignored.
	 */
	public static void main(String[] args) {
		SimU window = new SimU();

		window.setSize(1150, 700);
		window.setResizable(false);
		window.setTitle("SimU - A Simulated University Game");

		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);

		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(newGame);
		fileMenu.addSeparator();
		fileMenu.add(load);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		newGame.addActionListener(window.new NewgameListener());
		load.addActionListener(window.new LoadListener());
		save.addActionListener(window.new SaveListener());
		exit.addActionListener(window.new ExitListener());
		window.setJMenuBar(menubar);

		window.buildings = new ArrayList<Building>();
		window.students = new ArrayList<Person>();
		window.faculty = new ArrayList<Person>();
		drawing = new DrawingPanel(window.buildings, window.students,
				window.faculty);
		ControlPanel controls = new ControlPanel(window.buildings);

		JScrollPane scrollPane = new JScrollPane(drawing);
		scrollPane
		.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// drawing.add(scrollPane);

		window.add(scrollPane, BorderLayout.CENTER);
		window.add(controls, BorderLayout.EAST);
		window.add(DrawingPanel.controlTimerPanel, BorderLayout.SOUTH);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	/**
	 * Action Listener for "New Game".
	 * 
	 * @param event
	 *            Clears buildings, persons, and faculty.
	 * 
	 */
	public class NewgameListener implements ActionListener {
		/**
		 * Action Performed for "New Game".
		 * 
		 * @param event
		 *            Clears buildings, persons, and faculty.
		 * 
		 */
		public void actionPerformed(ActionEvent event) {
			DrawingPanel.buildings.clear();
			DrawingPanel.students.clear();
			DrawingPanel.faculty.clear();
			drawing.setCalendar(Calendar.getInstance());
			repaint();
		}
	}

	/**
	 * Action Listener for "Load".
	 * 
	 * @param event
	 *            Ignored.
	 * 
	 */
	public class LoadListener implements ActionListener {
		/**
		 * Action Performed for "Load".
		 * 
		 * @param event
		 *            Ignored.
		 * 
		 */
		public void actionPerformed(ActionEvent event) {

			JFileChooser fc = new JFileChooser();
			int choice = fc.showOpenDialog(null);
			if (choice == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: "
						+ fc.getSelectedFile().getAbsolutePath());
			}
			
			File out = fc.getSelectedFile();
			
			if (out == null){
				return;
			}
			
			
			try {
				FileInputStream in = new FileInputStream(out);
			    ObjectInputStream ois = new ObjectInputStream(in);
			    
			    GameState gameState = null;
			    gameState = (GameState) ois.readObject();
			    
			    buildings.clear();
			    for(Building b: gameState.getBuildings()){
			    	buildings.add(b);
			    }
			    	    
			    faculty.clear();
			    for (Person f : gameState.getFaculty()){
			    	faculty.add(f);
			    }
			    
			    students.clear();
			    for (Person f : gameState.getStudents()){
			    	students.add(f);
			    }
			    
			    drawing.setCalendar(gameState.getCalendar());
			    System.out.println(students.size());
			   // drawing.updateHappiness();
			    
			    
//			    faculty = gameState.getFaculty();
//			    students  = gameState.getStudents();
//			    timer = gameState.getTimer();
			    
			    
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		


			// ObjectInputStream ois = new ObjectInputStream (new
			// FileInputStream(readFromThisFile));
			//
			// buildings.clear();
			// buildings = (ArrayList<Buildings>) ois.readObject();
			//
			// students.clear();
			// students (ArrayList<Person>) ois.readObject();
			// drawing.buildings = buildings; 
			// drawing.persons = persons;
			// repaint();

			// JFileChooser chooser = new JFileCHooser("./");
			// int choice = chooser.showOpenDialog(null);
			// if (choice == JFileChooser.APPROVE_OPTION);
			// File readFromThisFile =
			// Scanner scan = new Scanner(readFromThisFile);

		}
	}

	/**
	 * Action Listener for "Save".
	 * 
	 * @param event
	 *            Ignored.
	 * 
	 */
	public class SaveListener implements ActionListener {
		/**
		 * Action Performed for "Save".
		 * 
		 * @param event
		 *            Ignored.
		 * 
		 */
		public void actionPerformed(ActionEvent event) {

			JFileChooser fc = new JFileChooser();
			int choice = fc.showSaveDialog(null);
			if (choice == JFileChooser.APPROVE_OPTION) {
				System.out.println("You choose to save this file: "
						+ fc.getSelectedFile().getAbsolutePath());
			}

			File out = fc.getSelectedFile();

			if (out == null){
				return;
			}
			
			try {
				FileOutputStream fsOut = new FileOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(fsOut);
				GameState gs = new GameState(buildings, faculty, students, drawing.getCalendar());
				oos.writeObject(gs);
				oos.flush();
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}





			//

			// FileChooser chooser = new JFileChooser(./);
			// int choice = chooser.showSaveDIalog(null);
			// if (choice == JFileChooser.APPROVE_OPTION){
			// File writeToThisFIle = chooser.getSelectedFile();
			// ObjectOutputStream oos = new ObjectOutputStream();
			//
			// catch (Exception e){
			//
			// }

			// try {
			// JFileChooser chooser = new JFileChooser("./");
			// int choice = chooser.showSaveDialog(null);
			// if (choice == JFileChooser.APPROVE_OPTION) {
			// File writeToThisFile = chooser.getSelectedFile();
			// PrintWriter pw = new PrintWriter(writeToThisFile);
			//

			// //write buildings
			// pw.println(buildings.size();
			// for (int i = 0; i < buildings.size(); i++){
			// pw.println(buildings.get(i));
			// }
			// //write people
			// pw.println(students.size());
			// for (int i = 0; i < students.size(); i++) {
			// pw.println(students.get(i));
			// }
			// pw.close();
			// }
			// }
			// catch (Exception e){
			//
			// }

		}
	}

	/**
	 * Action Listener for "Exit".
	 * 
	 * @param event
	 *            Exit Program.
	 * 
	 */
	public class ExitListener implements ActionListener {
		/**
		 * Action Performed for "Exit".
		 * 
		 * @param event
		 *            Exit program.
		 * 
		 */
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

	/**
	 * Action Listener.
	 * 
	 * @param e
	 *            Ignored.
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
