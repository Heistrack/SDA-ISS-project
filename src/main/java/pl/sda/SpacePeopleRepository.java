package pl.sda;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

public class SpacePeopleRepository {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("iss_station");





    public void addSpacePeopleToDB(List<SpacePeople> spacePeople){


        EntityManager em = factory.createEntityManager();


        List<SpacePeople> entities = spacePeople;

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.createQuery("DELETE FROM SpacePeople e").executeUpdate();
        entities.forEach(em::persist);
        transaction.commit();
        em.close();
    }




    public List<SpacePeople> loadSpacePeople(){
        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            TypedQuery<SpacePeople> query = em.createQuery("""
             FROM SpacePeople
            """, SpacePeople.class);

            List<SpacePeople> spacePeople = query.getResultList();
            transaction.commit();
            return spacePeople;

        } finally {
            em.close();
        }
    }





}
