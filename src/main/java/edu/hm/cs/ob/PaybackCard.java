package edu.hm.cs.ob;

public class PaybackCard {
    int customerID;
    String name;
    int bonusPoints;
    boolean premiumCustomer;

    void print() {
        if (name == null) {
            System.out.printf("Der Kundenname fehlt noch!%n");
        } else if (customerID == 0) {
            System.out.printf("Die Kundennummer hat keinen gültigen Wert!%n");
        } else {
            System.out.printf("%s (Kundennummer: %d), %s Punkte%s%n",
                    name,
                    customerID,
                    bonusPoints == 0 ? "keine" : bonusPoints,
                    premiumCustomer ? ", Premiumkunde" : "");
        }
    }

    void printToJson() {
        System.out.printf(
                "{%n"
                        + "    \"name\" : %s,%n"
                        + "    \"customerID\" : %d,%n"
                        + "    \"bonusPoints\" : %d,%n"
                        + "    \"premiumCustomer\" : %b%n"
                        + "}%n",
                (name == null) ? "null" : "\"" + name + "\"",
                customerID,
                bonusPoints,
                premiumCustomer);
    }
}


