<<<<<<<< HEAD:src/main/java/Entities/Enum/Stato_Distributore.java
package Entities.Enum;
========
package Main.Enum;
>>>>>>>> develop:src/main/java/Main/Enum/Stato_Distributore.java

import java.util.Random;

public enum Stato_Distributore {
    ATTIVO,
   FUORI_SERVIZIO;
    private static final Random rndm = new Random();

    public static Stato_Distributore randomPeriodic() {

        Stato_Distributore[] stato = values();
        return stato[rndm.nextInt(stato.length)];

    }
}
