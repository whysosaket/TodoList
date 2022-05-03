package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class LeftMenuPane implements ActionListener, MouseListener {
    JPanel leftMenuPane;

    ImageIcon alertDisabledIcon= new ImageIcon(".\\icons\\alertDisabled.png");
    ImageIcon alertEnabledIcon= new ImageIcon(".\\icons\\alertEnabled.png");
    ImageIcon alarmIcon= new ImageIcon(".\\icons\\alarm.png");
    ImageIcon addTaskIcon= new ImageIcon(".\\icons\\addTask.png");
    ImageIcon loadIcon= new ImageIcon(".\\icons\\load.png");
    ImageIcon loginIcon= new ImageIcon(".\\icons\\login.png");

    ImageIcon alertDisabledIcon35= new ImageIcon(".\\icons\\alertDisabled35.png");
    ImageIcon alertEnabledIcon35= new ImageIcon(".\\icons\\alertEnabled35.png");
    ImageIcon alarmIcon35= new ImageIcon(".\\icons\\alarm35.png");
    ImageIcon addTaskIcon35= new ImageIcon(".\\icons\\addTask35.png");
    ImageIcon loadIcon35= new ImageIcon(".\\icons\\load35.png");
    ImageIcon loginIcon35= new ImageIcon(".\\icons\\login35.png");

    public static boolean alertEnabled= true;
    public static boolean addTaskBool=true;
    public static boolean setAlarmBool=true;

    JLabel alarm;
    JLabel alert;
    JLabel addTask;
    JLabel load;
    JLabel login;

    LeftMenuPane(){
        this.leftMenuPane= new JPanel();            // used as left panel
        this.leftMenuPane.setBackground(new Color(155, 89, 182));
        this.leftMenuPane.setPreferredSize(new Dimension(110,400));
        leftMenuPane.setLayout(null);

        //setting the alert code
        alert= new JLabel(" Alert");
        alert.setBounds(15,20,80,36);
        alert.addMouseListener(this);

        //setting the alarm code
        alarm= new JLabel(" Alarm");
        alarm.setBounds(15,75,115,36);
        alarm.addMouseListener(this);

        //setting up the add task menu
        addTask= new JLabel("<html>&nbsp;Add<br/>&nbsp;Task</html>");
        addTask.setBounds(15,130,120,36);
        addTask.addMouseListener(this);

        //setting up loads icon
        load= new JLabel(" Load");
        load.setBounds(15,185,120,36);
        load.addMouseListener(this);

        //setting up login icon
        login= new JLabel(" Login");
        login.setBounds(15,240,120,36);
        login.addMouseListener(this);

        //setting icons and colors
        setDefault();

        leftMenuPane.add(alert);
        leftMenuPane.add(alarm);
        leftMenuPane.add(addTask);
        leftMenuPane.add(load);
        leftMenuPane.add(login);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==alert){
            alertEnabled=!alertEnabled;
            if(alertEnabled) alert.setIcon(alertEnabledIcon);
            else alert.setIcon(alertDisabledIcon);
        }

        if (e.getSource()==alarm&&setAlarmBool){
            new Alarm();
            setAlarmBool=false;
        }

        if(e.getSource()==addTask&&addTaskBool){
            new AddTask();
            addTaskBool=false;
        }

        if(e.getSource()==load){
            try {
                new LoadFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==alert){
            alert.setFont(new Font("",Font.BOLD,15));
            alert.setForeground(Color.WHITE);
            if(alertEnabled) alert.setIcon(alertEnabledIcon35);
            else alert.setIcon(alertDisabledIcon35);
        }
        if (e.getSource()==alarm){
            alarm.setFont(new Font("",Font.BOLD,15));
            alarm.setForeground(Color.WHITE);
            alarm.setIcon(alarmIcon35);
        }

        if (e.getSource()==addTask){
            addTask.setFont(new Font("",Font.BOLD,15));
            addTask.setForeground(Color.WHITE);
            addTask.setIcon(addTaskIcon35);
        }

        if (e.getSource()==load){
            load.setFont(new Font("",Font.BOLD,15));
            load.setForeground(Color.WHITE);
            load.setIcon(loadIcon35);
        }

        if (e.getSource()==login){
            login.setFont(new Font("",Font.BOLD,15));
            login.setForeground(Color.WHITE);
            login.setIcon(loginIcon35);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setDefault();

    }

    void setDefault(){
        //setting font
        alert.setFont(new Font("",Font.BOLD,13));
        alarm.setFont(new Font("",Font.BOLD,13));
        addTask.setFont(new Font("",Font.BOLD,13));
        load.setFont(new Font("",Font.BOLD,13));
        login.setFont(new Font("",Font.BOLD,13));

        //setting color
        alert.setForeground(new Color(245,245,245));
        alarm.setForeground(new Color(245,245,245));
        addTask.setForeground(new Color(245,245,245));
        load.setForeground(new Color(245,245,245));
        login.setForeground(new Color(245,245,245));


        alarm.setIcon(alarmIcon);

        if(alertEnabled) alert.setIcon(alertEnabledIcon);
        else alert.setIcon(alertDisabledIcon);

        addTask.setIcon(addTaskIcon);
        load.setIcon(loadIcon);
        login.setIcon(loginIcon);
    }
}
