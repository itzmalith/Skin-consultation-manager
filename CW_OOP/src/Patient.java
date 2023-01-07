import java.util.UUID;

public class Patient extends Person{
    public static String patientID;


    //getters setters
    public static String getPatientID() {
        String patientID = UUID.randomUUID().toString();
        patientID = patientID.replaceAll("-","");
        return patientID.substring(0, 4);
    }

    public void setPatientID(String patientID) {
        Patient.patientID = patientID;
    }



}
