package Student;

public class Student {
    private int id;
    private String name;
    private String dateOfBirth;
    private String address;
    private double gpa;

    public Student(int id, String name, String dateOfBirth, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gpa = gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return this.gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Date of Birth: " + dateOfBirth +
                ", Address: " + address + ", GPA: " + gpa;
    }
}
