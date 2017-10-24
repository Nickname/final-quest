package fr.finalquest.model.quest;

import java.util.List;

import javax.persistence.*;

import fr.finalquest.model.*;

@Entity
@Table(name="scenario")
public class Scenario {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	String nom;
	
	@ManyToMany
	@JoinTable(name="scen_quete",
			joinColumns=
				@JoinColumn(name="id_scen", referencedColumnName="id"),
			inverseJoinColumns=
				@JoinColumn(name="id_quete", referencedColumnName="id"))
	List<Quete> quetes;

	@OneToMany(mappedBy="scenarios")
	List<Personnage> personnage;
	
	public Scenario() {	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Quete> getQuetes() {
		return quetes;
	}

	public void setQuetes(List<Quete> quetes) {
		this.quetes = quetes;
	}
}
