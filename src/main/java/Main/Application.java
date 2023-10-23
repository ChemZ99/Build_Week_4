package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BUILD_WEEK_4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        System.out.println("Hello World!");
    }
}
