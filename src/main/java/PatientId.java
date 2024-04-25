import java.time.LocalDate;
import java.util.Objects;

/**
 * This class is created to uniquely identify a Patient
 *
 */
public class PatientId {
    private String fName;
    private String sName;
    private LocalDate dob;

    public PatientId(String fName, String sName, LocalDate dob) {
        this.fName = fName;
        this.sName = sName;
        this.dob = dob;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientId patientId = (PatientId) o;

        if (!Objects.equals(fName, patientId.fName)) return false;
        if (!Objects.equals(sName, patientId.sName)) return false;
        return Objects.equals(dob, patientId.dob);
    }

    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        return result;
    }
}
