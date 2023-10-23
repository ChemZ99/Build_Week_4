<<<<<<<< HEAD:src/main/java/Entities/Enum/Tipo_Abbonamento.java
package Entities.Enum;
========
package Main.Enum;
>>>>>>>> develop:src/main/java/Main/Enum/Tipo_Abbonamento.java

import java.util.Random;

public enum Tipo_Abbonamento {
    SETTIMANALE,
    MENSILE;
    private static final Random rndm = new Random();

    public static Tipo_Abbonamento randomPeriodic() {

        Tipo_Abbonamento[] tipo= values();
        return tipo[rndm.nextInt(tipo.length)];

    }
}
