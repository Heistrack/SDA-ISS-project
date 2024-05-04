package pl.sda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class DataBaseConnection {


    public SpacePeople addSpacePeopleToDB(Properties properties) {

        final SpacePeople spacePeople = new SpacePeople();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("iss_station", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(spacePeople);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            entityManagerFactory.close();
        }

        return spacePeople;


    }


}
