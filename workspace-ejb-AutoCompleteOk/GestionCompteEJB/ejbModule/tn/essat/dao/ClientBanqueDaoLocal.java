package tn.essat.dao;

import java.util.List;

import javax.ejb.Local;

import tn.essat.entity.ClientBanque;

@Local
public interface ClientBanqueDaoLocal {
	void save(ClientBanque client);

	void update(ClientBanque client);

	void delete(String cin);

	ClientBanque getById(String cin);

	List<ClientBanque> getAll();
}
