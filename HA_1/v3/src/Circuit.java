// Florian Wuerdinger, 23341272
// Jiaxuan Fu, ol05otep, 23328403

import java.lang.Math;
import java.util.Scanner;


/*
public: ueberall zugreifbar
static: statisch, nicht dynamisch
void: keine rueckgabewert

 */



public class Circuit {

    // public Variabel (globale Variable definieren)

    //Plattenkondensatoren in m
    static double d1 = 0.003;
    static double d2 = 0.004;
    static double a1 = 0.00097;
    static double a2 = 0.00051;

    //Wiederstaende in Ohm
    static int resistor1 = 1000;
    static int resistor2 = 472;
    static final double EPSILON_0 = 8.854e-12;

    //Method (cap): Steckplatte mit Kondensatoren
    public static void cap(){
        //Steckplatte mit Kondensatoren
        final int er = 1;

        double capacity1 = (EPSILON_0 * er * a1) / d1;
        double capacity2 = (EPSILON_0 * er * a2) / d2;

        System.out.println("Capacity1: " + capacity1 + " Farad");
        System.out.println("Capacity2: " + capacity2 + " Farad");


        double totalCapacity = capacity1 + capacity2;
        System.out.println("The total capacity is: " + totalCapacity + " Farad");

    }

    //Method (res) : Steckplatte mit Widerstaenden
    public static void res() {
        //Steckplatte mit Widerstaenden
        double totalResistanceTemp = 1 / resistor1 + 1 / resistor2;
        double totalResistance = Math.round(1 / totalResistanceTemp);
        System.out.println("The total resistence is: " + totalResistance + " Ohm");
    }



    // short ist schlusselwort, darf man nicht als Variable Name definieren
    public static void short1(){
        //Steckplatte mit Kurzschluessen
        System.out.println("Board shorted - No modules installed! ");
    }





    //von hier faengt das Hauptteil an
    public static void main(String[] args) {

        //Vorwiderstand
        double protectiveResistor;
        double voltage = 5;


        //Vorwiederstand dynamisch festlegen
        System.out.println("Bitte geben Sie den Wert des Vorwiderstandes ein: ");

        Scanner scRes = new Scanner(System.in);
        protectiveResistor = scRes.nextDouble();

        //Falsche Benutzereingabe behandeln
        if (protectiveResistor <= 0) {
            System.err.println("Bitte geben Sie nur positive Werte ein!");

        } else {
            System.out.println("");
        }

        //Berechnung Stromstaerke und Leistung
        double current = voltage / protectiveResistor;
        double power = current * current * protectiveResistor;

        System.out.print("Current: " + current + " Ampere; ");
        System.out.println("Power: " + power + " Watt");

        //Steckplatte konfigurieren
        System.out.println("Bitte waehlen Sie zwischen 'Widerstaende', 'Kondensatoren' oder 'Kurzschluesse': ");

        Scanner scMod = new Scanner(System.in);
        String module = scMod.nextLine();

        switch (module){
            case "Kondensatoren":
                module = "cap";
                cap();
                break;
            case "Widerstaende":
                module = "res";
                res();
                break;
            case "Kurzschluesse":
                module = "short";
                short1(); //man darf in java "short" nicht als Methodname anlegen (wegen schluesselwort)
                break;
            default:
                System.err.print("Fehlerhafte Eingabe, Bitte waehlen Sie zwischen 'Widerstaende',");
                System.err.println(" 'Kondensatoren' oder 'Kurzschluesse': ");
        }

        scRes.close();
        scMod.close();

    }



}
