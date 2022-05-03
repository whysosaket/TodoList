package GUI;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AUDIO {
    static Clip clip;
    public AUDIO() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(".\\icons\\AlarmSound.wav");
        AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}
