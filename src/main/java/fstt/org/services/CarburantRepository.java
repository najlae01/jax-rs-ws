package fstt.org.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import fstt.org.entities.Carburant;

public class CarburantRepository {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
	private static EntityManager entityManager = emf.createEntityManager();
	private static EntityTransaction transactionObj = entityManager.getTransaction();
	
    public List<Carburant> findAll() {
    	List<Carburant> list = new ArrayList<Carburant>();
		list = entityManager.createQuery("select i from Carburant i", Carburant.class).getResultList();
		return list;
    }
    public Carburant findCategoryById(Long id) throws IOException {
    	Carburant carburant = entityManager.find(Carburant.class, id);
        if (carburant == null) {
            throw new IOException();
        }
        return carburant;
    }
    
    public void updateCategory(Long id, Carburant carburant) throws IOException {
    	Carburant carburantToUpdate = findCategoryById(id);
    	
    	carburantToUpdate.setNom(carburant.getNom());
    	carburantToUpdate.setDescription(carburant.getDescription());
    	carburantToUpdate.setCarbStations(carburant.getCarbStations());
    }
    
    public void createCategory(Carburant carburant) {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
        entityManager.persist(carburant);
        transactionObj.commit();
    }
    
    public void deleteCategory(Long carburantId) throws IOException {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
    	entityManager.createNativeQuery("delete from Carburant where id = ?")
        .setParameter(1, carburantId)
        .executeUpdate();
    }
}
