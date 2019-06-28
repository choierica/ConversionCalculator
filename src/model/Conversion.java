package model;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
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
        setStyle();
    }

    private void setStyle() throws IOException {
        Sounds sounds = new Sounds();
        sounds.playSound("Elevator-music");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 250);
        this.setPreferredSize(new Dimension(600, 400));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);

        BufferedImage myPicture = ImageIO.read(getClass().getResource("/model/picture/mathsymbol.png"));

        Image scaleImage = new ImageIcon(myPicture).getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(scaleImage));
        picLabel.setSize(600, 400);
        setContentPane(picLabel);
        setVisible(true);
    }

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
            btn.setActionCommand("Conversion");
            btn_2.setActionCommand("Conversion History");
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

    public void actionPerformed(ActionEvent e) {
        Sounds sounds = new Sounds();
        sounds.playSound("click_x");
        setButton(e.getActionCommand());
    }

    private void setButton(String option) {
        start.setText("You have Selected: " + option);
        if (option.equals("Conversion")) {
            try {
                this.cd = new ConvertDialog();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            try {
                this.chj = new ConversionHistoryJText();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


}
