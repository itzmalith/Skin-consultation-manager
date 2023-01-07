public class Doctor extends Person {
    private int medLicenseNo;

    private String specialisation;

    public int getMedLicenseNo() {
        return medLicenseNo;
    }
    public void setMedLicenseNo(int medLicenseNo) {
        this.medLicenseNo = medLicenseNo;

    }
    public String getSpecialisation() {
        return specialisation;

    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;

    }
}
