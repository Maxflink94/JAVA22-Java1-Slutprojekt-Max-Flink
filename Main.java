package slutprojekt;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.setTitle("Veckokalender Java22");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GUI.createCalendar(frame);
	
		frame.setVisible(true);
	}

}
