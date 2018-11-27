package tn.essat.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.essat.entity.CompteBancaire;

/**
 * Session Bean implementation class CompteBancaireDao
 */
@Singleton
public class CompteBancaireDao implements CompteBancaireDaoLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(CompteBancaire compteBancaire) {
		em.merge(compteBancaire);
	}

	@Override
	public void update(CompteBancaire compte) {
		em.merge(compte);
	}

	@Override
	public void delete(long rib) {
		em.remove(getById(rib));

	}

	@Override
	public CompteBancaire getById(long rib) {
		return em.find(CompteBancaire.class, rib);
	}

	@Override
	public List<CompteBancaire> getAll() {
		return em.createQuery("from CompteBancaire", CompteBancaire.class).getResultList();
	}

}
