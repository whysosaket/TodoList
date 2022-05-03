package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class addAlarmList implements MouseListener {
    JPanel task;

    JLabel taskText;
    JButton deleteTaskButton;

    ImageIcon deleteButton= new ImageIcon(".\\icons\\delete.png");
    ImageIcon deleteButton35= new ImageIcon(".\\icons\\delete35.png");

    addAlarmList(String s){
        task= new JPanel();
        task.setPreferredSize(new Dimension(400,60));
        task.setBackground(new Color(200,240,200));
        task.setLayout(new FlowLayout(FlowLayout.TRAILING,0,10));

        taskText= new JLabel();
        taskText.setPreferredSize(new Dimension(560,60));
        taskText.setText(s);
        taskText.addMouseListener(this);

        deleteTaskButton = new JButton();
        deleteTaskButton.addMouseListener(this);
        setDefaults();


        task.add(taskText);
        task.add(deleteTaskButton);
        MainScreen.mainScreen.add(task);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    void setDefaults(){

        //defaults for the buttons
        deleteTaskButton.setOpaque(false);
        deleteTaskButton.setContentAreaFilled(false);
        deleteTaskButton.setBorderPainted(false);
        deleteTaskButton.setFocusable(false);

        String st=deleteButton.getDescription();
        if(!st.equals(".\\icons\\delete.png"))
        {
            deleteTaskButton.setPreferredSize(new Dimension(40,40));
            deleteTaskButton.setText("X");
            deleteTaskButton.setForeground(Color.red);
            deleteTaskButton.setFont(new Font("Consolas",Font.BOLD,20));
        }
        else deleteTaskButton.setIcon(deleteButton);

        //defaults for the text
        taskText.setFont(new Font("Georgia",Font.BOLD,11));
        taskText.setForeground(new Color(155,89,182));
    }
}
