import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;


public class Zoom extends JPanel implements ItemListener{
	
	public static final int oneHundred = 0;
	public static final int fifty = 1;
	
	public static final String[] zoomStrings = { "100%", "50%" };
	
	public static int numberOfZooms = zoomStrings.length;
	
	
	
	public Zoom() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
