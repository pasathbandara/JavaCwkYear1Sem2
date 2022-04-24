// I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1868917
//Date: 20/04/2022

public class Cabin {

	// the three passengers in the cabin
	Passenger[] passengers = new Passenger[3]; // passengers array is created for the purpose of holding the three elements (names and expenses)
	int cabinNum;

	public Cabin(int cabinNum) {
		this.cabinNum = cabinNum;
	}

	public int getCabinNum() {
		return cabinNum;
	}
	
	// the print the total of the expenses 
	public double getTotalExpenses() {
		return passengers[0].getExpenses() + passengers[1].getExpenses() + passengers[2].getExpenses();
	}

	public Passenger[] getPassengers() {
		return passengers; // returns the passengers array
	}
	
	// to add a new passenger to the cabin
	public void addPassenger(Passenger passenger, int num) {
		this.passengers[num] = passenger; 
	}
	
	// to check the availability of the queue for the three passengers
	public int checkSpace() {
		for (int x = 0; x < 3; x++) {
			if (passengers[x].getFname().equals("e"))
				return x; // this returns the index of the available space
		}
		return -1;
	}

}
