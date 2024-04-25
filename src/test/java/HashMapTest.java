import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashMapTest {

    @Test
    void remove() {
        HashMap map = new HashMap();
        LocalDate dob = LocalDate.of(1990, 5, 15);
        PatientId key1 = new PatientId("John", "Doe", dob);
        Patient patient1 = new Patient("John", "Doe", dob, LocalDate.now());
        //testing to check calling remove on an empty map returns null
        assertEquals(map.remove(key1), null);
        map.put(key1, patient1);
        Patient removedPatient = map.remove(key1);
        //testing remove is successful
        assertEquals(patient1, removedPatient);
        assertEquals(null, map.get(key1));
    }
}