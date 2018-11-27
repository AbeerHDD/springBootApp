package tn.essat.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.essat.entity.ClientBanque;

/**
 * Session Bean implementation class ClientBanqueDao
 */
@Singleton
public class ClientBanqueDao implements ClientBanqueDaoLocal {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(ClientBanque client) {
		em.persist(client);

	}

	@Override
	public void update(ClientBanque client) {
		em.merge(client);

	}

	@Override
	public void delete(String cin) {
		em.remove(getById(cin));

	}

	@Override
	public ClientBanque getById(String cin) {
		return em.find(ClientBanque.class, cin);
	}

	@Override
	public List<ClientBanque> getAll() {
		return em.createQuery("from ClientBanque", ClientBanque.class).getResultList();
	}

}
