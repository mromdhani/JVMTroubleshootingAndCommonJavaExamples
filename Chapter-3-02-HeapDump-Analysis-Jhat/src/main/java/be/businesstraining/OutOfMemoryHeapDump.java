package be.businesstraining;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryHeapDump {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting the demo OutOfMemoryHeapDump");
		
		Thread.sleep(8000);
		List<ObjectForLeak> leak = new ArrayList<>();

		while (true) {
			leak.add(new ObjectForLeak());
		}
	}

}
