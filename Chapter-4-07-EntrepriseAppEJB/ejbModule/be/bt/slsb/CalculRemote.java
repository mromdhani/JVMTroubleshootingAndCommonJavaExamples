package be.bt.slsb;

import javax.ejb.Remote;

@Remote
public interface CalculRemote {
	int add(int a, int b);
}
