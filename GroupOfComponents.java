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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GroupOfComponents {

	String nameOfDay;
	JLabel event;
	JTextField addEventText;
	JButton addEventButton;
	JPanel dayPanel;
	JPanel eventPanel;

//	Konstruktor för varje dag
	GroupOfComponents(String nameOfDay, int dayNumber, JPanel container) {

		this.nameOfDay = nameOfDay;

		JLabel nameOfDayLabel = new JLabel(nameOfDay.toString());
		JLabel dateAndMonthLabel = new JLabel(getDate(dayNumber));
		JLabel event = new JLabel();
		JTextField addEventText = new JTextField("Add your Event");
		JButton addEventButton = new JButton("Add");
		
		nameOfDayLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		nameOfDayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dateAndMonthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		event.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEventText.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEventButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		eventPanel = new JPanel();
		eventPanel.setPreferredSize(new Dimension(650, 800));

		container.add(nameOfDayLabel);
		container.add(dateAndMonthLabel);
		container.add(eventPanel);
		container.add(addEventText);
		container.add(addEventButton);

		BoxLayout eventLayout = new BoxLayout(eventPanel, BoxLayout.PAGE_AXIS);
		eventPanel.setLayout(eventLayout);
		eventPanel.setBackground(Color.gray);
		
		BoxLayout dayLayout = new BoxLayout(container, BoxLayout.PAGE_AXIS);
		container.setLayout(dayLayout);
		container.setBackground(Color.gray);
		container.setBorder(new LineBorder(Color.black));
		
		highlightToday(container, eventPanel, dayNumber);

		addButtonListener(addEventButton, event, addEventText);
	}

//	Vad som händer när man trycker på knappen (skapar ny JLabel och lägger till den i EventPanel.
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
		};
		addEventButton.addActionListener(bListener);
	}

//	Metod för att få fram datum för hel vecka, där X är vilket position i veckan man vill ha ut.
	public static String getDate(int x) {
		LocalDate today = LocalDate.now();
		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = today.with(fieldISO, x);
		String dateAndMonth = date.toString();
		return dateAndMonth;
	}

//	Metod för highlight dagens datum
	public void highlightToday(JPanel panel, JPanel eventPanel, int i) {
		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_WEEK);
		
		if (i == today - 1) {
				panel.setBackground(Color.PINK);
				eventPanel.setBackground(Color.PINK);
		}
    }

}
