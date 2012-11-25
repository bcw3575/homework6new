import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Contains radio buttons to select what you want to draw and some JTextFields
 * displaying how much area is contained by each building type.
 * 
 * @author Brian Walker
 * 
 */
public class ControlPanel extends JPanel implements ItemListener {

	public static final int academicBuilding = 0;
	public static final int administrativeBuilding = 1;
	public static final int gym = 2;
	public static final int studentCenter = 3;
	public static final int library = 4;
	public static final int greenSpace = 5;
	public static final int water = 6;
	public static final int footballStadium = 7;
	public static final int athleticVenue = 8;
	public static final int residenceHalls = 9;
	public static final int sidewalks = 10;
	public static final int student = 11;
	public static final int faculty = 12;
	
	
	ImageIcon [] buttonImages = { new ImageIcon("buttonImages2"), 
			new ImageIcon("administrativeBuildingIcon.jpg"), 
			new ImageIcon("gymnasiumIcon.jpg"), 
			new ImageIcon("studentCenterIcon.jpg"), 
			new ImageIcon("bookstacksIcon.jpg"), 
			new ImageIcon("greenSpaceIcon.jpg"), 
			new ImageIcon("waterIcon.jpg"),
			new ImageIcon("footballStadiumIcon.jpg"), 
			new ImageIcon("athleticVenueIcon.jpg"), 
			new ImageIcon("residenceHallIcon.jpg"), 
			new ImageIcon("sidewalksIcon.jpg"), 
			new ImageIcon("manWalkingIcon.jpg"), 
			new ImageIcon("womanWalkingIcon.jpg") };
	
	
	public static final String[] toolStrings = { "Academic", "Administrative",
		"Gymnasium", "Student Center", "Library", "Green Space", "Water",
		"Football Stadium", "Athletic Fields", "Residence Halls",
		"Sidewalks", "Student", "Faculty" };
		

	public static int drawingTool;
	public static int numberOfTools = toolStrings.length;

	public JRadioButton[] tools;
	public static JTextField[] areas;
	ArrayList<Building> buildings;
	ArrayList<Person> students;
	

	/**
	 * Add the radio buttons and the JTextFields.
	 * 
	 * @param builds
	 *            The list of buildings.
	 */
	public ControlPanel(ArrayList<Building> builds) {
		buildings = builds;

		
		setPreferredSize(new Dimension(250, 600));
		setBorder(BorderFactory.createTitledBorder("Controls"));
		setLayout(new GridLayout(1, 1));

		JPanel toolPanel = new JPanel();
		toolPanel.setBorder(BorderFactory.createTitledBorder("Drawing Tools"));
		ButtonGroup toolGroup = new ButtonGroup();
		toolPanel.setLayout(new FlowLayout());
		tools = new JRadioButton[numberOfTools];
		for (int i = 0; i < toolStrings.length; i++) {
			tools[i] = new JRadioButton(buttonImages[i]);
			tools[i].addItemListener(this);
			toolPanel.add(tools[i]);
			toolGroup.add(tools[i]);

		}
		tools[0].setSelected(true);

		add(toolPanel);

		JPanel areaPanel = new JPanel();
		areaPanel.setLayout(new GridLayout(numberOfTools, 1));
		areaPanel.setBorder(BorderFactory.createTitledBorder("Areas"));
		areas = new JTextField[numberOfTools];
		for (int i = 0; i < toolStrings.length; i++) {
			areas[i] = new JTextField(toolStrings[i] + ": 0");
			areas[i].setEditable(false);
			areaPanel.add(areas[i]);
		}
		//add(areaPanel);

	}

	/**
	 * When a radio button is selected, update "drawingTool" variable
	 * appropriately.
	 * 
	 * @param radioButtonEvent
	 *            The item event associated with the radio button.
	 * 
	 */
	public void itemStateChanged(ItemEvent radioButtonEvent) {
		JRadioButton whichButton = (JRadioButton) radioButtonEvent.getSource();

		if (whichButton.isSelected()) {
			Icon text = whichButton.getIcon();
			for (int i = 0; i < toolStrings.length; i++) {
				if (text.equals(buttonImages[i])) {
					drawingTool = i;
					return;
				}
			}
		}

	}
}
