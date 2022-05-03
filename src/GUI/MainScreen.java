package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MainScreen {

    JScrollPane scrollPane;
    static JPanel mainScreen;

    MainScreen(){
        try {
            BufferReading.read();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }


        mainScreen= new JPanel();            // used as main Screen
        mainScreen.setBackground(new Color(210,240,210));
        mainScreen.setPreferredSize(new Dimension(672,BufferReading.tasks.size()*100));
        mainScreen.setLayout(new FlowLayout(FlowLayout.TRAILING,10,20));
        //mainScreen.setPreferredSize(new Dimension(GUI.frame.getSize().width-110,GUI.frame.getSize().height-50));

        scrollPane = new JScrollPane(mainScreen);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setBackground(new Color(210,240,210));
        scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        //scrollPane.setPreferredSize(new Dimension(672,350));


        refresh();

        //addTask("null");

    }
    public static void addTask(String newTask){
        CreatingTasks task= new CreatingTasks(newTask);
        //mainScreen.setPreferredSize(new Dimension(672,mainScreen.getHeight()+70));
        mainScreen.repaint();
    }
    public static void addNewTask(String newTask){
        CreatingTasks task= new CreatingTasks(newTask);
        mainScreen.setPreferredSize(new Dimension(672,mainScreen.getHeight()+70));
        mainScreen.repaint();
    }
    public static void refresh(){
        for(int i=0;i<BufferReading.tasks.size();i++) {
            addTask(BufferReading.tasks.get(i));
        }
    }
}
