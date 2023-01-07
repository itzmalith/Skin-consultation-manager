import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import java.io.File;
import java.util.Scanner;

public class PatientGUI {

    public static void main(String[] args) {
        new PatientGUI();

    }

    PatientGUI(){

        WestminsterSkinConsultationManager newobjx = new WestminsterSkinConsultationManager();


        JFrame frame = new JFrame();
        frame.setSize(1080,800);
        JLabel topiclable = new JLabel();


        topiclable.setText("Add Patient");
        topiclable.setFont(new Font("Calibri",Font.BOLD,25));
        topiclable.setVerticalTextPosition(JLabel.TOP);
        topiclable.setHorizontalAlignment(JLabel.CENTER);
        topiclable.setForeground(Color.BLACK);

        JPanel newpanel = new JPanel();
        frame.getContentPane().setBackground (new Color(192, 154, 25));


        newpanel.setBackground(Color.gray);
        newpanel.add(topiclable);
        newpanel.setLayout(new GridLayout(3,1));


        //form
        JPanel Jpanel2 = new JPanel(new GridLayout(6,4));
//
        JLabel instruction1 = new JLabel("Enter patient consultation details",JLabel.CENTER);

        topiclable.setFont(new Font("Calibri",Font.BOLD,27));

        //boruwa

        JLabel instruction2 = new JLabel("");
        topiclable.setFont(new Font("Calibri",Font.BOLD,18));
        JLabel instruction3 = new JLabel("");
        topiclable.setFont(new Font("Calibri",Font.BOLD,18));
        JLabel instruction4 = new JLabel("");
        topiclable.setFont(new Font("Calibri",Font.BOLD,18));


        Jpanel2.add(instruction1);
        Jpanel2.add(instruction2);
        Jpanel2.add(instruction3);
        Jpanel2.add(instruction4);


        JLabel name = new JLabel("Patient Name :",JLabel.RIGHT);
        name.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(name);


        JTextField tname = new JTextField();
        tname.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(tname);

        JLabel mno = new JLabel("Sure Name :",JLabel.RIGHT);
        mno.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(mno);

        JTextField tmno = new JTextField();
        tmno.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(tmno);

        JLabel doby = new JLabel("Date Of Birth :",JLabel.RIGHT);
        name.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(doby);

        JTextField tdoby = new JTextField();
        tname.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(tdoby);

        JLabel moby = new JLabel("Mobile Number :",JLabel.RIGHT);
        mno.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(moby);

        JTextField tmoby = new JTextField();
        tmno.setFont((new Font("Inter", Font.BOLD, 15)));
        Jpanel2.add(tmoby);


        JLabel  datelabel= new JLabel("Date of Consultation : ", JLabel.RIGHT);
        datelabel.setFont((new Font("Inter", Font.BOLD, 15)));


        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFontValidDate(new Font("Inter", Font.PLAIN, 15));
        DatePicker datePicker1 = new DatePicker(dateSettings);
        datePicker1.setBackground(Color.WHITE);

        JLabel  timeLabel = new JLabel("Consultation starting time : ", JLabel.RIGHT);
        timeLabel.setFont((new Font("Inter", Font.BOLD, 15)));

        JLabel  timeLabel2 = new JLabel("Consultation end time : ", JLabel.RIGHT);
        timeLabel2.setFont((new Font("Inter", Font.BOLD, 15)));


        TimePickerSettings timeSettings=new TimePickerSettings();

        timeSettings.setMinimumSpinnerButtonWidthInPixels(15);
        timeSettings.setDisplaySpinnerButtons(true);

        TimePicker timeText =new TimePicker(timeSettings);
        TimePicker timeText2 =new TimePicker(timeSettings);

        timeText.setFont((new Font("Inter", Font.PLAIN, 15)));
        timeText.setBackground(Color.WHITE);

        timeText2.setFont((new Font("Inter", Font.PLAIN, 15)));
        timeText2.setBackground(Color.WHITE);

        JLabel  doctorlabel= new JLabel("Doctor's Med NO : ", JLabel.RIGHT);
        doctorlabel.setFont((new Font("Inter", Font.BOLD, 15)));

        JLabel  noteslabel = new JLabel("Extra Notes : ", JLabel.RIGHT);
        noteslabel.setFont((new Font("Inter", Font.BOLD, 15)));

        JTextField doctorText = new JTextField();
        doctorText.setFont((new Font("Inter", Font.PLAIN, 15)));

        JTextField notesText = new JTextField();
        notesText.setFont((new Font("Inter", Font.PLAIN, 15)));

        //submit button
         //style
        JLabel instruction7 = new JLabel("");
        topiclable.setFont(new Font("Calibri",Font.BOLD,18));

        JButton submit =new JButton("SUBMIT");
        submit.setBounds(50,100,95,30);
        submit.setForeground(Color.RED);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                // The name of the file to open
                //using text file to check docs availability


                String searchtext = doctorText.getText();
                System.out.println(searchtext);
                boolean ty = false;

                try {

                    File readFile = new File("totable.txt");
                    Scanner scanFile = new Scanner(readFile);
                    while (scanFile.hasNextLine()){
                        String line = scanFile.nextLine();
                        String[] values = line.split(",");

                        if (values[4].equals(searchtext)){
                            // If the line contains the search string, print "yes" and exit the loop
                            System.out.println("yes");
                            JOptionPane.showMessageDialog(frame, "Doctor available !");

                            ty=true;
//                            JOptionPane.showMessageDialog(frame, "Doctor available");

                            //printing consultation charge
                            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

                            int costfinal = 0;
                            try {
                                Date endt = timeFormat.parse(String.valueOf(timeText2));
                                Date stat = timeFormat.parse(String.valueOf(timeText));


                                int timefianl = (int) ((endt.getTime() - stat.getTime()) / (1000 * 60 * 60));

                                if (timefianl<0){
                                    JOptionPane.showMessageDialog(frame, "Error in time");
                                }
                                else if ( timefianl > 1) {
                                    costfinal += ((timefianl- 1) * 15 )+25;
                                }
                                else
                                    costfinal = timefianl * 25;

                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }

                            JOptionPane.showMessageDialog(frame, "$" + costfinal + " Cost's you!");

                            String guioutcost = Integer.toString(costfinal);

                            try {

                                //encode
                                //Getting MIME encoder
                                Base64.Encoder encoder = Base64.getMimeEncoder();
                                String encodedNotes = notesText.getText() ;
                                String encodedNote = encoder.encodeToString(encodedNotes.getBytes());


                                newobjx.saveConsult(tname.getText(), tmno.getText(), tdoby.getText(), timeText.getText(), timeText2.getText(), tmoby.getText(), doctorText.getText(), datePicker1.getText(), encodedNote,guioutcost, Patient.getPatientID());

                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;


                        }


                    }
                    if (!ty){
                        JOptionPane.showMessageDialog(frame, "Selected Doctor not available");
                    }


                } catch (Exception u) {
                    // If there was an error, print the error message
                    System.out.println("Error: " + u.getMessage());
                }



            }

        } );


        Jpanel2.add(datelabel);
        Jpanel2.add(datePicker1);
        Jpanel2.add(doctorlabel);
        Jpanel2.add(doctorText);
        Jpanel2.add(timeLabel);
        Jpanel2.add(timeText);
        Jpanel2.add(timeLabel2);
        Jpanel2.add(timeText2);
        Jpanel2.add(noteslabel);
        Jpanel2.add(notesText);
        Jpanel2.add(instruction7);

        
        Jpanel2.add(submit);


        //buttons

        JPanel newpanel2 = new JPanel(new GridLayout(1,3));

        newpanel.add(newpanel2);

        JButton b1=new JButton("Doctor List");
        b1.setBounds(50,100,95,30);
        newpanel2.add(b1);

        JButton b2=new JButton("Add patient");
        b2.setBounds(50,100,95,30);
        newpanel2.add(b2);

        JButton b3=new JButton("Consultation");
        b2.setBounds(50,100,95,30);



        newpanel2.add(b3);

        frame.add(newpanel);
        newpanel.add(Jpanel2);
        newpanel.add(newpanel2);

        frame.setVisible(true);



        //test

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent s) {
                frame.setVisible(false);
                new Table();

            }

        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent x) {
                frame.setVisible(false);
                try {
                    new ConsultGUI();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }

        });

    }



}


