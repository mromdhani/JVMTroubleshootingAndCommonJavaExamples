package be.businesstraining.service;


import java.rmi.Naming;

public class Launcher {
	public static void main(String[] args) {
		try {
			Adder remteObject = new AdderImpl();
			Naming.rebind("rmi://localhost:1099/myadder", remteObject);
			System.out.println("Remote RMI is Up and running ...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
