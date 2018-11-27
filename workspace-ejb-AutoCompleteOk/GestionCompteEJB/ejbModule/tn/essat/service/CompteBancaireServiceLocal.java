package tn.essat.service;

import java.util.List;

import javax.ejb.Local;

import tn.essat.entity.CompteBancaire;

@Local
public interface CompteBancaireServiceLocal {
	void save(CompteBancaire compteBancaire);

	void update(CompteBancaire compte);

	void delete(long rib);

	CompteBancaire getById(long rib);

	List<CompteBancaire> getAll();

	void save(float solde, String cin);
}
