// I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1868917
//Date: 20/04/2022

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
	static cQueue queue = new cQueue();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Cabin[] cabins = new Cabin[12]; // an empty string array of 12 is created

		initialize(cabins); // an empty string array of 12 is created

		while (true) { // an infinite loop is taken to ensure the menu runs continously
			System.out.println("\n--------------------------------------------------------");
			System.out.println("\t\t\tMain Menu");
			System.out.println("--------------------------------------------------------\n");

			System.out.println("A. Add Customer");
			System.out.println("V. View all Cabins");
			System.out.println("E. Display Empty Cabins");
			System.out.println("D. Delete Customer");
			System.out.println("F. Find Cabin (With Name)");
			System.out.println("S. Store to File");
			System.out.println("L. Load from File");
			System.out.println("O. View Passengers (Alphabetical)");
			System.out.println("T. To Print All Expenses Per Passenger");
			System.out.println("0 (zero): Exit The Program");

			System.out.println("--------------------------------------------------------\n");

			System.out.print("Choice: ");
			String choice = sc.next().toLowerCase().toUpperCase();

			switch (choice) { // a loop is taken in-order to filter out the users choice
			case "A":
				addCustomer(cabins);
				break;

			case "V":
				viewAllCabins(cabins);
				break;

			case "E":
				displayEmpty(cabins);
				break;

			case "D":
				deleteCustomer(cabins);
				break;

			case "F":
				findCustomer(cabins);
				break;

			case "S":
				storeCustomer(cabins);
				break;

			case "L":
				loadCustomer();
				break;

			case "O":
				orderCustomer(cabins);
				break;

			case "T":
				printExpenses(cabins);
				break;

			case "0":
				System.exit(0);

			default:
				System.out.println("Invaild Input Please Try Again");
			}
		}
	}

	private static void printExpenses(Cabin cabins[]) { // this gets a cabin array instead of a string array through
														// parameters
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tAll Passenger Expenses ");
		System.out.println("--------------------------------------------------------\n");

		double sum = 0;

		for (int x = 0; x < cabins.length; x++) {
			Passenger[] passengers = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																// passengers in the cabin
			System.out.println(("\n\nCabin: " + (x + 1)));
			for (int y = 0; y < 3; y++) {
				System.out.println("\nPassenger: " + (y + 1));
				sum = passengers[y].getExpenses() + sum;
				System.out.println("Expense is: " + passengers[y].getExpenses());
			}
		}
		System.out.println("The Total Expenses are: " + sum);
	}

	private static void orderCustomer(Cabin cabins[]) {
		// this part of the sort is used to order the passengers per cabin in
		// alphabetical order
		Passenger temp;
		for (int x = 0; x < cabins.length; x++) {
			Passenger[] passengers = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																// passengers in the cabin
			for (int j = 0; j < 3 - 1; j++) {
				for (int i = j + 1; i < 3; i++) {
					if (passengers[j].getFname().compareTo(passengers[i].getFname()) > 0) {
						temp = passengers[j];
						passengers[j] = passengers[i];
						passengers[i] = temp;
					}
				}
			}
		}
		// once the passengers are sorted in alphabetical order each cabin is sorted
		// alphabetically
		Cabin temp2;
		for (int j = 0; j < cabins.length - 1; j++) {
			for (int i = j + 1; i < cabins.length; i++) {
				Passenger[] p1 = cabins[j].getPassengers();
				Passenger[] p2 = cabins[i].getPassengers();
				if (p1[0].getFname().compareTo(p2[0].getFname()) > 0) {
					temp2 = cabins[j];
					cabins[j] = cabins[i];
					cabins[i] = temp2;
				}
			}
		}

		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tThe Sorted Names ares");
		System.out.println("--------------------------------------------------------\n");
		for (int x = 0; x < cabins.length; x++) {
			Passenger[] passengers2 = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																	// passengers in the cabin
			System.out.println("\n");
			System.out.println("Cabin Number: " + (x + 1));
			for (int y = 0; y < 3; y++) { // this loop is used for the three passengers per cabin
				System.out.println("Passenger (" + (y + 1) + ") Name: " + passengers2[y].getFname());
			}
		}
	}

	private static void loadCustomer() {
		try {
			BufferedReader filereader = new BufferedReader(new FileReader("classes_output.txt"));
			String linebyline;
			while ((linebyline = filereader.readLine()) != null) {
				System.out.println(linebyline);
			}
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void storeCustomer(Cabin[] cabins) {
		try {
			BufferedWriter filewriter = new BufferedWriter(new FileWriter("classes_output.txt"));

			for (int x = 0; x < cabins.length; x++) {
				Passenger[] passengers = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																	// passengers in the cabin
				filewriter.write("\n\nCabin: " + (x + 1));
				for (int y = 0; y < 3; y++) { // this loop is used for the three passengers per cabin
					filewriter.write("\n" + "Cabin " + (x + 1) + ". Passenger Number " + (y + 1) + " :"
							+ passengers[y].getFname() + " " + passengers[y].getLname());
				}
			}
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void findCustomer(Cabin[] cabins) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tFind Cabin (With Name)");
		System.out.println("--------------------------------------------------------\n");

		System.out.println("Enter Customer First Name to be Found: ");
		String customer = sc.next();

		for (int x = 0; x < cabins.length; x++) {
			Passenger[] passengers = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																// passengers in the cabin
			for (int y = 0; y < 3; y++) { // this loop is used for the three passengers per cabin
				if (passengers[y].getFname().equals(customer)) { // in the inner loop the fname is checked here to see
																	// if the entered string is equal to the fname
					System.out.println("Customer is in [" + (x + 1) + "] Cabin ");
					break;
				} else {
					System.out.println("Customer Not Found.");
					break;
				}
			}
		}
	}

	private static void deleteCustomer(Cabin[] cabins) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tDeleted Entry");
		System.out.println("--------------------------------------------------------\n");

		System.out.println("Enter Customer First Name to be deleted: ");
		String customer = sc.next();

		for (int x = 0; x < cabins.length; x++) {
			Passenger[] passengers = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																// passengers in the cabin
			for (int y = 0; y < 3; y++) { // this loop is used for the three passengers per cabin

				if (passengers[y].getFname().equals(customer)) { // since the we assume that the search is done as per
																	// the first name we use the method getFname
																	// specifically

					System.out.println("\n\nPassenger Deleted"); // the required passenger is deleted along with all its
																	// information
					passengers[y].setFname("e");
					passengers[y].setLname("e");
					passengers[y].setExpenses(0);

					addNextInQueue(cabins, x, y); // after deleting space is filled with next in queue(main array, cabin
													// num, passenger num)
				} else {
					System.out.println("Customer Not Found.");
					break;
				}
			}
		}
	}

	private static void addNextInQueue(Cabin[] cabins, int x, int y) {
		if (!queue.checkEmpty()) { // if the queue is not empty new set is loaded here
			System.out.println("\n\nNext In waiting queue will be added"); // after deleting the next in line in the
																			// queue is added
			Passenger next = queue.getNext();

			cabins[x].addPassenger(next, y); // if the space is available next passenger is added
		}

	}

	private static void displayEmpty(Cabin[] cabins) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tEmpty Cabins");
		System.out.println("--------------------------------------------------------\n");
		for (int x = 0; x < cabins.length; x++) {
			Passenger[] passengers = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																// passengers in the cabin
			if (passengers[0].getFname().equals("e")) { // since the we assume that the search is done as per the first
														// name we use the method getFname specifically
				System.out.println("Room " + (x + 1) + ". Is Empty ");
			}
		}
	}

	private static void viewAllCabins(Cabin[] cabins) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tView Cabins");
		System.out.println("--------------------------------------------------------\n");

		for (int x = 0; x < cabins.length; x++) {
			Passenger[] passengers = cabins[x].getPassengers(); // for each cabin using the loop(x) we get the three
																// passengers in the cabin
			System.out.println("\n\nCabin: " + (x + 1));
			for (int y = 0; y < 3; y++) { // this loop is used for the three passengers per cabin
				System.out.println("\nPassenger Number: " + (y + 1));
				System.out.println("Passenger First Name: " + passengers[y].getFname());
				System.out.println("Passenger Last Name: " + passengers[y].getLname());
			}
		}

	}

	private static Cabin cabinCheckSpace(Cabin[] cabins) {
		for (int x = 0; x < cabins.length; x++) {
			if (cabins[x].checkSpace() != -1)
				return cabins[x]; // every cabin is checked and if there is space then the cabin is returned
		}

		return null; // there is no free space
	}

	private static void addCustomer(Cabin[] cabins) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tAdd Customer");
		System.out.println("--------------------------------------------------------\n");

		if (queue.checkFull())
			System.out.println("\t\tThe waiting queue is full ");
		else {

			System.out.println("Enter the First Name of Passenger ");
			String fname = sc.next();
			System.out.println("Enter the Last Name of Passenger ");
			String lname = sc.next();
			System.out.println("Enter the Expenses of Passenger ");
			double expenses = sc.nextDouble();

			System.out.println(
					"Customer " + fname + " " + lname + " has been added to the room with the expenses " + expenses);

			Passenger passenger = new Passenger(fname, lname, expenses); // each entered value is passed upon to the
																			// passenger class

			Cabin hasSpace = cabinCheckSpace(cabins); // that passed value is brought here.

			if (hasSpace != null) { // if the space is available the values are passed here
				System.out.println();
				System.out.println("Successfully added to Cabin"); // if the cabins are not full this will pop up
				cabins[hasSpace.getCabinNum()].addPassenger(passenger, hasSpace.checkSpace());
			} else {
				System.out.println();
				System.out.println("Cabins are full added to queue"); // otherwise this will be printed
				queue.addToQueue(passenger); // all cabins are full this is added to the queue
			}
		}

	}

	private static void initialize(Cabin cabins[]) {
		for (int x = 0; x < cabins.length; x++) {
			cabins[x] = new Cabin(x); // we pass the loop value to the cabins array and the Cabin class
			Passenger passenger = new Passenger("e", "e", 0.0); // we call upon the passenger class to store the the two
																// names and the expenses.
			cabins[x].addPassenger(passenger, 0);
			cabins[x].addPassenger(passenger, 1);
			cabins[x].addPassenger(passenger, 2); // this is done three times as per the specification as each cabin
													// holds three people
		}
		System.out.println("\t\tInitialize Complete...");
	}

}