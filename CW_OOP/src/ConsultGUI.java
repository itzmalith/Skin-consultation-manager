import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class ConsultGUI {
    ConsultGUI() throws IOException {

        JFrame frame = new JFrame();
        frame.setSize(1080,800);
        JLabel topiclable = new JLabel();

        topiclable.setText("Consultation Details");
        topiclable.setFont(new Font("Calibri",Font.BOLD,25));
        topiclable.setVerticalTextPosition(JLabel.TOP);
        topiclable.setHorizontalAlignment(JLabel.CENTER);
        topiclable.setForeground(Color.BLACK);

        JPanel newpanel = new JPanel();

        frame.getContentPane().setBackground (new Color(192, 154, 25));


        //--------------------------------splitting and getting data from consultation text file-----------------------------------------


        BufferedReader reader = new BufferedReader(new FileReader("Consultation.txt"));

        List<String[]> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
             String [] newww4 = line.split("\\|");

//
            //Getting MIME decoder
            Base64.Decoder decoder = Base64.getMimeDecoder();
            //Decoding MIME encoder
            String dStr = new String(decoder.decode(newww4[8]));
            newww4[8]=dStr;
            lines.add(newww4);



        }

        reader.close();


        DefaultTableModel model = new DefaultTableModel(lines.toArray(new String[lines.size()][]), new String[] {"Name","Surname","DOB","start time","End time","Mobile No","DOC ID","Date","extra notes","Cost($)","patient id"});

        // Create the table.

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);





        newpanel.add(topiclable);
        newpanel.add(new JScrollPane(table));
        frame.add(newpanel);

        newpanel.setLayout(new GridLayout(3,1));

        newpanel.setBackground(Color.gray);
        table.setBackground(Color.lightGray);



        JPanel newpanel2 = new JPanel(new GridLayout(1,3));

        newpanel.add(newpanel2);

        //-----------------------------------Creating Navigation Buttons------------------------------------------


        JButton b1=new JButton("Doctor List");
        b1.setBounds(50,100,95,30);
        newpanel2.add(b1);

        JButton b2=new JButton("Consultation");
        b2.setBounds(50,100,95,30);
        newpanel2.add(b2);

        JButton b3=new JButton("Dashboard");
        b2.setBounds(50,100,95,30);
        newpanel2.add(b3);


        frame.setVisible(true);

        //--------------------------------------------------navigating buttons------------------------------------------------------------


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent s) {
                frame.setVisible(false);
                new Table();

            }

        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent x) {
                frame.setVisible(false);
                new PatientGUI();

            }

        });

    }

    //calling the main method just for checking purposes


    public static void main(String[] args) throws IOException {
        //open consultaion ui
        new ConsultGUI();
    }
}
