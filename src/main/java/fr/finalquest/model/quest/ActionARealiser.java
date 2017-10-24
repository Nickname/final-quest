package fr.finalquest.model.quest;

import javax.persistence.*;

@Entity
@Table(name="action_quete")
public class ActionARealiser {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Id
	@Column(name="cible")
	private String cible;
	
	@Column(name="coordX")
	private int coordX;
	
	@Column(name="coordY")
	private int coordY;
	
	@ManyToOne
	@JoinColumn(name="quest_id")
	private Quete quete;
	
	public ActionARealiser() {	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCible() {
		return cible;
	}
	
	public void setCible(String cible) {
		this.cible = cible;
	}
	
	public int getCoordX() {
		return coordX;
	}
	
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	public int getCoordY() {
		return coordY;
	}
	
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	public Quete getQuete() {
		return quete;
	}
	
	public void setQuete(Quete quete) {
		this.quete = quete;
	}
}
