import java.util.LinkedList;

public class HashMap {
    // Set up base internal map/array
    // Set up variable to track the number of elements/pairs
    private final LinkedList<Entry>[] map;
    private int count;

    public HashMap(){
        map = new LinkedList[103];
        count = 0;
    }

    private int hashFunction(PatientId key){
        int slot = Math.abs(key.hashCode());
        slot = slot % map.length;
        return slot;
    }

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


    private static class Entry{
        protected PatientId key;
        protected Patient value;

        public Entry(PatientId key, Patient value){
            this.key = key;
            this.value = value;
        }

    }

}
