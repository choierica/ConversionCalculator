package model;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sounds {

    protected Sounds() {

    }

    protected void playSound(String name) {
        try {
            URL url = this.getClass().getResource("/sounds/"+ name + ".wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (LineUnavailableException e1) {
            e1.printStackTrace();
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        }
    }

}
