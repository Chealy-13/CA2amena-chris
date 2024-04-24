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

    private int hashFunction(String key){
        int slot = Math.abs(key.hashCode());
        slot = slot % map.length;
        return slot;
    }

//    public Patient remove(String key){
//        int slot = hashFunction(key);
//        LinkedList<Entry> list = map[slot];
//        if(list == null){
//            return null;
//        }
//        for(Entry e: map[slot]) {
//            if (!e.key.equals(key))
//                return null;
//        }
////        if(!map[slot].key.equals(key)){
////            return null;
////        }
//
//        String toBeDeleted = map[slot].value;
//        // Set the stored value to null
//        map[slot].value = null;
//        // Return the copy of the stored value
//        return toBeDeleted;
//    }


    private static class Entry{
        protected String key;
        protected String value;

        public Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
