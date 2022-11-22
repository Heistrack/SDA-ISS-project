package pl.sda;

import javax.persistence.*;
import java.util.List;

public class SpacePeopleRepository {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("iss_station");
    EntityManager em = factory.createEntityManager();

    public void addSpacePeopleToDB(List<SpacePeople> people){

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(people);
            transaction.commit();
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
