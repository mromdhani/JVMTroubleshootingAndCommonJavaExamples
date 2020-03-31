package be.businesstraining;

@FunctionalInterface
interface Calculus {
	int operation(int a, int b);
}

public class Example1_Hello_Lambda {
	public static void main(String[] args) {
		System.out.println("Java 8 Lambda Demo / Hello Lambda");

//        Calculus multiply =  new SomeFunctionContract() {
//			
//			@Override
//			public int operation(int a, int b) {				
//				return a *b;
//			}
//		};
		//
		Calculus multiply= (a, b) ->  a * b;
		
		int result = multiply.operation(11, 11);
		System.out.println(result);
		System.out.println("End of the Program");
	}
}
