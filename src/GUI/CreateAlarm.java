package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class CreateAlarm implements MouseListener {

    JPanel alarm;

    JLabel alarmText;
    JButton deleteAlarmButton;

    ImageIcon deleteButton= new ImageIcon(".\\icons\\delete.png");
    ImageIcon deleteButton35= new ImageIcon(".\\icons\\delete35.png");

    String rem;

    CreateAlarm(String s, String lis){
        rem = lis;

        alarm= new JPanel();
        alarm.setPreferredSize(new Dimension(400,60));
        alarm.setBackground(new Color(200,240,200));
        alarm.setLayout(new FlowLayout(FlowLayout.TRAILING,0,10));

        alarmText= new JLabel();
        alarmText.setPreferredSize(new Dimension(300,60));
        alarmText.setText(s);
        alarmText.addMouseListener(this);

        deleteAlarmButton = new JButton();
        deleteAlarmButton.addMouseListener(this);
        setDefaults();


        alarm.add(alarmText);
        alarm.add(deleteAlarmButton);
        ViewAlarmGUI.mainScreen.add(alarm);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==deleteAlarmButton){

            String taskTxt=alarmText.getText();
            //BufferReading.tasks.remove(taskTxt);

            ViewAlarmGUI.alarmList.remove(rem);
            ViewAlarmGUI.mainScreen.repaint();
            ViewAlarmGUI.mainScreen.setPreferredSize(new Dimension(410,MainScreen.mainScreen.getHeight()-70));
            ViewAlarmGUI.mainScreen.remove(alarm);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==deleteAlarmButton){
            String st=deleteButton35.getDescription();
            if(!st.equals(".\\icons\\delete35.png"))
            {
                deleteAlarmButton.setText("X");
                deleteAlarmButton.setForeground(Color.red);
                deleteAlarmButton.setFont(new Font("Consolas",Font.BOLD,30));
            }
            else deleteAlarmButton.setIcon(deleteButton35);
        }

        if (e.getSource()==alarmText){
            alarmText.setFont(new Font("Georgia",Font.BOLD,35));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setDefaults();
    }

    // default configs
    void setDefaults(){

        //defaults for the buttons
        deleteAlarmButton.setOpaque(false);
        deleteAlarmButton.setContentAreaFilled(false);
        deleteAlarmButton.setBorderPainted(false);
        deleteAlarmButton.setFocusable(false);

        String st=deleteButton.getDescription();
        if(!st.equals(".\\icons\\delete.png"))
        {
            deleteAlarmButton.setPreferredSize(new Dimension(40,40));
            deleteAlarmButton.setText("X");
            deleteAlarmButton.setForeground(Color.red);
            deleteAlarmButton.setFont(new Font("Consolas",Font.BOLD,40));
        }
        else deleteAlarmButton.setIcon(deleteButton);

        //defaults for the text
        alarmText.setFont(new Font("Georgia",Font.BOLD,25));
        alarmText.setForeground(new Color(155,89,182));
    }
}
