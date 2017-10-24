package fr.finalquest.model.quest;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="quete")
public class Quete {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="delai")
	int delai;
	
	@Column(name="debutCoordX")
	int debutCoordX;
	
	@Column(name="debutCoordY")
	int debutCoordY;
	
	@ManyToMany(mappedBy="quetes")
	List<Scenario> scenarios;
	
	@OneToMany(mappedBy="quete")
	List<ActionARealiser> actions;
	
	public Quete() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getDebutCoordX() {
		return debutCoordX;
	}

	public void setDebutCoordX(int debutCoordX) {
		this.debutCoordX = debutCoordX;
	}

	public int getDebutCoordY() {
		return debutCoordY;
	}

	public void setDebutCoordY(int debutCoordY) {
		this.debutCoordY = debutCoordY;
	}

	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}

	public List<ActionARealiser> getActions() {
		return actions;
	}

	public void setActions(List<ActionARealiser> actions) {
		this.actions = actions;
	}
}
