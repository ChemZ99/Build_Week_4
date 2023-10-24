package Main.Enum;


import java.util.Random;

public enum Stato_Veicolo {
    SERVIZIO,
    MANUTENZIONE;
    private static final Random rndm = new Random();

    public static Stato_Veicolo randomStatoVeicolo() {

        Stato_Veicolo[] stato = values();
        return stato[rndm.nextInt(stato.length)];

    }
}
