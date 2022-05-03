package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class LoadFile {

    LoadFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TSK Files", "tsk");
        fileChooser.addChoosableFileFilter(filter);
        int n=fileChooser.showOpenDialog(null);

        if(n==0) {
            File source = new File(String.valueOf(fileChooser.getSelectedFile()));
            File dest = new File(String.valueOf(GUI.file));
            InputStream inStream = new FileInputStream(source);
            OutputStream outStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];

            int length;
            while (true) {
                assert false;
                if (!((length = inStream.read(buffer)) > 0)) break;
                outStream.write(buffer, 0, length);
            }

            if (inStream != null) inStream.close();
            if (outStream != null) outStream.close();
            ClearList.refresh();
        }
}
}
