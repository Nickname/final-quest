package fr.finalquest.model;

import javax.persistence.*;

@Entity
@Table(name="caracteristique")
public class Caracteristique {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="valeur")
	private int valeur;
	
	@ManyToOne
	@JoinColumn(name="pers_caract")
	private Personnage personnage;
	
	public Caracteristique() {	}
	
	
	public Caracteristique(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
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
	
	public int getValeur() {
		return valeur;
	}
	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
