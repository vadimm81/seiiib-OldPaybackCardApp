package edu.hm.cs.ob;

import com.sun.org.apache.bcel.internal.generic.FieldGen;

import java.util.Scanner;

public class PaybackCardApp {


    private static  String helpText =
                      "h / help / ?     --- gibt diese Info aus\n"
                    + "w / wechsel      --- wechsele zur anderen Karte\n"
                    + "b / bonuspunkte  --- addiere Bonuspunkte\n"
                    + "p / premiumkunde --- setze Premium-Status\n"
                    + "m / merge        --- merge aktive Karte mit der anderen Karte\n"
                    + "d / drucke       --- gebe Karteninfo aus\n"
                    + "j / json         --- gebe Karteinfo als JSON aus\n";
    void karte1() {

    }



    public static void main(String[] args) {
        
        int nummer; // Kundennummer
        String name; // Name für die Karte


        System.out.printf("Initialisiere Karte 1 \n"
                + "Geben Sie den Namen ein: ");
        final java.util.Scanner newname1 = new java.util.Scanner(System.in);
        name = newname1.next();
        System.out.printf("Geben Sie die Kundennummer ein: ");
        final java.util.Scanner customerID1 = new java.util.Scanner(System.in);
        nummer = customerID1.nextInt();
        PaybackCard card1 = new PaybackCard(nummer, name);

        System.out.printf("Initialisiere Karte 2 \n"
                + "Geben Sie den Namen ein: ");
        final java.util.Scanner newname2 = new java.util.Scanner(System.in);
        name = newname2.next();
        System.out.printf("Geben Sie die Kundennummer ein: ");
        final java.util.Scanner customerID2 = new java.util.Scanner(System.in);
        nummer = customerID2.nextInt();
        PaybackCard card2 = new PaybackCard(nummer, name);
        PaybackCard active = new PaybackCard(card1.getCustomerID(), card1.getName());
        System.out.println("Karte 1 " + card1.getName() + " " + card1.getCustomerID() + " " + card1.getBonusPoints());

        System.out.println("Karte 2 " + card2.getName() + " " + card2.getCustomerID() + " " + card2.getBonusPoints());

        boolean stop = false;
        while (!stop) {
            System.out.print(helpText);
            final java.util.Scanner in = new java.util.Scanner(System.in);
            String input = "";
            System.out.print("> ");
            input = in.nextLine();
            switch (input) {
                case "help":
                case "h":
                case "?":
                    System.out.printf(helpText);
                    break;
                case "wechsel":
                case "w":
                    card1.setName(card2.getName());
                    card1.setPremiumCustomer(card2.isPremiumCustomer());
                    card1.setBonusPoints(card2.getBonusPoints());
                    card1.setCustomerID(card2.getCustomerID());

                    card2.setName(active.getName());
                    card2.setPremiumCustomer(active.isPremiumCustomer());
                    card2.setBonusPoints(active.getBonusPoints());
                    card2.setCustomerID(active.getCustomerID());

                    active.setName(card1.getName());
                    active.setPremiumCustomer(card1.isPremiumCustomer());
                    active.setBonusPoints(card1.getBonusPoints());
                    active.setCustomerID(card1.getCustomerID());

                    System.out.printf("Karte gewechselt.\n"
                            + "Aktive Karte: \n"
                            + "%s (Kundennummer: %d), ", active.getName(), active.getCustomerID());
                    if (active.getBonusPoints() > 0) {
                        System.out.printf("%d Punkte\n", active.getBonusPoints());
                    } else {
                        System.out.printf("Keine Punkte\n");
                    }
                    break;
                case "bonuspunkte":
                case "b":
                    System.out.print("Geben Sie die Bonuspunkte ein: ");
                    int bonusPoints = Integer.parseInt(in.nextLine());
                    active.addBonusPoints(bonusPoints);
                    System.out.printf("Neuer Stand: %d Punkte.%n", active.getBonusPoints());
                    break;
                case "premiumkunde":
                case "p":
                    System.out.print("Ist der Kunde Premiumkunde? (j/n)");
                    String isPremium = in.nextLine();
                    switch (isPremium) {
                        case "j":
                        case "J":
                            active.setPremiumCustomer(true);
                            System.out.println(active.isPremiumCustomer());
                            break;
                        default:
                            active.setPremiumCustomer(false);
                    }
                    break;
                case "m":
                case "merge":
                    active.addBonusPoints(card2.getBonusPoints());
                    if (card2.isPremiumCustomer() == true) {
                        active.setPremiumCustomer(true);
                    }
                case "drucke":
                case "d":
                    System.out.println(active.getName());
                    System.out.println(active.getCustomerID());
                    System.out.println(active.isPremiumCustomer());
                    System.out.println(active.getBonusPoints());
                    break;
                case "json":
                case "j":
                    active.printToJson();
                    break;
                case "quit":
                case "q":
                    stop = true;
                    break;
                default:
                    System.out.println("unknown command: " + input);
            }
        }
        System.out.println("Bye-bye!");
    }
}
