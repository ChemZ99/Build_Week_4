package Main.Enum;

import java.util.Random;

public enum Tipo_Veicolo {
    TRAM,
    AUTOBUS;
    private static final Random rndm = new Random();

    public static Tipo_Veicolo randomTipoVeicolo() {

        Tipo_Veicolo[] stato = values();
        return stato[rndm.nextInt(stato.length)];

    }
}
