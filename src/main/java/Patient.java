import java.time.LocalDate;
import java.util.Objects;

public class Patient {
    private String fName;
    private String sName;
    private LocalDate dob;
    private LocalDate joinDate;

    /**
     * Constructs a new Patient object with default values for all fields
     *
     * All strings will be empty, date will be set to current date, Linkedlist
     * will be empty
     */
    public Patient() {
    }

    /**
     * Constructs a new Patient object with specific fields
     *
     * All strings will be empty, date will be set to current date, Linkedlist
     * will be empty
     */
    public Patient(String fName, String sName, LocalDate dob, LocalDate joinDate) {
        this.fName = fName;
        this.sName = sName;
        this.dob = dob;
        this.joinDate = joinDate;
    }

    /**
     * Get the value of first name of patient
     *
     * @return the value of the string
     */
    public String getfName() {
        return fName;
    }

    /**
     * Get the value of second name of Patient
     *
     * @return the value of string
     */
    public String getsName() {
        return sName;
    }

    /**
     * Get the value of the patients date of birth
     *
     * @return the value of DOB
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Get the LocalDate value of the customers join date
     *
     * @return the value of the join Date
     */
    public LocalDate getJoinDate() {
        return joinDate;
    }


    /**
     * Set the first name of the patient
     *
     * @param fName to be updated
     * @return the value of updated first name
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Set the last name of the patient
     *
     * @param sName to be updated
     * @return the value of updated last name
     */
    public void setsName(String sName) {
        this.sName = sName;
    }

    /**
     * Set the value of patients DOB
     *
     * @param dob to update
     * @return the value of localDate of patients dob
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Set the join date of a customer
     *
     * @param joinDate to update
     * @return the value of the updated join date
     */
    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    ///////////


    @Override
    public int hashCode() {
        return Objects.hash(getfName(), getsName(), getDob(), getJoinDate());
    }

    /**
     * Compares this patient with another patient for equality.
     * Two patients are considered equal if they have the same first name,
     * second name, and date of birth.
     *
     * @param o the object to compare to this patient
     * @return true if the patients are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (!Objects.equals(fName, patient.fName)) return false;
        if (!Objects.equals(sName, patient.sName)) return false;
        return Objects.equals(dob, patient.dob);
    }

}