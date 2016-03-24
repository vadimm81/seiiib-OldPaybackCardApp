package edu.hm.cs.ob;

public class PaybackCardApp {
    public static void main(String[] args) {
        final PaybackCard card = new PaybackCard();
        final java.util.Scanner in = new java.util.Scanner(System.in);
        boolean stop = false;
        while (!stop) {
            String input = "";
            System.out.print("> ");
            input = in.nextLine();
            switch (input) {
                case "help":
                case "h":
                case "?":
                    System.out.println(
                            "h / help / ?     --- gibt diese Info aus\n"
                                    + "n / name         --- setze Namen\n"
                                    + "k / kundennummer --- setze Kundennummer\n"
                                    + "b / bonuspunkte  --- addiere Bonuspunkte\n"
                                    + "p / premiumkunde --- setze Premium-Status\n"
                                    + "d / drucke       --- gebe Karteninfo aus\n"
                                    + "j / json         --- gebe Karteinfo als JSON aus");
                    break;
                case "name":
                case "n":
                    System.out.print("Geben Sie den Namen ein: ");
                    String name = in.nextLine();
                    card.name = name;
                    break;
                case "k":
                case "kundennummer":
                    System.out.print("Geben Sie die Kundennummer ein: ");
                    int id = Integer.parseInt(in.nextLine());
                    card.customerID = id;
                    break;
                case "bonuspunkte":
                case "b":
                    System.out.print("Geben Sie die Bonuspunkte ein: ");
                    int bonusPoints = Integer.parseInt(in.nextLine());
                    card.bonusPoints += bonusPoints;
                    System.out.printf("Neuer Stand: %d Punkte.%n", card.bonusPoints);
                    break;
                case "premiumkunde":
                case "p":
                    System.out.print("Ist der Kunde Premiumkunde? (j/n)");
                    String isPremium = in.nextLine();
                    switch (isPremium) {
                        case "j":
                        case "J":
                            card.premiumCustomer = true;
                            break;
                        default:
                            card.premiumCustomer = false;
                    }
                    break;
                case "drucke":
                case "d":
                    card.print();
                    break;
                case "json":
                case "j":
                    card.printToJson();
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

