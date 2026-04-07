package hostel;

import java.util.ArrayList;

interface SecurityOperations {
    void logVisitor(String name, String purpose);
    void triggerAlert(String alertType);
}

abstract class User {

    protected String name;
    protected String bitsID;
    protected String contact;

    public User(String name, String bitsID, String contact) {
        this.name = name;
        this.bitsID = bitsID;
        this.contact = contact;
    }

    public abstract void displayRole();
}
