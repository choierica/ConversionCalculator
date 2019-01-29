package model;

import exceptions.NegativeNumberException;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ConvertDialog extends JDialog implements ActionListener {
    private JLabel meter;
    private JLabel foot;
    private JLabel unit;
    private JLabel field;
    private JLabel option;
    private JTextField field_meter;
    private JTextField field_foot;
    private JButton mtof;
    private JButton ftom;
    private Convert convert = new Convert();
    private ConversionHistory ch = new ConversionHistory();


    public ConvertDialog() throws IOException {

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        setBounds(100,300,500,200);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);

        unit = new JLabel("UNIT");
        unit.setBounds(10, 5, 60, 25);
        unit.setFont(new Font("Serif",1, 16 ));
        add(unit);

        field = new JLabel("FIELDS");
        field.setFont(new Font("Serif",1, 16 ));
        field.setBounds(105, 5, 60, 25);
        add(field);

        option = new JLabel("OPTIONS");
        option.setFont(new Font("Serif",1, 16 ));
        option.setBounds(205, 5, 100, 25);
        add(option);

        BufferedImage myPicture = ImageIO.read(getClass().getResource("/model/picture/maths.png"));
        Image scaleImage = new ImageIcon(myPicture).getImage().getScaledInstance(130, 130,Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(scaleImage));
        picLabel.setBounds(0,5,100,30);
        add(picLabel);
        picLabel.setSize(100,300);





        meter = new JLabel("Meters");
        meter.setFont(new Font("Serif", 0, 14));
        meter.setBounds(10, 30, 60, 25);
        foot = new JLabel("Foot");
        foot.setFont(new Font("Serif", 0, 14));
        foot.setBounds(10, 70, 60, 25);
        field_meter = new JTextField(10);
        field_meter.setBounds(100, 30, 100, 25);
        field_foot = new JTextField(10);
        field_foot.setBounds(100, 70, 100, 25);

        mtof = new JButton("Meter to Foot!");
        mtof.setBounds(200, 30, 200, 25);
        ftom = new JButton("Foot to Meter!");
        ftom.setBounds(200, 70, 200, 25);

        mtof.setActionCommand("mtof");
        ftom.setActionCommand("ftom");
        mtof.addActionListener(this);
        ftom.addActionListener(this);


        add(meter);
        add(field_meter);
        add(foot);
        add(field_foot);
        add(mtof);
        add(ftom);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        pack();


    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("mtof")) {

            try {
                field_foot.setText(convert.meter(field_meter.getText()));
                playSound("applause_y");
            }
            catch (NumberFormatException e1) {
                playSound("erro");
                JOptionPane.showMessageDialog(this, "Please enter a number", "Error", 0);
            }
            catch (NegativeNumberException e1) {
                playSound("erro");
                JOptionPane.showMessageDialog(this, "Please enter a positive number", "Error", 0);
            }
            try {
                saveMeterFoot();

            }
            catch (NumberFormatException e1) {}
            catch (NegativeNumberException e1) {}

        } else if (e.getActionCommand().equals("ftom")) {
            try {
                field_meter.setText(convert.foot(field_foot.getText()));
                playSound("applause_y");
            }
            catch (NumberFormatException e1) {
                playSound("erro");
                JOptionPane.showMessageDialog(this, "Please enter a number", "Error", 0);
            }
            catch (NegativeNumberException e1) {
                playSound("erro");
                JOptionPane.showMessageDialog(this, "Please enter a positive number", "Error", 0);
            }
            try {
                saveFootMeter();
            }
            catch (NumberFormatException e1) {}
            catch (NegativeNumberException e1) {}
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

    protected void saveMeterFoot() throws NegativeNumberException {
        try {
            ch.save(field_meter.getText() + "meters" + " " + convert.meter(field_meter.getText()) + "foot");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    protected void saveFootMeter() throws NegativeNumberException {
        try {
            ch.save(field_foot.getText() + "foot" + " " + convert.foot(field_foot.getText()) + "meters");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
