import java.util.Arrays;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//Write a program that asks the user for:
//• The upper bound to put on the queue.
        System.out.println("Enter the upper bound of the queue");
        int upperBound = sc.nextInt();
        sc.nextLine();
//• The doctors rostered for the day.
        System.out.println("Enter the doctors rostered for the day");
        String docName = sc.nextLine();
        String[] doctorsRostered = docName.split(" ");

        System.out.println(Arrays.toString(doctorsRostered));

//        The program should then build the appropriate structures (there should be a queue for each doctor rostered that day). You may
//        store the queues in a data structure if you wish, but you must build it yourself OR use an array (no use of the built-in structures).
        BoundedPriorityQueue[] queues = new BoundedPriorityQueue[doctorsRostered.length];
        for (int i = 0; i < doctorsRostered.length; i++) {
            queues[i] = new BoundedPriorityQueue(upperBound, doctorsRostered[i].trim());
        }

//        Once the program has finished the set up stage, it should repeatedly allow the user choose from the following options:
        boolean exit = false;
        while (!exit) {
            //to do add exception handling for wrong inputs.ie not inputting a number

            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new patient");
            System.out.println("2. Delete a patient");
            System.out.println("3. Display all patients");
            System.out.println("4. Create a new appointment");
            System.out.println("5. Call the next patient for a specific doctor");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    //• Add a new patient to the practice (where there is already a patient with that first name, last name and date of birth, the
                    //user should be informed and the patient should not be added).
                    break;
                case 2:
                    //• Delete a patient from the practice (you should handle any outstanding appointments appropriately – this may require
                    //adding an extra method to your queue outside the standard functionality)
                    break;
                case 3:
                    //• Display all patients
                    break;
                case 4:
                    //• Create a new appointment for a specific patient and add it to the queue (the appointment should be allocated a
                    //random triage level between 1 and 5)
                    break;
                case 5:
                    //• Call the next patient in for a specified doctor (this should pull the next appointment from that doctor’s queue and
                    //display its details to the user).
                    break;
                case 6:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}