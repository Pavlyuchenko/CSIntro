public class Bill {
    private Doctor doctor;
    private Patient patient;
    private double amountDue;

    public Bill(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        this.amountDue = doctor.getOfficeVisitFee();
    }

    public double getAmountDue() {
        return this.amountDue;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(" + this.patient.getName() + ", " + this.doctor.getName() + ", "
                + this.getAmountDue() + ")";
    }
}
