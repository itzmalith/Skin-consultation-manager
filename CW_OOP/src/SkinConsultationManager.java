import java.io.FileNotFoundException;
import java.io.IOException;

public interface SkinConsultationManager {

    void addDoc();
    void delDoc();
    void viewDoc();
    void saveData()throws FileNotFoundException;

    void orderDocList();

    void saveConsult(String name, String surname, String dob, String mobilno, String date, String medNO, String starttime , String endtime , String extranote, String guioutcost,String patientID) throws IOException;


}
