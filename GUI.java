package slutprojekt;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GUI {
	
static void createCalendar(JFrame frame) {
		
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
		JPanel groupContainer = new JPanel();
		BoxLayout weekLayout = new BoxLayout(groupContainer, BoxLayout.LINE_AXIS);
		
		int x = 0;
		for (int i= 1; i<=days.length; i++) {
			JPanel container = new JPanel();
			new GroupOfComponents(days[x], i, container);
			x++;
			groupContainer.add(container);
			
		}

		groupContainer.setLayout(weekLayout);
		
		frame.add(groupContainer);

	}
	
}
