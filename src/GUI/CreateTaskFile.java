package GUI;

import java.io.File;
import java.io.IOException;

public class CreateTaskFile {

    CreateTaskFile()  {

        File file = new File(String.valueOf(GUI.file));
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
