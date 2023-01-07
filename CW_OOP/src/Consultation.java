import java.time.*;
public class Consultation {

    LocalDate bookedDate = LocalDate.now();
    private double cost;
    private String notes;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
