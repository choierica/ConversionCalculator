package model;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ConversionHistoryJText extends Component implements ActionListener {
    private ConversionHistory ch = new ConversionHistory();

    public ConversionHistoryJText() throws IOException {
        JLabel title = new JLabel("Conversion History");
        JFrame f = new JFrame();
        JTextArea area = new JTextArea(10,2);

        for(String string: load()){
            area.append(string);
        }

        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Serif", Font.BOLD, 15));
        clear.setActionCommand("myButton");
        clear.addActionListener(this);
        clear.setBounds(250, 400, 150, 30);
        f.add(clear);

        area.setFont(new Font("Aerial", 0,5));




        area.setFont(new Font("Serif", Font.ITALIC, 16));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBounds(80, 50, 350, 300);
        title.setBounds(170, 10, 250, 25);
        title.setFont(new Font("Serif", Font.ITALIC, 20));
        Border border = BorderFactory.createBevelBorder(1, Color.black, Color.white);
        area.setBorder(border);

        BufferedImage myPicture = ImageIO.read(getClass().getResource("/model/picture/apartments.png"));
        Image scaleImage = new ImageIcon(myPicture).getImage().getScaledInstance(200, 130,Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(scaleImage));
        picLabel.setBounds(140,350,200,130);
        f.add(picLabel);

        f.setLayout(null);
        f.setVisible(true);
        f.setBounds(100,250,500,500);
        f.add(area);
        f.add(title);


    }



    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("The conversion of " + partsOfLine.get(0) + " ");
            System.out.println("is " + partsOfLine.get(1));
            result.add("The conversion of " + partsOfLine.get(0) + " " + "is " + partsOfLine.get(1)+"\n");
        }
        return result;
    }



    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playSound("click_x");
        if (e.getActionCommand().equals("myButton")) {
            try {
                ch.clear();
                playSound("erro");
                JOptionPane.showMessageDialog(this, "Are you sure you want to clear the history?", "Conversion history ", 1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
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
