package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUI extends JFrame {
    static JFrame frame;
    static MainScreen mainScreen;
    static File file = new File("tasks.tsk");
    public GUI(){
        new CreateTaskFile();
        frame = new JFrame();

        ImageIcon icon= new ImageIcon(".\\icons\\icon.png");
        frame.setIconImage(icon.getImage());

        //setting the JFrame
        frame.setSize(800,500);
        frame.setTitle("TODO-List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        //setting up main panels
        mainScreen= new MainScreen();
        TopBar topBar= new TopBar();
        LeftMenuPane leftMenuPane= new LeftMenuPane();


        frame.add(topBar.topHead, BorderLayout.NORTH);
        frame.add(leftMenuPane.leftMenuPane, BorderLayout.WEST);
        frame.add(mainScreen.scrollPane, BorderLayout.EAST);

        // making the frame appear in the desired location
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/3-frame.getSize().width/2, dim.height/3-frame.getSize().height/2+50);

        frame.setVisible(true);
    }
}
