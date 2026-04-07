package hostel;

import java.util.ArrayList;

class Student extends User {

    private String course;
    private double hostelFees;
    private Integer roomNumber;

    class GuardianDetails {

        String gName;
        String relation;

        GuardianDetails(String gName, String relation) {
            this.gName = gName;
            this.relation = relation;
        }

        public String toString() {
            return gName + " (" + relation + ")";
        }
    }

    private GuardianDetails guardian;

    public Student(String name, String bitsID) {
        super(name, bitsID, "Unknown");
    }

    public Student(
        String name,
        String bitsID,
        String contact,
        String course,
        String gName,
        String relation
    ) {
        super(name, bitsID, contact);
        this.course = course;
        this.guardian = new GuardianDetails(gName, relation);
        this.hostelFees = 45000.0;
    }

    @Override
    public void displayRole() {
        System.out.println("User Type: Resident (Student)");
    }

    public String getDetails() {
        return (
            "ID: " + bitsID + " | Name: " + name + " | Guardian: " + guardian
        );
    }

    public double getFees() {
        return hostelFees;
    }
}
