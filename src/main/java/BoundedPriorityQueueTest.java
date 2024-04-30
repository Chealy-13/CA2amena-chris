import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

 class BoundedPriorityQueueTest{

    @Test
    void testAdd() {
        BoundedPriorityQueue queue = new BoundedPriorityQueue(2, "Dr. Smith"); // Create a BoundedPriorityQueue with a capacity of 2
        Appointment appt1 = new Appointment("Dr. Smith", LocalDate.now(), 1);//
        assertTrue(queue.add(appt1), "Should add the appointment when the doctor matches and queue is not full");

        Appointment appt2 = new Appointment("Dr. Smith", LocalDate.now().plusDays(1), 2);//
        assertTrue(queue.add(appt2), "Should add the appointment as the queue is not full yet");

        Appointment appt3 = new Appointment("Dr. Smith", LocalDate.now().plusDays(2), 3);
        assertFalse(queue.add(appt3), "Should not add the appointment as the queue is full"); //

        Appointment wrongDoc = new Appointment("Dr. Jones", LocalDate.now(), 1);
        assertFalse(queue.add(wrongDoc), "Should not add the appointment as the doctor does not match");
    }

    @Test
    void testOffer() {
        BoundedPriorityQueue queue = new BoundedPriorityQueue(1, "Dr. Smith");
        Appointment appt1 = new Appointment("Dr. Smith", LocalDate.now(), 1);
        assertTrue(queue.offer(appt1, 0), "Should add the appointment when the queue is not full and doctor matches"); // doctor matches

        Appointment appt2 = new Appointment("Dr. Smith", LocalDate.now().plusDays(1), 2);
        assertFalse(queue.offer(appt2, 0), "Should not add another appointment as the queue is full");
    }

    @Test
    void testPeek() {
        BoundedPriorityQueue queue = new BoundedPriorityQueue(1, "Dr. Smith"); // Create a BoundedPriorityQueue with a capacity of 2
        assertNull(queue.peek(), "Peek should return null when the queue is empty");

        Appointment appt1 = new Appointment("Dr. Smith", LocalDate.now(), 1);
        queue.add(appt1);
        assertEquals(appt1, queue.peek(), "Peek should return the first appointment without removing it");
    }

//    @Test
//    void testPoll() {
//        BoundedPriorityQueue queue = new BoundedPriorityQueue(1, "Dr. Smith");
//        assertNull(queue.poll(), "Poll should return null when the queue is empty");
//
//        Appointment appt1 = new Appointment("Dr. Smith", LocalDate.now(), 1);
//        queue.add(appt1);
//        assertEquals(appt1, queue.poll(), "Poll should return and remove the first appointment");
//        assertTrue(queue.isEmpty(), "Queue should be empty after poll");
//    }

    @Test
    void testIsEmpty() {
        BoundedPriorityQueue queue = new BoundedPriorityQueue(1, "Dr. Smith"); //
        assertTrue(queue.isEmpty(), "Queue should initially be empty");

        Appointment appt1 = new Appointment("Dr. Smith", LocalDate.now(), 1);
        queue.add(appt1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after adding an appointment");
    }

    @Test
    void testIsFull() {
        BoundedPriorityQueue queue = new BoundedPriorityQueue(1, "Dr. Smith");
        assertFalse(queue.isFull(), "Queue should not be full initially");

        Appointment appt1 = new Appointment("Dr. Smith", LocalDate.now(), 1);
        queue.add(appt1);
        assertTrue(queue.isFull(), "Queue should be full when capacity is reached"); // doctor matches
    }

}

