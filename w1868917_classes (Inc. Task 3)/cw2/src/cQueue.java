// I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1868917
//Date: 20/04/2022

public class cQueue {
	private int front, rear;
	Passenger[] queue = new Passenger[3]; // the size for the queue is assumed as 4

	public cQueue() {
		this.front = -1;
		this.rear = -1;
	}

	// the help for the code is taken from
	// https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
	public void addToQueue(Passenger passenger) {
		if (checkFull())
			System.out.println("Queue is full Please Wait."); // if the queue is also completely full this message will
																// be printed.

		// if the queue is empty this is made to be the first element of the waiting
		// array
		else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = passenger;
		}

		// since this is a circular queue, if the rear is pointing at the last element
		// of the array go back to the front
		else if (rear == queue.length - 1 && front != 0) {
			rear = 0;
			queue[rear] = passenger;
		}

		else {
			rear = (rear + 1);

			// Adding a new element if the front pointer is less than the rear pointer
			if (front <= rear) {
				queue[rear] = passenger;
			}

			else {
				queue[rear] = passenger;
			}
		}
	}

	// get the next in line in the queue
	public Passenger getNext() {
		if (checkEmpty()) {
			System.out.print("Queue is Empty");
			return null;
		}

		Passenger nextPasseneger = queue[front];
		// if only one passenger in queue
		if (front == rear) {
			front = -1;
			rear = -1;
		}

		else if (front == queue.length - 1) {
			front = 0;
		} else {
			front = front + 1;
		}

		return nextPasseneger;
	}

	// if the queue is empty or not is shown here
	public boolean checkEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	// to check if the is list is full
	public boolean checkFull() {
		if ((rear + 1) % queue.length == front) {
			return true;
		}
		return false;
	}

}
