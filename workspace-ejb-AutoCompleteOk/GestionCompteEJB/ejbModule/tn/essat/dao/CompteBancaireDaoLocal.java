package tn.essat.dao;

import java.util.List;

import javax.ejb.Local;

import tn.essat.entity.CompteBancaire;

@Local
public interface CompteBancaireDaoLocal {

	void save(CompteBancaire compteBancaire);

	void update(CompteBancaire compte);

	void delete(long rib);

	CompteBancaire getById(long rib);

	List<CompteBancaire> getAll();

}
