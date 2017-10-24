package fr.finalquest.dao;

import fr.finalquest.model.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.*;

public class PersonnageDao {
	
	private static PersonnageDao instance;
	private EntityManagerFactory entityMF;
	
	private PersonnageDao() {
		entityMF = Persistence.createEntityManagerFactory("finalquest");
	}
	
	public static PersonnageDao getInstance() {
		if (instance == null) {
			instance = new PersonnageDao();
		}
		
		return instance;
	}
	
	public List<Personnage> findAll() {
		EntityManager em = entityMF.createEntityManager();
		
		TypedQuery<Personnage> query = em.createQuery("select p from Personnage p", Personnage.class);
		
		return query.getResultList();
	}
	
	public Optional<Personnage> findByName(String prenom, String nom) {
		EntityManager em = entityMF.createEntityManager();
		
		String strQuery = "select p from Personnage p where p.prenom=:prenom and p.nom=:nom";
		TypedQuery<Personnage> query = em.createQuery(strQuery, Personnage.class);
		query.setParameter("prenom", prenom);
		query.setParameter("nom", nom);
		List<Personnage> personnage = query.getResultList();
		em.close();
		
		if (personnage.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(personnage.get(0));
		}
		
	}
	 
	public boolean create(Personnage p) {
		EntityManager em = entityMF.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
		em.close();
		
		return true;
	}
	
	public boolean update(String prenom, String nom, Personnage p) {
		EntityManager em = entityMF.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		Personnage updateP = findByName(prenom, nom).get();
		em.remove(updateP);
		em.persist(p);
		t.commit();
		em.close();
		
		return true;
	}
	
	public boolean delete(String prenom, String nom) {
		EntityManager em = entityMF.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		Personnage updateP = findByName(prenom, nom).get();
		em.remove(updateP);
		t.commit();
		em.close();
		
		return true;
	}
}
