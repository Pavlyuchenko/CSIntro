public class Doctor extends Person {
    private String speciality;
    private double officeVisitFee;

    public Doctor(String name, int age, String specialty, double officeVisitFee) {
        super(name, age);
        this.speciality = specialty;
        this.officeVisitFee = officeVisitFee;
    }

    public String getSpecialty() {
        return this.speciality;
    }

    public double getOfficeVisitFee() {
        return this.officeVisitFee;
    }

    public void setOfficeVisitFee(double officeVisitFee) {
        this.officeVisitFee = officeVisitFee;
    }

    public void setSpecialty(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Doctor) {
            Doctor otherDoctor = (Doctor) obj;
            if (this.getAge() == otherDoctor.getAge()
                    && this.getName().equals(otherDoctor.getName())
                    && this.getSpecialty().equals(otherDoctor.getSpecialty())
                    && this.getOfficeVisitFee() == otherDoctor.officeVisitFee) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getName() + "Person(" + this.getName() + ", " + Integer.toString(this.getAge()) + ", "
                + this.getSpecialty() + ", " + Double.toString(this.getOfficeVisitFee()) + ")";
    }

    public static void main(String[] args) {
        Doctor doc = new Doctor("Dr. House", 54, "Smart guy", 9999);

        doc.setOfficeVisitFee(420);
        doc.setSpecialty("A very smart guy");

        System.out.println(doc.toString());
        System.out.println(doc.equals(doc));
    }
}
