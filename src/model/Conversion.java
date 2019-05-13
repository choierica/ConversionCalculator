package model;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Conversion extends JFrame implements ActionListener {
    private ConvertDialog cd;
    private ConversionHistoryJText chj;
    private JLabel web_label;
    private JLabel start;
    BufferedReader br;

    public Conversion() throws IOException {
        super("The Conversion Calculator");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 250);
        this.setPreferredSize(new Dimension(600, 400));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);
        Sounds sounds = new Sounds();
        sounds.playSound("Elevator-music");


        BufferedImage myPicture = ImageIO.read(getClass().getResource("/model/picture/mathsymbol.png"));

        Image scaleImage = new ImageIcon(myPicture).getImage().getScaledInstance(800, 500,Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(scaleImage));
        picLabel.setSize(600,400);
        setContentPane(picLabel);
        displayText();
        setVisible(true);

    }

    public void displayText()  throws IOException {

        try {
            String theURL = "https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            web_label = new JLabel(String.valueOf(sb));
            web_label.setBounds(100, 25, 415, 30);
            web_label.setFont(new Font("Serif", Font.BOLD,20));
            Border border = BorderFactory.createBevelBorder(1, Color.black, Color.white);
            web_label.setBorder(border);
            add(web_label);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:  scans the user input and reflects back to the user.
    public void scanOption() {
        while (true) {

            start = new JLabel("\nSELECT YOUR OPTIONS");
            start.setBounds(190, 70, 500, 25);
            start.setFont(new Font("Serif", Font.BOLD, 18));
            this.add(start);

            JButton btn = new JButton("Number Conversion");
            btn.setFont(new Font("Serif", Font.BOLD, 15));
            JButton btn_2 = new JButton("View Conversion History");
            btn_2.setFont(new Font("Serif", Font.BOLD, 15));

            btn.setActionCommand("myButton");
            btn_2.setActionCommand("myButton2");


            btn.addActionListener(this);
            btn_2.addActionListener(this);


            btn.setBounds(170, 120, 250, 70);
            btn_2.setBounds(170, 200, 250, 70);

            add(btn);
            add(btn_2);

            pack();
            break;
        }

    }


    //this is the method that runs when Swing registers an action on an element
    //for which this class is an ActionListener
    public void actionPerformed(ActionEvent e) {
        Sounds sounds = new Sounds();
        sounds.playSound("click_x");
        if (e.getActionCommand().equals("myButton")) {
            start.setText("You have Selected: " + "Number Conversion");
            try {
                this.cd = new ConvertDialog();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        else if (e.getActionCommand().equals("myButton2")) {
            start.setText("You have Selected: " + "View Conversion History");
            try {
                this.chj = new ConversionHistoryJText();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }


}
