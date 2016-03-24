package edu.hm.cs.ob;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PaybackCardTest {
    @Test
    public void emptyPaybackCard() {
        PaybackCard p = new PaybackCard();
        assertNull(null, p.name);
        assertEquals(0, p.customerID);
        assertEquals(0, p.bonusPoints);
        assertFalse(p.premiumCustomer);
    }

    @Test
    public void printEmptyPaybackCard() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.print();
        assertEquals("Der Kundenname fehlt noch!\n",
                myOut.toString());
    }

    @Test
    public void printPaybackCardWithoutID() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.print();
        assertEquals("Die Kundennummer hat keinen gültigen Wert!\n",
                myOut.toString());
    }

    @Test
    public void printPaybackCardNoPointsNotPremium() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.customerID = 1234;
        p.print();
        assertEquals("Helge (Kundennummer: 1234), keine Punkte\n",
                myOut.toString());
    }

    @Test
    public void printPaybackCardPointsNotPremium() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.customerID = 1234;
        p.bonusPoints = 4321;
        p.print();
        assertEquals("Helge (Kundennummer: 1234), 4321 Punkte\n",
                myOut.toString());
    }

    @Test
    public void printPaybackCardPointsPremium() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.customerID = 1234;
        p.bonusPoints = 4321;
        p.premiumCustomer = true;
        p.print();
        assertEquals("Helge (Kundennummer: 1234), 4321 Punkte, Premiumkunde\n",
                myOut.toString());
    }

    @Test
    public void printJSONEmptyPaybackCard() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.printToJson();
        assertEquals("{\n"
                        + "    \"name\" : null,\n"
                        + "    \"customerID\" : 0,\n"
                        + "    \"bonusPoints\" : 0,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n",
                myOut.toString());
    }

    @Test
    public void printJSONPaybackCardWithoutID() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.printToJson();
        assertEquals("{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 0,\n"
                        + "    \"bonusPoints\" : 0,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n",
                myOut.toString());
    }

    @Test
    public void printJSONPaybackCardNoPointsNotPremium() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.customerID = 1234;
        p.printToJson();
        assertEquals("{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 1234,\n"
                        + "    \"bonusPoints\" : 0,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n",
                myOut.toString());
    }

    @Test
    public void printJSONPaybackCardPointsNotPremium() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.customerID = 1234;
        p.bonusPoints = 4321;
        p.printToJson();
        assertEquals("{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 1234,\n"
                        + "    \"bonusPoints\" : 4321,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n",
                myOut.toString());
    }

    @Test
    public void printJSONPaybackCardPointsPremium() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCard p = new PaybackCard();
        p.name = "Helge";
        p.customerID = 1234;
        p.bonusPoints = 4321;
        p.premiumCustomer = true;
        p.printToJson();
        assertEquals("{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 1234,\n"
                        + "    \"bonusPoints\" : 4321,\n"
                        + "    \"premiumCustomer\" : true\n"
                        + "}\n",
                myOut.toString());
    }

    @Test
    public void runAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("q\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Bye-bye!\n", myOut.toString());
    }

    @Test
    public void runPrintAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("d\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Der Kundenname fehlt noch!\n> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNamePrintAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("n\nHelge\nd\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Die Kundennummer hat keinen gültigen Wert!\n"
                        + "> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdPrintAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("n\nHelge\nk\n1234\nd\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: "
                        + "> Helge (Kundennummer: 1234), keine Punkte\n"
                        + "> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdSetPointsPrintAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("n\nHelge\nk\n1234\nb\n321\nd\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: "
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 321 Punkte.\n"
                        + "> Helge (Kundennummer: 1234), 321 Punkte\n"
                        + "> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdSetPointsTwicePrintAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream(
                        "n\nHelge\nk\n1234\nb\n321\nb\n321\nd\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: "
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 321 Punkte.\n"
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 642 Punkte.\n"
                        + "> Helge (Kundennummer: 1234), 642 Punkte\n"
                        + "> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdSetPointsTwiceSetPremiumjPrintAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream(
                        "n\nHelge\nk\n1234\nb\n321\nb\n321\np\nj\nd\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: "
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 321 Punkte.\n"
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 642 Punkte.\n"
                        + "> Ist der Kunde Premiumkunde? (j/n)"
                        + "> Helge (Kundennummer: 1234), 642 Punkte, Premiumkunde\n"
                        + "> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runPrintJsonAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("j\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> "
                        + "{\n"
                        + "    \"name\" : null,\n"
                        + "    \"customerID\" : 0,\n"
                        + "    \"bonusPoints\" : 0,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNamePrintJsonAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("n\nHelge\nj\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: > "
                        + "{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 0,\n"
                        + "    \"bonusPoints\" : 0,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdPrintJsonAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("n\nHelge\nk\n1234\nj\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: > "
                        + "{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 1234,\n"
                        + "    \"bonusPoints\" : 0,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdSetPointsPrintJsonAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream("n\nHelge\nk\n1234\nb\n321\nj\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: "
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 321 Punkte.\n> "
                        + "{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 1234,\n"
                        + "    \"bonusPoints\" : 321,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdSetPointsTwicePrintJsonAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream(
                        "n\nHelge\nk\n1234\nb\n321\nb\n321\nj\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: "
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 321 Punkte.\n"
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 642 Punkte.\n> "
                        + "{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 1234,\n"
                        + "    \"bonusPoints\" : 642,\n"
                        + "    \"premiumCustomer\" : false\n"
                        + "}\n> Bye-bye!\n",
                myOut.toString());
    }

    @Test
    public void runSetNameSetIdSetPointsTwiceSetPremiumjPrintJsonAndQuitApp() {
        final ByteArrayInputStream in =
                new ByteArrayInputStream(
                        "n\nHelge\nk\n1234\nb\n321\nb\n321\np\nj\nj\nq\n".getBytes());
        System.setIn(in);
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PaybackCardApp.main(null);
        assertEquals("> Geben Sie den Namen ein: "
                        + "> Geben Sie die Kundennummer ein: "
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 321 Punkte.\n"
                        + "> Geben Sie die Bonuspunkte ein: Neuer Stand: 642 Punkte.\n"
                        + "> Ist der Kunde Premiumkunde? (j/n)> "
                        + "{\n"
                        + "    \"name\" : \"Helge\",\n"
                        + "    \"customerID\" : 1234,\n"
                        + "    \"bonusPoints\" : 642,\n"
                        + "    \"premiumCustomer\" : true\n"
                        + "}\n> Bye-bye!\n",
                myOut.toString());
    }
}

