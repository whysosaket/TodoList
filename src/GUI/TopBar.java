package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TopBar implements MouseListener, ActionListener {
    JPanel topHead;
    JButton topButton1;
    JButton topButton2;
    JButton topButton3;
    JButton topButton4;

    static boolean viewAlarm=true;

    TopBar(){
        this.topHead= new JPanel();            // used as top panel
        this.topHead.setBackground(new Color(142, 68, 173));
        this.topHead.setPreferredSize(new Dimension(400,50));
        // TOP BAR
        this.topHead.setLayout(new BorderLayout());
        JPanel topHeadLeft= new JPanel();
        topHeadLeft.setBackground(new Color(142, 68, 173));
        topHeadLeft.setPreferredSize(new Dimension(100,50));
        this.topHead.add(topHeadLeft, BorderLayout.WEST);

        JLabel topHeadLeftText = new JLabel("TODO\nList");
        topHeadLeftText.setHorizontalTextPosition(JLabel.CENTER);
        topHeadLeftText.setVerticalTextPosition(JLabel.CENTER);
        topHeadLeftText.setForeground(Color.WHITE);
        topHeadLeftText.setFont(new Font("MV Boli", Font.BOLD, 15));

        topHeadLeft.add(topHeadLeftText);

        // END-- Of Top LeftPanel

        JPanel topHeadRight= new JPanel();
        topHeadRight.setBackground(new Color(142, 68, 173));
        topHeadRight.setPreferredSize(new Dimension(420,50));
        this.topHead.add(topHeadRight, BorderLayout.EAST);

        topButton1= new JButton();
        topButton2= new JButton();
        topButton3= new JButton();
        topButton4= new JButton();

        topButton1.setText("Add List");
        topButton2.setText("Clear List");
        topButton3.setText("View Alarms");
        topButton4.setText("About");

        // TO MAKE BUTTONS TRANSPARENT
        topButton1.setOpaque(false);
        topButton2.setOpaque(false);
        topButton3.setOpaque(false);
        topButton4.setOpaque(false);

        topButton1.setContentAreaFilled(false);
        topButton2.setContentAreaFilled(false);
        topButton3.setContentAreaFilled(false);
        topButton4.setContentAreaFilled(false);

        topButton1.setBorderPainted(false);
        topButton2.setBorderPainted(false);
        topButton3.setBorderPainted(false);
        topButton4.setBorderPainted(false);
        //END OF MAKING BUTTONS TRANSPARENT
        setDefault(); //setting default

        topButton1.setFocusable(false);
        topButton2.setFocusable(false);
        topButton3.setFocusable(false);
        topButton4.setFocusable(false);


        //Adding MouseListeners to the buttons'
        topButton1.addMouseListener(this);
        topButton2.addMouseListener(this);
        topButton3.addMouseListener(this);
        topButton4.addMouseListener(this);

        // Finally Adding the buttons
        topHeadRight.add(topButton1);
        topHeadRight.add(topButton2);
        topHeadRight.add(topButton3);
        topHeadRight.add(topButton4);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getSource()==topButton2){
            int n=JOptionPane.showConfirmDialog(null,"Do You Want To Clear The List?","CONFIRM",JOptionPane.YES_NO_OPTION);
            if(n==0) new ClearList();
        }

        if(e.getSource()==topButton3&&TopBar.viewAlarm){
            new ViewAlarmGUI();
            TopBar.viewAlarm=false;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==topButton1) {
            topButton1.setForeground(Color.WHITE);
            topButton1.setFont(new Font("Consolas",Font.BOLD,15));
        }
        else if(e.getSource()==topButton2) {
            topButton2.setForeground(Color.WHITE);
            topButton2.setFont(new Font("Consolas",Font.BOLD,15));
        }
        else if(e.getSource()==topButton3) {
            topButton3.setForeground(Color.WHITE);
            topButton3.setFont(new Font("Consolas",Font.BOLD,15));
        }
        else if(e.getSource()==topButton4) {
            topButton4.setForeground(Color.WHITE);
            topButton4.setFont(new Font("Consolas",Font.BOLD,15));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        setDefault();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    void setDefault(){
        topButton1.setForeground(new Color(245,245,245));
        topButton2.setForeground(new Color(245,245,245));
        topButton3.setForeground(new Color(245,245,245));
        topButton4.setForeground(new Color(245,245,245));

        topButton1.setFont(new Font("Consolas",Font.BOLD,13));
        topButton2.setFont(new Font("Consolas",Font.BOLD,13));
        topButton3.setFont(new Font("Consolas",Font.BOLD,13));
        topButton4.setFont(new Font("Consolas",Font.BOLD,13));
    }
}
