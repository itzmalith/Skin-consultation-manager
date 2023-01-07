import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;


public class Table {


    Table(){

        //creating new frame
        JFrame frame = new JFrame();

        //setting frame size

        frame.setSize(1080,800);

        //creating topic lable

        JLabel topiclable = new JLabel();

        //topic details

        topiclable.setText("Available Doctor List");
        topiclable.setFont(new Font("Calibri",Font.BOLD,25));
        topiclable.setVerticalTextPosition(JLabel.TOP);
        topiclable.setHorizontalAlignment(JLabel.CENTER);
        topiclable.setForeground(Color.BLACK);

        //basic panel

        JPanel newpanel = new JPanel();


        frame.getContentPane().setBackground (new Color(192, 154, 25));

        String[][] data = WestminsterSkinConsultationManager.docList;
        String[] column ={"Name","Surname","dob","Mobile num","Med License No","Specialisation"};

        //creating a table
        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);


        // Create a sorter for the table
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);

        //set the sorter to table
        table.setRowSorter(sorter);





        JPanel newp2 = new JPanel();

        JPanel testpanel = new JPanel();
        //test panel to maintain  the grid layout (for sort button)

        testpanel.setLayout(new GridLayout(4,3));



        //creating sort button

        JButton newww = new JButton("Order doctors in alphabetical order");

        //function initialize of button

        newww.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
                sorter.sort();
            }
        });

        //order button

        newww.setBounds(0,0,10,10);
        testpanel.add(newww);



        newp2.add(topiclable);
        newp2.add(testpanel);
        newp2.setLayout(new GridLayout(2,1));


        newpanel.add(newp2);
        newpanel.add(new JScrollPane(table));
        frame.add(newpanel);
        
        newpanel.setLayout(new GridLayout(3,1));

        newpanel.setBackground(Color.gray);
        table.setBackground(Color.lightGray);



        JPanel newpanel2 = new JPanel(new GridLayout(1,3));

        newpanel.add(newpanel2);

        //crating navigation buttons


        JButton b1=new JButton("Doctor List");
        b1.setBounds(50,100,95,30);
        newpanel2.add(b1);

        JButton b2=new JButton("Add patient");
        b2.setBounds(50,100,95,30);
        newpanel2.add(b2);

        JButton b3=new JButton("Dashboard");
        b2.setBounds(50,100,95,30);
        newpanel2.add(b3);


        frame.setVisible(true);





        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent s) {
                frame.setVisible(false);
                new PatientGUI();

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
