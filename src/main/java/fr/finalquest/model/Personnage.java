package fr.finalquest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import fr.finalquest.model.quest.*;

@Entity
@Table(name="personnage",
		uniqueConstraints = {@UniqueConstraint(columnNames= {"nom", "prenom"})}
)
public class Personnage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="age")
	private int age;
	
	@Enumerated(EnumType.STRING)
	@Column(name="classe")
	private Classe classe;
	
	@OneToMany(mappedBy="personnage")
	private List<Caracteristique> caracteristiques;
	
	@ManyToMany
	@JoinTable(name="pers_scen",
			joinColumns=
				@JoinColumn(name="id_pers", referencedColumnName="id"),
			inverseJoinColumns=
				@JoinColumn(name="id_scen", referencedColumnName="id"))
	private List<Scenario> scenarios;
	
	public Personnage() {
		
	}
	
	public Personnage(String prenom, String nom, int age, Classe classe) {
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
		this.classe = classe;
		this.caracteristiques = initCaracteristique(classe);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Classe getClasse() {
		return classe;
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public List<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	
	public List<Caracteristique> initCaracteristique(Classe classe) {
		List<Caracteristique> caracteristiques = new ArrayList<>();
		
		if (classe.equals(Classe.GUERRIER)) {
			caracteristiques.add(new Caracteristique("force", 80));
			caracteristiques.add(new Caracteristique("agilité", 40));
			caracteristiques.add(new Caracteristique("magie", 20));
		} else if (classe.equals(Classe.VOLEUR)) {
			caracteristiques.add(new Caracteristique("force", 40));
			caracteristiques.add(new Caracteristique("agilité", 80));
			caracteristiques.add(new Caracteristique("magie", 20));
		} else if (classe.equals(Classe.ARCHER)) {
			caracteristiques.add(new Caracteristique("force", 20));
			caracteristiques.add(new Caracteristique("agilité", 60));
			caracteristiques.add(new Caracteristique("magie", 60));
		} else if (classe.equals(Classe.MAGICIEN)) {
			caracteristiques.add(new Caracteristique("force", 20));
			caracteristiques.add(new Caracteristique("agilité", 40));
			caracteristiques.add(new Caracteristique("magie", 80));
		}
		
		return caracteristiques;
	}
}
