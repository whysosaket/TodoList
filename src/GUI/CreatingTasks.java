package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class CreatingTasks implements MouseListener {

    JPanel task;

    JLabel taskText;
    JButton deleteTaskButton;

    ImageIcon deleteButton= new ImageIcon(".\\icons\\delete.png");
    ImageIcon deleteButton35= new ImageIcon(".\\icons\\delete35.png");

    CreatingTasks(String s){

        task= new JPanel();
        task.setPreferredSize(new Dimension(650,60));
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
        if(e.getSource()==deleteTaskButton){

            String taskTxt=taskText.getText();
            BufferReading.tasks.remove(taskTxt);

            try {
                Writing.write();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            MainScreen.mainScreen.repaint();
            MainScreen.mainScreen.setPreferredSize(new Dimension(672,MainScreen.mainScreen.getHeight()-70));
            MainScreen.mainScreen.remove(task);
        }
        if (e.getSource()==taskText){
            taskText.setFont(new Font("Georgia",Font.BOLD,14));
            new EditTask(taskText.getText(), taskText);
            LeftMenuPane.addTaskBool=false;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==deleteTaskButton){
            String st=deleteButton35.getDescription();
            if(!st.equals(".\\icons\\delete35.png"))
            {
                deleteTaskButton.setText("X");
                deleteTaskButton.setForeground(Color.red);
                deleteTaskButton.setFont(new Font("Consolas",Font.BOLD,30));
            }
            else deleteTaskButton.setIcon(deleteButton35);
        }

        if (e.getSource()==taskText){
            taskText.setFont(new Font("Georgia",Font.BOLD,14));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setDefaults();
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
