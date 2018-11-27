package tn.essat.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.essat.dao.ClientBanqueDaoLocal;
import tn.essat.entity.ClientBanque;

/**
 * Session Bean implementation class ClientBanqueService
 */
@Stateless
public class ClientBanqueService implements ClientBanqueServiceLocal {

	@EJB
	private ClientBanqueDaoLocal dao;

	@Override
	public void save(ClientBanque client) {
		dao.save(client);

	}

	@Override
	public void update(ClientBanque client) {
		dao.update(client);

	}

	@Override
	public void delete(String cin) {
		dao.delete(cin);

	}

	@Override
	public ClientBanque getById(String cin) {
		return dao.getById(cin);
	}

	@Override
	public List<ClientBanque> getAll() {
		return dao.getAll();
	}

	public String getAll4AutoComplete() {
		StringBuilder dtos = new StringBuilder("");
		for (ClientBanque entity : getAll()) {
			dtos.append("{ \"value\" : \"" + entity.getNom() + " " + entity.getPrenom() + "\",");
			dtos.append("\"label\" : \"" + entity.getNom() + " " + entity.getPrenom() + "\",");
			dtos.append("\"id\" : \"" + entity.getCin() + "\"},");
		}
		dtos.deleteCharAt(dtos.length() - 1);
		return dtos.toString();
	}

}
