import java.time.LocalDate;

public class Appointment {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String issue;
    private int triageLvl;
    private String docName;

    /**
     * Constructs a new Appointment object with default values for all fields
     *
     * All strings will be empty, date will be set to current date, int will be 0
     */
    public Appointment(String john, String doe, LocalDate now, String checkup, LocalDate nowed, int i, String s) {
    }

    /**
     * Constructs a new Appointment object with specific fields
     *
     * All strings will be empty, date will be set to current date, int will be 0
     */
    public Appointment(String firstName, String lastName, LocalDate dob, String issue, int triageLvl, String docName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.issue = issue;
        this.triageLvl = triageLvl;
        this.docName = docName;
    }
}
