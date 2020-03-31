package be.businesstraining.service;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class AdderImpl extends UnicastRemoteObject implements Adder {

	public AdderImpl() throws RemoteException {
		super();
	}

	public int add(int x, int y) {
		return x + y;
	}
}
