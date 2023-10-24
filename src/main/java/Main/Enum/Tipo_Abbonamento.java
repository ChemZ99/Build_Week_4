package Main.Enum;


import java.util.Random;

public enum Tipo_Abbonamento {
    SETTIMANALE,
    MENSILE;
    private static final Random rndm = new Random();

    public static Tipo_Abbonamento randomTipoAbbonamento() {

        Tipo_Abbonamento[] tipo = values();
        return tipo[rndm.nextInt(tipo.length)];

    }
}
