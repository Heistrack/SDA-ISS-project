package pl.sda;

import javax.persistence.*;
import java.util.List;

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


    public List<SpacePeople> loadSpacePeople(){
        try {
            TypedQuery<SpacePeople> query = em.createQuery("""
            SELECT spacepeople FROM spacepeople spacepeople
            """, SpacePeople.class);

            List<SpacePeople> spacePeople = query.getResultList();
            return spacePeople;

        } finally {
            em.close();
        }
    }





}
