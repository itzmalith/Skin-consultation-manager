
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        //taking inputs
        WestminsterSkinConsultationManager.initialize(WestminsterSkinConsultationManager.docList);
        //calling the menu function
        takeOption();

    }
    //method taking menu options
    public static void takeOption() throws IOException {
        //initiating the scanner object
        Scanner userInput = new Scanner(System.in);
        //creating new object for WestminsterSkinConsultationManager class
        WestminsterSkinConsultationManager obj1 = new WestminsterSkinConsultationManager();
        //printing the valid commands
        System.out.print("""

                \t\t╔═══╦═════════════════════════════════╗
                \t\t║ A ║   Add a doctor to the system    ║\s
                \t\t║═══╠═════════════════════════════════╣
                \t\t║ D ║ Delete a doctor from the system ║\s
                \t\t║═══╠═════════════════════════════════╣
                \t\t║ V ║ View all doctors of the system  ║\s
                \t\t║═══╠═════════════════════════════════╣
                \t\t║ O ║ Order doctors alphabetically    ║\s
                \t\t║═══╠═════════════════════════════════╣
                \t\t║ G ║ Open Graphical User Interface   ║\s
                \t\t║═══╠═════════════════════════════════╣
                \t\t║ S ║ Save information in a file      ║\s
                \t\t║═══╠═════════════════════════════════╣
                \t\t║ Q ║         Quit program            ║\s
                \t\t╚═══╩═════════════════════════════════╝""");

        //looping
        while(true){

        System.out.println("\n Enter the menu option :>>");
        String menuOption = userInput.nextLine().toUpperCase();
        // If admin enter "A" then add customer method will be called

        if (menuOption.equals("A"))
            obj1.addDoc();
            // If admin enter "D" then deleting customer will be called
        else if(menuOption.equals("D"))
            obj1.delDoc();

            // If admin enter "S" then saving data to the text method will be called
        else if (menuOption.equals("S"))
            obj1.saveData();

            // If admin enter "V" then displaying customer and cabin details method will be called
        else  if(menuOption.equals("V")){
            obj1.viewDoc();
        }

        else if (menuOption.equals("O")) {
            obj1.orderDocList();
        }
        // If admin enter "Q" then program will get quit.
        else if (menuOption.equals("Q")) {
            System.exit(0);
        }
        //if user enter any invalid input
        else if (menuOption.equals("G")){
            new Table();
        }
        else{
            System.out.println("--------------invalid input-------------");
            }
        }

    }

}