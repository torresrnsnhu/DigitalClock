package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends JFrame {
    private JLabel timeLabel = new JLabel();
    private JLabel dateLabel = new JLabel();

    public DigitalClock(){
        setTitle("Digital Clock");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        //Create a panel to hold the time and date labels
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        //Create a label to display the time
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.WHITE);

        //Create a label to display the date
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setVerticalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(Color.WHITE);

        //Add the time and date labels to the panel. Use panel created on line 17
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);

        //Change the panel's background color
        panel.setBackground(Color.BLACK);

        //Add panel to the frame
        add(panel);

        //Add a Timer to configure the time and date labels to update every second
        //delay is count as milliseconds
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }
        });
        timer.start();
    }
    //Format the time and date
    private void updateTimeAndDate(){
       //Get the current time and format it
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss aa"); //HH = 24, hh = 12 hours format

        String time = timeFormatter.format(calendar.getTime());

        //Get the current date and format it
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy"); //Day, Month and day number, Year
        String date = dateFormat.format(calendar.getTime());

        //Update the time and date label together
        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    public static void main(String[] args){
        //Main method is responsible to run the application
        DigitalClock clock = new DigitalClock();
        clock.setVisible(true);
    }
}
