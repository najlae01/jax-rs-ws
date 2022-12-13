package fstt.org.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carburant")
public class Carburant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carburant_id", nullable = false, unique = true )
	private Long id;
	
	@Column(nullable = false, length =  255 )
	private String nom;
	
	@Column(nullable = false, length =  255 )
	private String description;
	
	@OneToMany(mappedBy = "carburant")
	private List<HistoCarb> carbStations = new ArrayList<HistoCarb>();

	public Carburant() {
		super();
	}

	public Carburant(Long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public Carburant(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Carburant(Long id, String nom, String description, List<HistoCarb> carbStations) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.carbStations = carbStations;
	}

	public Carburant(String nom, String description, List<HistoCarb> carbStations) {
		super();
		this.nom = nom;
		this.description = description;
		this.carbStations = carbStations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<HistoCarb> getCarbStations() {
		return carbStations;
	}

	public void setCarbStations(List<HistoCarb> carbStations) {
		this.carbStations = carbStations;
	}

	@Override
	public String toString() {
		return "Carburant [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}
	
}
