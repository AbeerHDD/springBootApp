package tn.essat.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompteBancaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rib;
	private float solde;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private ClientBanque client;

	public CompteBancaire() {
		super();
	}

	public CompteBancaire(float solde, ClientBanque client) {
		super();
		this.solde = solde;
		this.client = client;
	}

	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public ClientBanque getClient() {
		return client;
	}

	public void setClient(ClientBanque client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rib ^ (rib >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CompteBancaire other = (CompteBancaire) obj;
		if (rib != other.rib) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CompteBancaire [rib=" + rib + ", solde=" + solde + ", client=" + client + "]";
	}

}