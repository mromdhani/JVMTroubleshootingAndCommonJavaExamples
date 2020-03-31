package be.bt.slsb;

import javax.ejb.Local;

@Local
public interface CalculLocal {
	int add(int a, int b);
}
