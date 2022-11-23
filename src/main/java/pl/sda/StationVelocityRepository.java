package pl.sda;

import javax.persistence.*;
import java.util.List;

public class StationVelocityRepository {


    EntityManagerFactory factory = Persistence.createEntityManagerFactory("iss_station");

    public void sendStationVelocityToDB(StationVelocity stationVelocity){

        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.createQuery("DELETE FROM StationVelocity e").executeUpdate();


        em.persist(stationVelocity);

        transaction.commit();
        em.close();



    }



    public StationVelocity loadStationVelocity(){


        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            TypedQuery<StationVelocity> query = em.createQuery("""
             FROM StationVelocity
            """, StationVelocity.class);

            StationVelocity stationVelocity = query.getSingleResult();

            transaction.commit();

            return stationVelocity;

        } finally {
            em.close();
        }


    }


}
