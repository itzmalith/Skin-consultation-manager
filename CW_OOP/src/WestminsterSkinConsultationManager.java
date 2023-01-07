import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager  {
    //declaring the array
    public static String[][] docList = new String[10][6];

    static int countDoctor = 0;

    //-----------------------------------method to add a doctor-----------------------------------
    public void addDoc() {

        Scanner newdoctor = new Scanner(System.in);

        Doctor doc = new Doctor();

        System.out.print("Enter doctor name :");
        doc.setName(newdoctor.nextLine());

        System.out.print("Enter doctor's sure name : ");
        doc.setSureName(newdoctor.nextLine());

        System.out.print("enter doctors date of birth :");
        doc.setDateOfBirth(newdoctor.nextLine());

        System.out.print("enter doctors mobile number :");
        doc.setMobileNo(newdoctor.nextInt());

        System.out.print("enter doctor medical license number :");
        doc.setMedLicenseNo(newdoctor.nextInt());
        newdoctor.nextLine();

        System.out.print("Enter doctor's specialisation :");
        doc.setSpecialisation(newdoctor.nextLine());


        if (countDoctor <= 10){
            docList[countDoctor][0] = doc.getName();
            docList[countDoctor][1] = doc.getSureName();
            docList[countDoctor][2] = doc.getDateOfBirth();
            docList[countDoctor][3] = Integer.toString(doc.getMobileNo());
            docList[countDoctor][4] = Integer.toString(doc.getMedLicenseNo());
            docList[countDoctor][5] = doc.getSpecialisation();
            countDoctor++;
        }

        System.out.println("|| Doctor added successfully ||");
    }



    //-------------------------------------method to delete a doctor-------------------------------

    public void delDoc() {

        Scanner deldoctor = new Scanner(System.in);
        System.out.println("enter docs medical license number");
        int deldocNo = deldoctor.nextInt();

        String lNumber = Integer.toString(deldocNo);

        for(int i = 0; i < docList.length; i++){
            for(int j = 0; j< docList[i].length; j++){
                if(!Objects.equals(docList[i][j], "x")){
                    if (lNumber.equals(docList[i][4])){
                        System.out.println("Found the doc and getting deleting data");
                        Arrays.fill(docList[i], "x");
//                        docList[i][0] = "X";
//                        docList[i][1] = "X";
//                        docList[i][2] = "X";
//                        docList[i][3] = "X";
//                        docList[i][4] = "X";
//                        docList[i][5] = "X";
                    }
                }
            }
        }


        System.out.println(" XX Doctor successfully Deleted XX");
    }

    //------------------------------------------------method to view doctors--------------------------------------------
    public void viewDoc(){
        System.out.println("~viewing all doctor details~");
        System.out.println(" ");
        boolean enter = true;
        for (String[] values : docList){
            for (String value: values){
                if (!Objects.equals(value, "x"))
                    System.out.println(value + " ");
                else enter = false;
            }
            if (enter)
                System.out.println(" ");

        }
    }
    //------------------------------------------method to save data to a text file---------------------------------------
    public  void saveData() throws FileNotFoundException {
        // Open the file.
        PrintWriter out = new PrintWriter("DoctorList.txt");

        boolean enter = true;
        for (String[] values : docList){
            for (String value: values){
                if (!Objects.equals(value, "x"))
                    out.println(value + "");
                else enter = false;
            }
            if (enter)
                out.println("");
            out.println("");
        }
//

        System.out.println("successfully printed to the text file");

        // Close the file.
        out.close();  // Step 4

    }


    //------------------method to sort doctor's list according to alphabetical order by surname--------------------------
    public void orderDocList() {


        // Sort the array by the second index
        Arrays.sort(docList, Comparator.comparing(a -> a[1]));

        // Print the sorted array
        for (String[] row : docList) {
            System.out.println(Arrays.toString(row));

        }

    }

    //-------------------------------------------save consultation to a text file--------------------------------------

    public  void saveConsult(String name, String surname, String dob, String mobilno, String date, String medNO, String starttime , String endtime , String extranote, String guioutcost ,String patientID) throws IOException {

        // Open the file.

        FileWriter Writer = new FileWriter("Consultation.txt",true);
        Writer.write(name+"|"+surname+ "|" +dob+"|"+mobilno+"|"+date+"|"+medNO+"|"+starttime+"|"+endtime+"|"+extranote+"|"+guioutcost+"|"+patientID);
        Writer.write(System.getProperty("line.separator"));
        Writer.close();



        System.out.println("successfully printed to the text file");

    }

    //------------------------------------------------Method to initialize the array----------------------------------------------------
    public static void initialize(String[][] arr) {
        for(int i = 0; i < arr.length; i++)
            for (int j = 0; j<arr[i].length; j++){
                arr[i][j]= "x";
            }
    }






}

