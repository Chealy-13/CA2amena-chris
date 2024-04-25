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

    @Test
    void put() {
        HashMap map = new HashMap();
        LocalDate dob1 = LocalDate.of(1990, 5, 15);
        PatientId key1 = new PatientId("John", "Doe", dob1);
        Patient patient1 = new Patient("John", "Doe", dob1, LocalDate.now());
        //testing put should return null for first time entering this key
        assertEquals(null, map.put(key1, patient1));
        //updating patient  and trying to add it with the same key
        Patient updatedPatient = new Patient("Billy", "Updated Doe", dob1, LocalDate.now());
        //should replace old value and return it
        assertEquals(patient1, map.put(key1, updatedPatient));
        //double check value was updted
        assertEquals(updatedPatient, map.get(key1));
    }

    @Test
    void get() {
        HashMap map = new HashMap();
        LocalDate dob1 = LocalDate.of(1990, 5, 15);
        PatientId key1 = new PatientId("John", "Doe", dob1);
        Patient patient1 = new Patient("John", "Doe", dob1, LocalDate.now());

        //testing on empty map
        assertEquals(null, map.get(key1));

        //testing on an existing entry
        map.put(key1, patient1);
        assertEquals(patient1, map.get(key1));

        //testing if key is wrong/does not exist
        LocalDate dob2 = LocalDate.of(1985, 8, 20);
        PatientId key2 = new PatientId("Billy", "joel", dob2);
        assertEquals(null, map.get(key2));

    }
}