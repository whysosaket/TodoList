package GUI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alarm extends JFrame implements MouseListener {
    int ss,mm,hh;
    int sc, mn, hr;
    JComboBox hrs, min, sec;
    JLabel hrsLabel, minLabel, secLabel;
    JButton setAlarm;

    int defaultCloseOperation=JFrame.DISPOSE_ON_CLOSE;

    public Alarm() {
        GUI();
        setTitle("Alarm");
        final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                String time = timeFormat.format(date);
                sc = date.getSeconds();
                mn = date.getMinutes();
                hr = date.getHours();


                if (sc == ss && mn == mm && hr == hh)
                {
                    // Code to Do actions
                    if(LeftMenuPane.alertEnabled) {
                        try {
                            AUDIO audio = new AUDIO();
                        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    Component Jframe = null;
                    JOptionPane.showMessageDialog(Jframe,"Wake UP Wake UP","Alarm Ringing",JOptionPane.PLAIN_MESSAGE);
                    ViewAlarmGUI.alarmList.remove(hh+"\t"+mm+"\t"+ss);
                    AUDIO.clip.stop();
                    Alarm.this.dispose();
                }

            }
        };
        Timer timer = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        timer.setInitialDelay(0);
        timer.start();

    }

    public void GUI(){
        setDefaultCloseOperation(defaultCloseOperation);

        // making the frame appear in the desired location
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/3-this.getSize().width/2, dim.height/3-this.getSize().height/2+50);

        ImageIcon alarmIcon= new ImageIcon(".\\icons\\add_alarm_icon.png");
        this.setIconImage(alarmIcon.getImage());

        this.setResizable(false);
        this.getContentPane().setBackground(new Color(200,240,200));
        this.setSize(360,220);
        this.setLayout(new FlowLayout());

        // creating HOURS comboBox
        String[] hours= new String[24];
        for(int i=0;i<hours.length;i++){
            hours[i]=String.valueOf(i);
        }
        // creating MINUTES and SECONDS comboBox
        String [] minutes= new String[60];
        String [] seconds= new String[60];
        for(int i=0;i<minutes.length;i++){
            minutes[i]=String.valueOf(i);
            seconds[i]=String.valueOf(i);
        }

        // SETTING DEFAULT TIME IN JCOMBOBOX
        final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String time = timeFormat.format(date);
        sc = date.getSeconds();
        mn = date.getMinutes();
        hr = date.getHours();
        //FINISHED SETTING UP CODE IN J COMBOBOX

        // J TEXT FIELD
        hrs= new JComboBox(hours);
        hrs.setSelectedIndex(hr);
        System.out.println(hr);

        min= new JComboBox(minutes);
        min.setSelectedIndex(mn);
        System.out.println(mn);

        sec= new JComboBox(seconds);
        sec.setSelectedIndex(sc);
        System.out.println(sc);

        hrsLabel= new JLabel("HOURS");
        minLabel= new JLabel("MINUTES");
        secLabel= new JLabel("SECONDS");

        //set alarm button
        setAlarm = new JButton("Set Alarm");

        hrs.setPreferredSize(new Dimension(160,40));
        min.setPreferredSize(new Dimension(160,40));
        sec.setPreferredSize(new Dimension(160,40));

        // LABELS
        hrsLabel.setPreferredSize(new Dimension(120,40));
        minLabel.setPreferredSize(new Dimension(120,40));
        secLabel.setPreferredSize(new Dimension(120,40));
        hrsLabel.setForeground(new Color(155, 89, 182));
        minLabel.setForeground(new Color(155, 89, 182));
        secLabel.setForeground(new Color(155, 89, 182));

        defaultGUI();
        setAlarm.addMouseListener(this);

        this.add(hrsLabel);
        this.add(hrs);
        this.add(minLabel);
        this.add(min);
        this.add(secLabel);
        this.add(sec);
        this.add(setAlarm);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==setAlarm){
            hh=Integer.parseInt((String) hrs.getSelectedItem());
            mm=Integer.parseInt((String) min.getSelectedItem());
            ss=Integer.parseInt((String) sec.getSelectedItem());
            this.setVisible(false);

            ViewAlarmGUI.alarmList.add(hh+"\t"+mm+"\t"+ss);

            LeftMenuPane.setAlarmBool=true;
            JOptionPane.showMessageDialog(null,"Alarm Set to "+hh+":"+mm+":"+ss);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==setAlarm){
            setAlarm.setFont(new Font("Consolas",Font.BOLD,18));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==setAlarm){
            setAlarm.setFont(new Font("Consolas",Font.BOLD,14));
        }
    }

    public void defaultGUI(){
        //setting the SET ALARM BUTTON
        setAlarm.setPreferredSize(new Dimension(130,30));
        setAlarm.setForeground(new Color(155, 89, 182));
        setAlarm.setOpaque(false);
        setAlarm.setContentAreaFilled(false);
        setAlarm.setBorderPainted(false);
        setAlarm.setFocusable(false);
        setAlarm.setFont(new Font("Consolas",Font.BOLD,14));
    }


    /// closing the operations
    @Override
    protected void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            LeftMenuPane.setAlarmBool=true;
            dispose();
        }
    }
}
