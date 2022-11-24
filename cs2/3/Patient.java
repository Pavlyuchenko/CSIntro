public class Patient extends Person {
    private String identificationNumber;

    public Patient(String name, int age, String identificationNumber) {
        super(name, age);
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return this.identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient) {
            Patient otherPatient = (Patient) obj;
            if (this.getAge() == otherPatient.getAge()
                    && this.getName().equals(otherPatient.getName())
                    && this.getIdentificationNumber().equals(otherPatient.getIdentificationNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getName() + "Person(" + this.getName() + ", " + Integer.toString(this.getAge()) + ", "
                + this.getIdentificationNumber() + ")";
    }

    public static void main(String[] args) {
        Patient pat = new Patient("Michal Pavlíček", 19, "M13");

        pat.setAge(20);
        pat.setIdentificationNumber("MP13");

        System.out.println(pat);
        System.out.println(pat.equals(pat));
    }
}
