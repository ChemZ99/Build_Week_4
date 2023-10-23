package Entities.Enum;

import java.util.Random;

public enum Stato_Biglietto {
    VITIMATO,
    UTILIZZABILE;
    private static final Random rndm = new Random();

    public static Stato_Biglietto randomPeriodic() {

        Stato_Biglietto[] stato = values();
        return stato[rndm.nextInt(stato.length)];

    }
}
