package be.businesstraining;


public class Example2_Runnable {
	public static void main(String[] args) {
		System.out.println("Java 8 Lambda Demo /Runnable");

		// Lambda Runnable
		Runnable task = () -> { System.out.println("Task is running"); };
		 
		// start the thread
		new Thread(task).start();
		
		System.out.println("End of the Program ....");
		
	}
}
