package Main.Enum;


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
