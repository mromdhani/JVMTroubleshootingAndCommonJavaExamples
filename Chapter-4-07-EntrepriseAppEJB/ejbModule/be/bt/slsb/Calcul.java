package be.bt.slsb;

import javax.ejb.Stateless;


@Stateless
public class Calcul implements CalculRemote, CalculLocal {

	@Override
	public int add(int a, int b){
		return a +b;
	}	

}
