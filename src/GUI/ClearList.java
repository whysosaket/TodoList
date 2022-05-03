package GUI;

import java.awt.*;
import java.io.IOException;

public class ClearList {

    ClearList(){
        BufferReading.tasks.clear();
        try {
            Writing.write();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        refresh();
    }
    public static void refresh(){
        GUI.frame.remove(GUI.mainScreen.scrollPane);
        GUI.mainScreen = new MainScreen();
        GUI.frame.add(GUI.mainScreen.scrollPane, BorderLayout.EAST);
    }
}
