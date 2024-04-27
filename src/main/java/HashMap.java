import java.util.LinkedList;

public class HashMap {
    // Set up base internal map/array
    // Set up variable to track the number of elements/pairs
    private final LinkedList<Entry>[] map;
    private int count;

    /**
     * constructs an empty HashMap with an initial capacity of 103
     */
    public HashMap(){
        map = new LinkedList[103];
        count = 0;
    }

    /**
     * gets the hash value for a specified key using the hashCode method of the PatientId object
     * the hash value used to fit within the size of the map using modulus
     * @param key the key to be turned into the hash value
     * @return the hash value
     */
    private int hashFunction(PatientId key){
        int slot = Math.abs(key.hashCode());
        slot = slot % map.length;
        return slot;
    }

    /**
     * removes the entry with the specified key from the map
     * @param key the key of the entry to be removed
     * @return the value of the removed entry,
     * or null if no entry with the specified key is found
     */
    public Patient remove(PatientId key){
        int slot = hashFunction(key);
        LinkedList<Entry> list = map[slot];
        if(list == null){
            return null;
        }
        for(Entry e: map[slot]) {
            if (e.key.equals(key)){
                Patient toBeDeleted = e.value;
                // Set the stored value to null
                e.value = null;
                // Return the copy of the stored value
                return toBeDeleted;
            }

        }
        return null;
    }

    /**
     * returns the value of the key given, or null if this map does not have match for the key
     * @param key the key used to find the value
     * @return the value of the key given, or null if this map does not have match for the key
     * @throws IllegalArgumentException if the key is null
     */
    public Patient get(PatientId key){
        // VALIDATION!!!
        if(key == null){
            throw new IllegalArgumentException("Null cannot be used as a key");
        }
        if(count == 0){
            return null;
        }

        int slot = hashFunction(key);
        if(map[slot] == null){
            return null;
        }
        for(Entry e: map[slot]) {
            if (e.key.equals(key))
                return e.value;
        }

        return null;
    }

    /**
     * adds a value to the key given in the map,
     * if key given already has a value in map this will overwrite it and return old value
     * @param key the key to add a value to
     * @param value the value to be added to key
     * @return the old value with the same key or null if no match for the key in the map
     */
    public Patient put(PatientId key, Patient value){
        int slot = hashFunction(key);
        if(map[slot] == null){
            LinkedList<Entry> slotList = new LinkedList<Entry>();
            map[slot] = slotList;
        }

        for(Entry e: map[slot]){
            if(e.key.equals(key)){
                Patient oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        Entry newEntry = new Entry(key, value);
        map[slot].add(newEntry);
        count++;

        return null;
    }

    /**
     * checks if the specified key is in the HashMap.
     * @param key the key to be tested
     * @return true if the HashMap contains the specified key, false otherwise
     * @throws IllegalArgumentException if the key is null
     */
    public boolean containsKey(PatientId key) {
        int slot = hashFunction(key);
        LinkedList<Entry> list = map[slot];
        if (list == null) {
            return false;
        }
        for (Entry e : list) {
            if (e.key.equals(key)) {
                return true; // Found the key
            }
        }
        return false; // Key not found
    }


    private static class Entry{
        protected PatientId key;
        protected Patient value;

        public Entry(PatientId key, Patient value){
            this.key = key;
            this.value = value;
        }

    }

}
