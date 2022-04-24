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

class CWarray {
	static Scanner sc = new Scanner(System.in); // instead of calling a Scanner in each method we use the keyword static
												// to make the call global

	public static void main(String[] args) {

		String[] cabins = new String[12]; // an empty string array of 12 is created

		initialize(cabins); // the array is passed for the first time to assign the element "e" to the array

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
			System.out.println("0 (zero): Exit The Program");

			System.out.println("--------------------------------------------------------\n"); // a menu is created
																								// inorder to help the
																								// user guide through
																								// the program

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

			case "0":
				System.exit(0); // will exit the program gracefully

			default:
				System.out.println("Invaild Input Please Try Again"); // if the user gives an unrecognized input this
																		// will come to fruition

			}
		}
	}

	private static void initialize(String cabins[]) {
		for (int x = 0; x < cabins.length; x++) {
			cabins[x] = "e"; // this assigns e to the array cabins for the given length of times
		}
		System.out.println();
		System.out.println("\t\tInitialize Complete...");
	}

	// used to display all cabins along with empty ones
	private static void viewAllCabins(String[] cabins) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tView Cabins");
		System.out.println("--------------------------------------------------------\n");
		for (int x = 0; x < cabins.length; x++) {
			System.out.println("Room number: " + (x + 1) + "Customer: " + cabins[x]);
		}
	}

	// used to add a customer onto the cabin with a required cabin number
	private static void addCustomer(String[] cabins) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tAdd Customer");
		System.out.println("--------------------------------------------------------\n");

		System.out.println("Cabin Number");
		int cabinNum = sc.nextInt();

		System.out.println("Customer Name");
		String customer = sc.next();

		System.out.println("Customer " + customer + " has been added to room " + cabinNum);

		cabins[cabinNum - 1] = customer; // -1 because array starts from 0 but rooms don't start from 0
	}

	// this will display only the empty cabins
	private static void displayEmpty(String cabins[]) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tEmpty Cabins");
		System.out.println("--------------------------------------------------------\n");
		for (int x = 0; x < cabins.length; x++) {
			if (cabins[x] == "e") {
				System.out.println("Room" + (x + 1) + ". Is Empty ");
			}
		}
	}

	// this will take a user input and delete said input, we assume only 1 person
	// with the same name will be there
	private static void deleteCustomer(String cabins[]) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tDeleted Entry");
		System.out.println("--------------------------------------------------------\n");

		System.out.println("Enter Customer Name to be deleted: ");
		String customer = sc.next();

		for (int x = 0; x < cabins.length; x++) {
			System.out.println("Customer " + cabins[x] + " has been Deleted");
			if (cabins[x].equals(customer)) {
				cabins[x] = "e";
				break;
			} else {
				System.out.println("Customer Not Found.");
				break;
			}
		}
	}

	// this will filter the name given by the user and display it, we assume only 1
	// person with the same name will be there
	private static void findCustomer(String cabins[]) {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tFind Cabin (With Name)");
		System.out.println("--------------------------------------------------------\n");

		System.out.println("Enter Customer Name to be Found: ");
		String customer = sc.next();

		for (int x = 0; x < cabins.length; x++) {
			if (cabins[x].equals(customer)) {
				System.out.println("Customer " + cabins[x] + " is in cabin " + (x + 1));
				break;
			} else {
				System.out.println("Customer Not Found.");
				break;
			}
		}
	}

	// this will create a text file and store the current runs data
	private static void storeCustomer(String cabins[]) {
		try {
			BufferedWriter filewriter = new BufferedWriter(new FileWriter("Array_Output.txt"));

			for (int x = 0; x < cabins.length; x++) {
				filewriter.write("\n" + "Room" + (x + 1) + " Customer: " + cabins[x]);
			}
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// this will load the previously stored text file onto the current run and print
	// it
	private static void loadCustomer() {
		try {
			BufferedReader filereader = new BufferedReader(new FileReader("Array_Output.txt"));
			String linebyline;
			while ((linebyline = filereader.readLine()) != null) {
				System.out.println(linebyline);
			}
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// this uses the bubble sort sorting method and sort all customers in
	// alphabetical order but will display empty elements as well
	private static void orderCustomer(String cabins[]) {
		String temp;
		for (int j = 0; j < cabins.length - 1; j++) {
			for (int i = j + 1; i < cabins.length; i++) {
				if (cabins[j].compareTo(cabins[i]) > 0) {
					temp = cabins[j];
					cabins[j] = cabins[i];
					cabins[i] = temp;
				}
			}
		}
		System.out.println("\n--------------------------------------------------------");
		System.out.println("\t\t\tThe Sorted Names are: ");
		System.out.println("--------------------------------------------------------\n");
		for (int x = 0; x < cabins.length; x++)
			System.out.println("Occupant: " + cabins[x]);
	}
}