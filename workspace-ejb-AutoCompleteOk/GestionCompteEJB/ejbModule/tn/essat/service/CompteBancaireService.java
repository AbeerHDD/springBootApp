package tn.essat.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.essat.dao.ClientBanqueDaoLocal;
import tn.essat.dao.CompteBancaireDaoLocal;
import tn.essat.entity.ClientBanque;
import tn.essat.entity.CompteBancaire;

/**
 * Session Bean implementation class CompteBancaireService
 */
@Stateless
public class CompteBancaireService implements CompteBancaireServiceLocal {

	@EJB
	private CompteBancaireDaoLocal dao;

	@EJB
	private ClientBanqueDaoLocal daoClient;

	@Override
	public void save(CompteBancaire compteBancaire) {
		dao.save(compteBancaire);
	}

	@Override
	public void update(CompteBancaire compte) {
		CompteBancaire old = getById(compte.getRib());
		old.setClient(compte.getClient());
		old.setSolde(compte.getSolde());
		dao.update(compte);
	}

	@Override
	public void delete(long rib) {
		dao.delete(rib);
	}

	@Override
	public CompteBancaire getById(long rib) {
		return dao.getById(rib);
	}

	@Override
	public List<CompteBancaire> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(float solde, String cin) {

		ClientBanque client = daoClient.getById(cin);
		CompteBancaire compte = new CompteBancaire(solde, client);
		daoClient.update(client);
		dao.update(compte);

	}

}
