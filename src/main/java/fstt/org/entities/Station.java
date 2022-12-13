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
@Table(name = "station")
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "station_id", nullable = false, unique = true )
	private Long id;
	
	@Column(nullable = false, length =  255 )
	private String nom;
	
	@Column(nullable = false, length =  255 )
	private String ville;
	
	@Column(nullable = false, length =  255 )
	private String adresse;
	
	@OneToMany(mappedBy = "station")
	private List<HistoCarb> stationCarbs = new ArrayList<HistoCarb>();

	public Station(Long id, String nom, String ville, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
	}

	public Station(String nom, String ville, String adresse) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
	}

	public Station(Long id, String nom, String ville, String adresse, List<HistoCarb> stationCarbs) {
		super();
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
		this.stationCarbs = stationCarbs;
	}

	public Station(String nom, String ville, String adresse, List<HistoCarb> stationCarbs) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
		this.stationCarbs = stationCarbs;
	}

	public Station() {
		super();
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<HistoCarb> getStationCarbs() {
		return stationCarbs;
	}

	public void setStationCarbs(List<HistoCarb> stationCarbs) {
		this.stationCarbs = stationCarbs;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", nom=" + nom + ", ville=" + ville + ", adresse=" + adresse + "]";
	}

}
