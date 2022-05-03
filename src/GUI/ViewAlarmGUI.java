package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewAlarmGUI extends JFrame {
    int defaultCloseOperation=JFrame.DISPOSE_ON_CLOSE;

    ImageIcon scheduleIcon= new ImageIcon(".\\icons\\schedule.png");

    JScrollPane scrollPane;
    static JPanel mainScreen;

    static ArrayList<String> alarmList = new ArrayList<>();

    ViewAlarmGUI(){
        setDefaultCloseOperation(defaultCloseOperation);
        this.setTitle("Alarms");
        this.setIconImage(scheduleIcon.getImage());
        this.setSize(420,420);
        this.getContentPane().setBackground(new Color(210,240,210));
        this.setResizable(false);

        mainScreen= new JPanel();            // used as main Screen
        mainScreen.setBackground(new Color(210,240,210));
        mainScreen.setPreferredSize(new Dimension(410,alarmList.size()*100));
        mainScreen.setLayout(new FlowLayout(FlowLayout.TRAILING,10,20));
        //mainScreen.setPreferredSize(new Dimension(GUI.frame.getSize().width-110,GUI.frame.getSize().height-50));

        scrollPane = new JScrollPane(mainScreen);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setBackground(new Color(210,240,210));
        scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);


        for (String list: alarmList){
            String[] str1= list.split("\\t");
            String hh=str1[0];
            String mm=str1[1];
            String ss=str1[2];
            if(hh.length()<2) hh="0"+hh;
            if(mm.length()<2) mm="0"+mm;
            if(ss.length()<2) ss="0"+ss;
            String str= hh+":"+mm+":"+ss;
            addAlarm(str,list);
        }


        this.add(scrollPane);
        // making the frame appear in the desired location
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);

    }

    //OverRidden the default Close Operation here, to make addTask button re Usable after
    //disposing this new window
    @Override
    protected void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            TopBar.viewAlarm=true;
            dispose();
        }
    }
    public static void addAlarm(String newTask, String list){
        CreateAlarm task= new CreateAlarm(newTask, list);
        //mainScreen.setPreferredSize(new Dimension(672,mainScreen.getHeight()+70));
        mainScreen.repaint();
    }

}
