public abstract class MyLinkedList {
    Node head;
    private Node tail;
    private int numElements;
    private static final int MAX_SIZE = 10;

    public MyLinkedList() {
        head = null;
        tail = null;
        numElements = 0;
    }

    public abstract boolean add(Appointment appointment);

    public int size() {
        return numElements;
    }



    /**
     * Adds an Appointment object at a specified position in the linked list.
     *
     * @param position the position at which the new Appointment object should be inserted
     * @param appointment the Appointment object to be inserted
     * @return true if the insertion is successful, false if the list is full or the position is invalid
     */

    public boolean add(int position, Appointment appointment) {
        if (numElements >= MAX_SIZE || position < 0 || position > numElements) {
            return false;  // List is full or invalid position
        }
        Node newNode = new Node(appointment);
        if (head == null || position == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode;  // New tail if added at the end
            }
        }
        numElements++;
        return true;
    }

    /**
     * Retrieves an Appointment object at a specific position pos in the linked list.
     *
     * @param pos the position of the desired Appointment object in the list
     * @return the Appointment object at the specified position, or null if the position is out of bounds
     * @throws IndexOutOfBoundsException if the provided position is negative or greater than or equal to the number of elements in the list
     */
    public Appointment get(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Index " + pos + " out of bounds");
        }
        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    public Appointment tail() {
        return tail != null ? tail.data : null;
    }

    class Node {
        Appointment data;
        Node next;

        public Node(Appointment data) {
            this.data = data;
            this.next = null;
        }
    }
}