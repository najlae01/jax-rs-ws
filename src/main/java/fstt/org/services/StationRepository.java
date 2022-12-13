package fstt.org.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import fstt.org.entities.Station;

public class StationRepository {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
	private static EntityManager entityManager = emf.createEntityManager();
	private static EntityTransaction transactionObj = entityManager.getTransaction();
	
    public List<Station> findAll() {
    	List<Station> list = new ArrayList<Station>();
		list = entityManager.createQuery("select i from Station i", Station.class).getResultList();
		return list;
    }
    public Station findStationById(Long id) throws IOException {
    	Station station = entityManager.find(Station.class, id);
        if (station == null) {
            throw new IOException();
        }
        return station;
    }
    
    public void updateStation(Long id, Station station) throws IOException {
    	Station stationToUpdate = findStationById(id);
    	
    	stationToUpdate.setNom(station.getNom());
    	stationToUpdate.setAdresse(station.getAdresse());
    	stationToUpdate.setVille(station.getVille());
    	stationToUpdate.setStationCarbs(station.getStationCarbs());
    }
    
    public void createStation(Station station) {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
        entityManager.persist(station);
        transactionObj.commit();
    }
    
    public void deleteStation(Long stationId) throws IOException {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
    	entityManager.createNativeQuery("delete from Station where id = ?")
        .setParameter(1, stationId)
        .executeUpdate();
    }
}
