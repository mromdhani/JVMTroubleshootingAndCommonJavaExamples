package be.businesstraining.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.businesstraining.domain.Compte;
import be.businesstraining.repository.IComptesDao;

@Service
public class ComptesServiceImpl implements IComptesService {

	private IComptesDao dao;
	
	public ComptesServiceImpl(IComptesDao dao) {
		super();
		this.dao = dao;
	}

   @Transactional(propagation = Propagation.REQUIRED)
   @Override
	public void createTwoAccounts(Compte c1, Compte c2)  {
		
		try {
			dao.create(c1);	
		} catch (Exception e) {
			System.out.println("LOG : Exception occured - Details : "+e);
		}
		try {
			dao.create(c2);
		} catch (Exception e) {
			System.out.println("LOG : Exception occured - Details : "+e);
		}
	}

}
