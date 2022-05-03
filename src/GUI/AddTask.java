package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class AddTask extends JFrame implements ActionListener, MouseListener, KeyListener {
    int defaultCloseOperation=JFrame.DISPOSE_ON_CLOSE;

    JPanel mainArea;
    JPanel rightButtonArea;

    //setting up icons
    ImageIcon addTaskIcon= new ImageIcon(".\\icons\\addingTask.png");
    ImageIcon addTaskIcon35= new ImageIcon(".\\icons\\addingTask35.png");
    ImageIcon scheduleIcon= new ImageIcon(".\\icons\\schedule.png");
    ImageIcon scheduleIcon35= new ImageIcon(".\\icons\\schedule35.png");


    JButton taskSubmitButton = new JButton();
    JButton scheduleButton = new JButton();
    JTextField taskEnter;

    String taskHere;

    AddTask(){
        this.setTitle("Add New Task");
        this.setIconImage(addTaskIcon.getImage());
        setDefaultCloseOperation(defaultCloseOperation);
        this.setLayout(new BorderLayout(10,10));
        this.setSize(550,220);
        this.setResizable(false);

        mainArea= new JPanel();
        mainArea.setPreferredSize(new Dimension(410,220));
        mainArea.setBackground(new Color(210,240,210));
        mainArea.setLayout(new FlowLayout(FlowLayout.CENTER));

        rightButtonArea= new JPanel();
        rightButtonArea.setPreferredSize(new Dimension(135,220));
        rightButtonArea.setBackground(new Color(210,240,210));
        rightButtonArea.setLayout(new FlowLayout(FlowLayout.TRAILING));


        //adding a textField to add the tasks in the main Menu

        taskEnter= new JTextField("Enter Your task here");
        taskEnter.setPreferredSize(new Dimension(390,150));
        taskEnter.setBackground(new Color(250,240,240));
        taskEnter.setForeground(new Color(155,89,182));
        taskEnter.setFont(new Font("Georgia",Font.BOLD,13));
        taskEnter.setCaretColor(Color.BLACK);
        //taskEnter.setHorizontalAlignment(SwingConstants.RIGHT);
        //taskEnter.setLayout(new FlowLayout());

        //setting button for the addTask
        def();
        taskSubmitButton.addMouseListener(this);
        scheduleButton.addMouseListener(this);

        rightButtonArea.add(taskSubmitButton);
        rightButtonArea.add(scheduleButton);
        mainArea.add(taskEnter);

        // making the frame appear in the desired location
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.addKeyListener(this);
        this.add(mainArea,BorderLayout.WEST);
        this.add(rightButtonArea,BorderLayout.EAST);
        this.setVisible(true);
    }

    void def(){
        taskSubmitButton.setPreferredSize(new Dimension(120,65));
        taskSubmitButton.setOpaque(false);
        taskSubmitButton.setContentAreaFilled(false);
        taskSubmitButton.setBorderPainted(false);
        taskSubmitButton.setFocusable(false);
        taskSubmitButton.setIcon(addTaskIcon);

        scheduleButton.setPreferredSize(new Dimension(120,65));
        scheduleButton.setOpaque(false);
        scheduleButton.setContentAreaFilled(false);
        scheduleButton.setBorderPainted(false);
        scheduleButton.setFocusable(false);
        scheduleButton.setIcon(scheduleIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()== taskSubmitButton){
            taskHere = taskEnter.getText();
            if( !taskEnter.getText().equals("")&&!BufferReading.tasks.contains(taskHere)) {
                BufferReading.tasks.add(taskHere);
                try {
                    Writing.write();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                MainScreen.addNewTask(taskHere);
                LeftMenuPane.addTaskBool = true;
                this.dispose();
            }
            else JOptionPane.showMessageDialog(this,"Task is Empty Or Already Exists","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==taskSubmitButton){
            taskSubmitButton.setIcon(addTaskIcon35);
        }
        if (e.getSource()==scheduleButton){
            scheduleButton.setIcon(scheduleIcon35);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        def();
    }

    //OverRidden the default Close Operation here, to make addTask button re Usable after
    //disposing this new window
    @Override
    protected void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            LeftMenuPane.addTaskBool=true;
            dispose();
        }
    }

    // This is the key Listener Method
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()==KeyEvent.VK_ENTER){
            System.out.println("success");
        }
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }
}
