package fstt.org.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "histocarb")
public class HistoCarb implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true )
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date date;
	
	@Column(nullable = true )
	private double prix;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carburant_id")
	private Carburant carburant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "station_id")
	private Station station;

	public HistoCarb(Integer id, Date date, double prix) {
		super();
		this.id = id;
		this.date = date;
		this.prix = prix;
	}

	public HistoCarb(Date date, double prix) {
		super();
		this.date = date;
		this.prix = prix;
	}

	public HistoCarb() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Carburant getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "HistoCarb [id=" + id + ", date=" + date + ", prix=" + prix + "]";
	}
}
