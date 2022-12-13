package fstt.org.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fstt.org.entities.HistoCarb;

public class HistoCarbRepository {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
	private static EntityManager entityManager = emf.createEntityManager();
	private static EntityTransaction transactionObj = entityManager.getTransaction();
	
    public List<HistoCarb> findAll() {
    	List<HistoCarb> list = new ArrayList<HistoCarb>();
		list = entityManager.createQuery("select i from HistoCarb i", HistoCarb.class).getResultList();
		return list;
    }
    public HistoCarb findCategoryById(Long id) throws IOException {
    	HistoCarb histoCarb = entityManager.find(HistoCarb.class, id);
        if (histoCarb == null) {
            throw new IOException();
        }
        return histoCarb;
    }
    
    public void updateCategory(Long id, HistoCarb histoCarb) throws IOException {
    	HistoCarb histoCarbToUpdate = findCategoryById(id);
    	
    	histoCarbToUpdate.setDate(histoCarb.getDate());
    	histoCarbToUpdate.setPrix(histoCarb.getPrix());
    	histoCarbToUpdate.setStation(histoCarb.getStation());
    	histoCarbToUpdate.setCarburant(histoCarb.getCarburant());
    }
    
    public void createCategory(HistoCarb histoCarb) {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
        entityManager.persist(histoCarb);
        transactionObj.commit();
    }
    
    public void deleteCategory(Long histoCarbId) throws IOException {
    	if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
    	entityManager.createNativeQuery("delete from HistoCarb where id = ?")
        .setParameter(1, histoCarbId)
        .executeUpdate();
    }
}
