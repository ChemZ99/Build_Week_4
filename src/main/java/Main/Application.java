package Main;

import Main.DAO.*;
import Main.Entities.*;
import Main.Enum.Stato_Distributore;
import Main.Enum.Stato_Veicolo;
import Main.Enum.Tipo_Veicolo;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class Application {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BUILD_WEEK_4");

    public static void main(String[] args) {


    }
}
