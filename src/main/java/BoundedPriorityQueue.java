public class BoundedPriorityQueue extends MyLinkedList {
    private int capacity;
    private String docName;

    protected BoundedPriorityQueue(int capacity, String docName) {
        this.capacity = capacity;
        this.docName = docName.toLowerCase(); // Normalize the doctor's name for case-insensitive comparison
    }

    /**
     * Adds an appointment to the queue
     *
     * @param appointment appointment to be added to the queue
     * @return true if the appointemnet was added  false if the queue if full  or does not match
     */

    @Override
    public boolean add(Appointment appointment) {
        if ((size() >= capacity) || !appointment.getDocName().equalsIgnoreCase(docName)) {
            return false;  // Fail fast if the queue is full or the appointment is for a different doctor
        }
        int newPosition = calcPosition(appointment);
        return super.add(newPosition, appointment); // Assuming a method add(int index, Appointment data) in MyLinkedList
    }
    /**

     * @param appointment attempts to add  the appointment  to added to the queue
     * @param position    The intended position for the appointment, not used.
     * @return True if the appointment was successfully added, false otherwise.
     */


    public boolean offer(Appointment appointment, int position) {
        if (isFull()) {
            return false;
        } else if (!appointment.getDocName().equalsIgnoreCase(docName)) {
            return false;
        }
        return add(position, appointment);
    }
    /**
     * Retrieves, but does not remove, the first appointment in the queue
     *
     * @return the first appointment, or null if the queue is empty
     */
    public Appointment peek() {
        if (isEmpty()) {
            return null; // Return null if the queue is empty
        }
        return getFirst(); // Assuming getFirst() retrieves and does not remove the head appointment
    }

    public Appointment poll() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }
    /**
     * Checks if the queue is empty
     *
     * @return True if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Checks if the queue is full
     *
     * @return True if the queue is at full capacity, false otherwise
     */
    public boolean isFull() {
        return size() == capacity;
    }
    /**
     * Returns the number of appointments in the queue.
     *
     * @return the size of the queue.
     */
    public int size() {
        return super.size(); // Assuming size() returns the number of elements in MyLinkedList
    }

    /**
     * calculates the correct position for an appointment based on triage level and date
     *
     * @param appointment  appointment for which to calculate the position
     * @return the index at which the appointment should be inserted
     */
    public int calcPosition(Appointment appointment) {
        // Start from the beginning of the list
        Node current = head;
        int index = 0;
        // Iterate through the linked list to find the right position based on triage level and date
        while (current != null) {
            if (appointment.getTriageLvl() < current.data.getTriageLvl() ||
                    (appointment.getTriageLvl() == current.data.getTriageLvl() &&
                            appointment.getDate().isBefore(current.data.getDate()))) {
                return index;
            }
            current = current.next;
            index++;
        }
        // If the appointment has the lowest priority or the list is empty, it goes to the end
        return index;
    }

    // Define the getFirst() method
    // Retrieves and does not remove the head appointment
    public Appointment getFirst() {
        if (isEmpty()) {
            return null;
        }
        return getHeadData();
    }

    /**
     * Removes and returns the head of the queue.
     *
     * @return The appointment that was at the head of the queue, or null if the queue was empty.
     */
    public Appointment removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Appointment first = getHeadData();
        Node temp = head;
        head = head.next;
        temp.data = null;
        temp = null;
        return first;
    }

    /**
     * retrieves the data of the first node head of the queue
     *
     * @return the appointment at the head of the queue, or null if the queue is empty
     */
    private Appointment getHeadData() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }
}