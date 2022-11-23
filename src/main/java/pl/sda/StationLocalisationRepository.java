package pl.sda;

import javax.persistence.*;
import java.util.List;

public class StationLocalisationRepository {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("iss_station");



    public  void addStationLocalisationToDB(StationLocalisation stationLocalisation){

        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(stationLocalisation);

        transaction.commit();
        em.close();

    }


    public StationLocalisation loadStationLocalisation(){

            EntityManager em = factory.createEntityManager();
            try {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                TypedQuery<StationLocalisation> query = em.createQuery("""
             FROM StationLocalisation
            """, StationLocalisation.class);

                StationLocalisation stationLocalisation = query.getSingleResult();
                transaction.commit();
                return stationLocalisation;

            } finally {
                em.close();
            }
        }
    }


