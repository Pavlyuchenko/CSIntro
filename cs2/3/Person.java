public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;

        Person otherPerson = (Person) obj;
        if (this.age == otherPerson.getAge() && this.name.equals(otherPerson.getName())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(" + this.name + ", " + Integer.toString(this.age) + ")";
    }

    /*
     * public static void main(String[] args) {
     * Person pers = new Person("Michal", 10);
     * Person pers2 = new Person("Michal", 10);
     * 
     * System.out.println(pers.equals(pers2));
     * }
     */
}
