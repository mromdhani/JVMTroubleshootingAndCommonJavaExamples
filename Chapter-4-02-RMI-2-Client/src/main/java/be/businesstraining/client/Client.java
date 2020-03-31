package be.businesstraining.client;

import java.rmi.Naming;

import be.businesstraining.service.Adder;

public class Client {
	public static void main(String[] args) {
		System.out.println("=== Calling the remote object ...");
		try {
			Adder myProxy = (Adder) Naming.lookup("rmi://localhost:1099/myadder");
			System.out.println(myProxy.add(44, 44));
		} catch (Exception e) {
			System.out.println("LOG : Exception occured : " + e);
		}
	}
}
