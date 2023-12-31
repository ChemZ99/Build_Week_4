package Main;

import Main.DAO.*;
import Main.Enum.Tipo_Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BUILD_WEEK_4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EmissioneDAO emissioneDAO = new EmissioneDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        VeicoloDAO veicoloDAO = new VeicoloDAO(em);
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
        BigliettoDAO bigliettoDAO = new BigliettoDAO(em);
        ManutenzioneDAO manutenzioneDAO = new ManutenzioneDAO(em);
        ServizioDAO servizioDAO = new ServizioDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        //***************************************************SCANNER MENU***************************************************
        Scanner input = new Scanner(System.in);
        int mainCounter = 99;
        int printCounter = 99;
        int modifyCounter = 99;
        int deleteCounter = 99;

        while (mainCounter != 0) {
            try {
                System.out.println("************************************SISTEMA GESTIONE AUTOTRASPORTI************************************");
                System.out.println("Scrivi 1 per le funzioni di lettura, 2 per le funzioni di modifica, 3 per le funzioni di eliminazione");
                System.out.println("Scrivi 0 per terminare");
                try {
                    mainCounter = Integer.parseInt(input.nextLine());
                    switch (mainCounter) {
                        case 1: {
                            while (printCounter != 0) {
                                System.out.println("************************************FUNZIONI DI LETTURA************************************");
                                System.out.println("Scrivi 1 per ricevere una lista di utenti, 2 per ricevere una lista di veicoli, 3 per ricevere una lista di rivenditori");
                                System.out.println("Scrivi 4 per ottenere il numero dei biglietti e degli abbonamenti venduti in un certo lasso di tempo");
                                System.out.println("Scrivi 5 per ottenere il numero dei biglietti e gli abbonamenti venduti da uno specifico rivenditore");
                                System.out.println("Scrivi 6 per verificare la validita' dell' abbonamento di un utente attraverso il codice della tessera");
                                System.out.println("Scrivi 7 per ottenere il numero di biglietti vidimati in un certo lasso di tempo");
                                System.out.println("Scrivi 8 per ottenere il numero di biglietti vidimati su uno specifico veicolo");
                                System.out.println("Scrivi 9 per ottenere la tratta e il tempo effettivo impiegato per svolgerla di uno specifico veicolo");
                                System.out.println("Scrivi 0 per tornare al menu principale");
                                printCounter = Integer.parseInt(input.nextLine());
                                switch (printCounter) {
                                    case 1: {
                                        System.out.println();
                                        System.out.println("************************************LISTA DI UTENTI************************************");
                                        utenteDAO.getAllUsers().forEach(System.out::println);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println();
                                        System.out.println("************************************LISTA DI VEICOLI************************************");
                                        veicoloDAO.getAllVeicoli().forEach(System.out::println);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println();
                                        System.out.println("************************************LISTA DI RIVENDITORI************************************");
                                        emissioneDAO.getAllRivenditori().forEach(System.out::println);
                                        break;
                                    }
                                    case 4: {
                                        LocalDate startDate;
                                        LocalDate endDate;

                                        while (true) {
                                            System.out.println("Inserisci la data d'inizio (AAAA-MM-GG): ");
                                            String startDateStr = input.nextLine();

                                            try {
                                                startDate = LocalDate.parse(startDateStr);
                                                break;
                                            } catch (Exception e) {
                                                System.err.println("Data non valida. Riprova.");
                                            }
                                        }
                                        while (true) {
                                            System.out.println("Inserisci la data di fine (AAAA-MM-GG): ");
                                            String endDateStr = input.nextLine();

                                            try {
                                                endDate = LocalDate.parse(endDateStr);
                                                if (endDate.isBefore(startDate)) {
                                                    System.err.println("La data di fine deve essere uguale o successiva alla data d'inizio. Riprova.");
                                                } else if (endDate.isAfter(LocalDate.now())) {
                                                    System.err.println("La data di fine non puó essere nel futuro. Riprova.");
                                                } else {
                                                    System.out.println();
                                                    System.out.println("****************************BIGLIETTI TOTALI IN UN LASSO DI TEMPO****************************");
                                                    bigliettoDAO.getNumTicketsByPeriod(startDate, endDate);
                                                    break;
                                                }
                                            } catch (Exception e) {
                                                System.err.println("Data non valida. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 5: {
                                        UUID idRivenditore;
                                        while (true) {
                                            System.out.println("Inserisci l'id di un rivenditore.");
                                            String idRiv = input.nextLine();

                                            try {
                                                if (idRiv.length() == 36) {

                                                    idRivenditore = UUID.fromString(idRiv);
                                                    System.out.println();
                                                    System.out.println("*****************************BIGLIETTI E ABBONAMENTI TOTALI PER RIVENDITORE******************************");
                                                    long numBigliettiRiv = bigliettoDAO.getNumTicketsByPV(idRivenditore);
                                                    long numAbbRi = abbonamentoDAO.getNumAbbByPV(idRivenditore);
                                                    long tot = numAbbRi + numBigliettiRiv;
                                                    System.out.println("Il numero di biglietti e abbonamenti totali venduti da questo rivenditore é: " + tot);
                                                    break;
                                                } else {
                                                    System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                                }

                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 6: {
                                        UUID idTessera;
                                        while (true) {
                                            System.out.println("Inserisci l'id di una tessera.");
                                            String idTes = input.nextLine();

                                            try {
                                                if (idTes.length() == 36) {

                                                    idTessera = UUID.fromString(idTes);
                                                    System.out.println();
                                                    System.out.println("*****************************VERIFICA VALIDITA' ABBONAMENTO******************************");
                                                    abbonamentoDAO.isSubsciptionValid(idTessera);
                                                    System.out.println();
                                                    break;
                                                } else {
                                                    System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                                }

                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 7: {
                                        LocalDate startDate;
                                        LocalDate endDate;

                                        while (true) {
                                            System.out.println("Inserisci la data d'inizio (AAAA-MM-GG): ");
                                            String startDateStr = input.nextLine();

                                            try {
                                                startDate = LocalDate.parse(startDateStr);
                                                break;
                                            } catch (Exception e) {
                                                System.err.println("Data non valida. Riprova.");
                                            }
                                        }
                                        while (true) {
                                            System.out.println("Inserisci la data di fine (AAAA-MM-GG): ");
                                            String endDateStr = input.nextLine();

                                            try {
                                                endDate = LocalDate.parse(endDateStr);
                                                if (endDate.isBefore(startDate)) {
                                                    System.err.println("La data di fine deve essere uguale o successiva alla data d'inizio. Riprova.");
                                                } else if (endDate.isAfter(LocalDate.now())) {
                                                    System.err.println("La data di fine non puó essere nel futuro. Riprova.");
                                                } else {
                                                    System.out.println();
                                                    System.out.println("*************************BIGLIETTI VIDIMATI IN UN LASSO DI TEMPO**************************");
                                                    bigliettoDAO.getNumTicketsVitimatiByPeriod(startDate, endDate);
                                                    break;
                                                }
                                            } catch (Exception e) {
                                                System.err.println("Data non valida. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 8: {
                                        UUID idVeicolo;
                                        while (true) {
                                            System.out.println("Inserisci l'id di un veicolo.");
                                            String idV = input.nextLine();

                                            try {
                                                if (idV.length() == 36) {

                                                    idVeicolo = UUID.fromString(idV);
                                                    System.out.println();
                                                    System.out.println("*************************BIGLIETTI VIDIMATI IN UN CERTO VEICOLO**************************");
                                                    bigliettoDAO.getNumTicketsVitimatiByVeicolo(idVeicolo);
                                                    System.out.println();
                                                    break;
                                                } else {
                                                    System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                                }

                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 9: {
                                        UUID idServizio;
                                        while (true) {
                                            System.out.println("Inserisci l'id di un servizio.");
                                            String idServ = input.nextLine();

                                            try {
                                                if (idServ.length() == 36) {

                                                    idServizio = UUID.fromString(idServ);
                                                    System.out.println();
                                                    System.out.println("*************************TRATTA E TEMPO EFFETTIVO DEL VEICOLO**************************");
                                                    servizioDAO.servizioDetails(idServizio);
                                                    System.out.println();
                                                    break;
                                                } else {
                                                    System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                                }

                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 0: {
                                        break;
                                    }
                                    default: {
                                        System.err.println("Inserisci un numero compreso tra 0 e 9");
                                        break;
                                    }
                                }

                            }
                            break;
                        }
                        case 2: {
                            while (modifyCounter != 0) {
                                System.out.println("************************************FUNZIONI DI MODIFICA************************************");
                                System.out.println("Scrivi 1 per vidimare un biglietto");
                                System.out.println("Scrivi 2 per cambiare stato di un distributore");
                                System.out.println("Scrivi 3 per cambiare stato di un veicolo");
                                System.out.println("Scrivi 4 per rinnovare un abbonamento scaduto");
                                System.out.println("Scrivi 0 per tornare al menu principale");
                                modifyCounter = Integer.parseInt(input.nextLine());
                                switch (modifyCounter) {
                                    case 1: {
                                        System.out.println("*************************VIDIMAZIONE BIGLIETTO**************************");
                                        while (true) {
                                            System.out.println("inserisci l' UUID del biglietto");
                                            String b = input.nextLine();
                                            if (b.length() != 36) {
                                                System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                            }
                                            System.out.println("inserisci l' UUID del veicolo");
                                            String v = input.nextLine();
                                            if (v.length() != 36) {
                                                System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                            }
                                            try {
                                                UUID veicoloId = UUID.fromString(v);
                                                UUID bigliettoId = UUID.fromString(b);
                                                Application.checkTicket(bigliettoId, veicoloId);
                                                break;
                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("*************************CAMBIARE STATO DISTRIBUTORE**************************");
                                        while (true) {
                                            System.out.println("inserisci l' UUID del distributore");
                                            String target = input.nextLine();
                                            try {
                                                if (target.length() == 36) {
                                                    UUID targetId = UUID.fromString(target);
                                                    emissioneDAO.changeDistributoreStatus(targetId);
                                                    break;
                                                } else {
                                                    System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                                }

                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("*************************CAMBIARE STATO VEICOLO**************************");
                                        while (true) {
                                            System.out.println("Inserisci l' UUID del veicolo.");
                                            String target = input.nextLine();
                                            try {
                                                if (target.length() == 36) {
                                                    UUID targetId = UUID.fromString(target);
                                                    Application.changeVeicoloStatus(targetId);
                                                    break;
                                                } else {
                                                    System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                                }

                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("*************************RINNOVARE ABBONAMENTO**************************");
                                        while (true) {
                                            System.out.println("Inserisci l' UUID della tessera.");
                                            String t = input.nextLine();
                                            if (t.length() != 36) {
                                                System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                            }
                                            System.out.println("Inserisci l' UUID del rivenditore.");
                                            String r = input.nextLine();
                                            if (r.length() != 36) {
                                                System.err.println("La stringa deve avere esattamente 36 caratteri. Riprova.");
                                            }
                                            System.out.println("Scrivi S per fare un abbonamento settimanale o M per un abbonamento mensile");
                                            String a = input.nextLine();
                                            Tipo_Abbonamento tipoAbbonamento;
                                            if (a.equalsIgnoreCase("S")) {
                                                tipoAbbonamento = Tipo_Abbonamento.SETTIMANALE;
                                            } else if (a.equalsIgnoreCase("M")) {
                                                tipoAbbonamento = Tipo_Abbonamento.MENSILE;
                                            } else {
                                                System.err.println("Input non valido. Inserisci S o M");
                                                continue;
                                            }
                                            try {
                                                UUID id_tes = UUID.fromString(t);
                                                UUID id_riv = UUID.fromString(r);
                                                abbonamentoDAO.renewAbbonamento(id_tes, id_riv, tipoAbbonamento);
                                                break;
                                            } catch (Exception e) {
                                                System.err.println("UUID non valido. Riprova.");
                                            }
                                        }
                                    }
                                    case 0: {
                                        break;
                                    }
                                    default: {
                                        System.err.println("Inserisci un numero compreso tra 0 e 4");
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                        case 3: {
                            while (deleteCounter != 0) {
                                System.out.println("************************************FUNZIONI DI ELIMINAZIONE************************************");
                                System.out.println("Scrivi 1 per eliminare un utente, 2 per eliminare una tessera, 3 per eliminare un abbonamento");
                                System.out.println("Scrivi 4 per eliminare un punto vendita, 5 per eliminare un biglietto, 6 per eliminare un veicolo");
                                System.out.println("Scrivi 7 per eliminare un servizio, 8 per eliminare una manutenzione, 9 per eliminare una tratta");
                                System.out.println("Scrivi 0 per tornare al menu principale");
                                deleteCounter = Integer.parseInt(input.nextLine());
                                switch (deleteCounter) {
                                    case 1: {
                                        System.out.println("*************************ELIMINAZIONE UTENTE **************************");
                                        System.out.println("inserisci l' UUID dell' utente");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        utenteDAO.delete(targetId);

                                        break;
                                    }
                                    case 2: {
                                        System.out.println("*************************ELIMINAZIONE TESSERA**************************");
                                        System.out.println("inserisci l' UUID della tessera");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        tesseraDAO.delete(targetId);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("*************************ELIMINAZIONE ABBONAMENTO**************************");
                                        System.out.println("inserisci l' UUID dell' abbonamento");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        abbonamentoDAO.delete(targetId);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("*************************ELIMINAZIONE PUNTO VENDITA**************************");
                                        System.out.println("inserisci l' UUID del punto vendita");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        emissioneDAO.delete(targetId);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("*************************ELIMINAZIONE BIGLIETTO**************************");
                                        System.out.println("inserisci l' UUID del biglietto");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        bigliettoDAO.delete(targetId);
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("*************************ELIMINAZIONE VEICOLO**************************");
                                        System.out.println("inserisci l' UUID del veicolo");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        veicoloDAO.delete(targetId);
                                        break;
                                    }
                                    case 7: {
                                        System.out.println("*************************ELIMINAZIONE SERVIZIO**************************");
                                        System.out.println("inserisci l' UUID del servizio");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        servizioDAO.delete(targetId);
                                        break;
                                    }
                                    case 8: {
                                        System.out.println("*************************ELIMINAZIONE MANUTENZIONE**************************");
                                        System.out.println("inserisci l' UUID della manutenzione");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        manutenzioneDAO.delete(targetId);
                                        break;
                                    }
                                    case 9: {
                                        System.out.println("*************************ELIMINAZIONE TRATTA**************************");
                                        System.out.println("inserisci l' UUID della tratta");
                                        String target = input.nextLine();
                                        UUID targetId = UUID.fromString(target);
                                        trattaDAO.delete(targetId);
                                        break;
                                    }
                                    case 0: {
                                        break;
                                    }
                                    default: {
                                        System.err.println("Inserisci un numero compreso tra 0 e 9");
                                        break;
                                    }
                                }
                            }
                        }
                        case 0: {
                            break;
                        }
                        default: {
                            System.err.println("Inserisci un numero compreso tra 0 e 3");
                            break;
                        }

                    }
                } catch (NumberFormatException n) {
                    System.err.println("Inserisci un numero.");
                } catch (Exception e) {
                    System.err.println(e);
                }

            } catch (Exception ex) {
                System.err.println("Exception" + ex.getMessage());
            }
        }
    }
}