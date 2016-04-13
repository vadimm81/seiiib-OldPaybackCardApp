package edu.hm.cs.ob;

public class PaybackCard {
    // Objektvariablen
    private int cardNumber = 1;
    private int customerID;
    private String name;
    private int bonusPoints;
    private boolean premiumCustomer;
    // Konstruktor

   public PaybackCard() {


       System.out.printf("Initialisiere Karte %d \n"
               + "Geben Sie den Namen ein: ", getCardNumber());
       final java.util.Scanner name = new java.util.Scanner(System.in);
       this.name = name.next();
       System.out.printf("\nGeben Sie die Kundennummer ein: ");
       final java.util.Scanner customerID = new java.util.Scanner(System.in);

       this.customerID = customerID.nextInt();
        bonusPoints = 0;
        premiumCustomer = false;
        cardNumber++;

    }

    public PaybackCard(final int customerID, final String name) {
        this.customerID = customerID;
        this.name = name;
        bonusPoints = 0;
        premiumCustomer = false;
    }

    // Getter
    public int getCardNumber() {
        return cardNumber;
    }
    public  int getCustomerID() {
        return customerID;
    }
    public String getName() {
        return name;
    }
    public int getBonusPoints() {
        return bonusPoints;
    }
    public boolean isPremiumCustomer() {
        return premiumCustomer;
    }
    // Setter

    public void setName(final String name) {
        this.name = name;
    }
    public void setCustomerID(final int customerID) {
        this.customerID = customerID;
    }

    public void addBonusPoints(final int bonusPoints) {
        if (bonusPoints > 0) {
            this.bonusPoints = this.bonusPoints + bonusPoints;
        } else {}
    }

    public void setBonusPoints(final int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
    public void setPremiumCustomer(final boolean premiumCustomer) {
            this.premiumCustomer = premiumCustomer;
    }
    // Merge
    public void merge(final int customerID) {

        if (this.customerID == customerID) {
        } else {
            this.bonusPoints = this.bonusPoints + bonusPoints;
        }
    }



    // String- bzw. JSON-Repräsentation
    //@Override public String toString();

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


