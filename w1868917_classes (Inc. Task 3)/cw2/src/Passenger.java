// I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1868917
//Date: 20/04/2022

public class Passenger {
	private String fname;
	private String lname;
	private double expenses; // all the required variables are declared, with the class passengers per passengers

	// getters and setters are used for get and set the required data
	public String getFname() {
		return fname; 
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	// the constructor which initialized with the user inputs
	public Passenger(String fname, String lname, double expenses) {
		this.fname = fname;
		this.lname = lname;
		this.expenses = expenses;
	}

}
