package pl.sda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SpacePeopleRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("iss_station");
    private static EntityManager em = factory.createEntityManager();

    public void addSpacePeopleToDB(String name, String craft){

        SpacePeople spacePeople = new SpacePeople();
        spacePeople.setName(name);
        spacePeople.setCraft(craft);

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(spacePeople);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
        }
        finally {
            em.close();
        }

    }


}
