package slutprojekt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GroupOfComponents {
	
//	Creates each day with a constructor.
//	The Constructor creates each day with all the components and design inside.

	String nameOfDay;
	JLabel event;
	JTextField addEventText;
	JButton addEventButton;
	JPanel dayPanel;
	JPanel eventPanel;

//	Constuctor for each day.
	GroupOfComponents(String nameOfDay, int dayNumber, JPanel container) {

		this.nameOfDay = nameOfDay;

		JLabel nameOfDayLabel = new JLabel(nameOfDay.toString());
		JLabel dateAndMonthLabel = new JLabel(getDate(dayNumber));
		JLabel event = new JLabel();
		JTextField addEventText = new JTextField("Add your Event");
		JButton addEventButton = new JButton("Add");
		
		nameOfDayLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		dateAndMonthLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		nameOfDayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dateAndMonthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		event.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEventText.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		

		eventPanel = new JPanel();
		eventPanel.setPreferredSize(new Dimension(650, 800));
		BoxLayout eventLayout = new BoxLayout(eventPanel, BoxLayout.PAGE_AXIS);
		eventPanel.setLayout(eventLayout);
		eventPanel.setBackground(Color.gray);
		eventPanel.add(Box.createRigidArea(new Dimension(30, 20)));

		container.add(nameOfDayLabel);
		container.add(dateAndMonthLabel);
		container.add(eventPanel);
		container.add(addEventText);
		container.add(addEventButton);
		
		BoxLayout dayLayout = new BoxLayout(container, BoxLayout.PAGE_AXIS);
		container.setLayout(dayLayout);
		container.setBackground(Color.gray);
		container.setBorder(new LineBorder(Color.black));
		
		highlightToday(container, eventPanel, dayNumber);

		addButtonListener(addEventButton, event, addEventText);
	}

//	What happens when you press the button. 
//	Adds the text from the TextField and creates a new JLabel and adds it to the eventPanel.
	private void addButtonListener(JButton addEventButton, JLabel event, JTextField addEventText) {
		ActionListener bListener = new ActionListener() {

			public void addNewLabel() {
				JLabel newEventLabel = new JLabel();
				newEventLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				eventPanel.add(newEventLabel);
				newEventLabel.setText(addEventText.getText());
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				addNewLabel();
				event.setText(addEventText.getText());
			}
		};addEventButton.addActionListener(bListener);
	}

//	Method to print each day by the position in the week.
//	Position 1 = Monday, Position 2 = Tuesday, etc.
	public static String getDate(int x) {
		LocalDate today = LocalDate.now();
		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = today.with(fieldISO, x);
		String dateAndMonth = date.toString();
		return dateAndMonth;
	}

//	Method to highlight the panel of today.
	public void highlightToday(JPanel panel, JPanel eventPanel, int i) {
		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_WEEK);
		
		if (i == today - 1) {
				panel.setBackground(Color.PINK);
				eventPanel.setBackground(Color.PINK);
		}
    }

}
