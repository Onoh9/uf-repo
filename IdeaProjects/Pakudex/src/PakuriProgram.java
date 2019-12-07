import java.util.Scanner;
public class PakuriProgram {
    public static Integer fullDex;
    public static Scanner scnr;
        public static void main(String[] args) {
            Scanner scnr = new Scanner(System.in);
            int menuOption;
            System.out.println("Welcome to Pakudex: Tracker Extraordinaire!"); // prints welcome message once
            while (true) {
                System.out.print("Enter max capacity of the Pakudex: ");
                try {
                    Object object1 = scnr.next();
                    fullDex = Integer.parseInt(object1.toString());
                    if (fullDex < 0) {
                        System.out.println("Please enter a valid size.");
                        continue;
                    }
                    break;
                }
                catch (Exception e) {
                    System.out.println("Please enter a valid size.");
                }
            }
            System.out.println("The Pakudex can hold " + fullDex + " species of Pakuri.");
            Pakudex pakudex = new Pakudex();
            if (fullDex != null) {
                pakudex = new Pakudex(fullDex);
            } while (true) {
                menu();
                System.out.print("What would you like to do? ");
                try {
                    Object object2 = scnr.next();
                    menuOption = Integer.parseInt(object2.toString());
                }
                catch (Exception e) {
                    System.out.println("Unrecognized menu selection!");
                    continue;
                }
                switch (menuOption) {
                    case 1: //This should number and list the critters in the Pakudex in the order contained.
                        if (pakudex.getSpeciesArray() != null) {
                            System.out.println("Pakuri In Pakudex: ");
                            for (int i = 0; i < pakudex.getSpeciesArray().length; i++) {
                                System.out.println(i + 1 + ". " + pakudex.getSpeciesArray()[i]);
                            }
                        } else {
                            System.out.println("No Pakuri in Pakudex yet!");
                        }
                        break;
                    case 2: //The program should prompt for a species and collect species information, then display it:
                        System.out.print("Enter the name of the species to display: ");
                        Object object3 = scnr.next();
                        String pakuNameSpe = object3.toString();
                        int[] power = pakudex.getStats(pakuNameSpe);
                        if (power != null && power.length != 0) {
                            System.out.println("Species: " + pakuNameSpe);
                            System.out.println("Attack: " + power[0]);
                            System.out.println("Defense: " + power[1]);
                            System.out.println("Speed: " + power[2]);
                            break;
                        } else {
                            System.out.println("Error: No such Pakuri!");
                        }
                        break;
                    case 3: // When adding a Pakuri, a prompt should be displayed to read in the species name, and a confirmation displayed following successful addition (or failure).
                        if (pakudex.getSize() >= pakudex.getCapacity()) {
                            System.out.println("Error: Pakudex is full!");
                            break;
                        }
                        System.out.print("Enter the name of the species to add: ");
                        Object object4 = scnr.next();
                        String pakuNameSpe2 = object4.toString();
                        if (!pakudex.addPakuri(pakuNameSpe2)) {
                            System.out.println("Error: Pakudex already contains this species!");
                        } else {
                            pakudex.addPakuri(pakuNameSpe2);
                            System.out.println("Pakuri species " + pakuNameSpe2 + " successfully added!");
                        }
                        break;
                    case 4:  //The program should prompt for a species and then cause the species to evolve if it exists:
                        System.out.print("Enter the name of the species to evolve: ");
                        Object objects = scnr.next();
                        String evolve = objects.toString();
                        if (pakudex.evolveSpecies(evolve)) {
                            System.out.println(evolve + " has evolved!");
                        } else {
                            System.out.println("Error: No such Pakuri!");
                        }
                        break;
                    case 5: //Sort Pakuri in Java standard lexicographical order:
                        pakudex.sortPakuri();
                        System.out.println("Pakuri have been sorted!");
                        break;
                    case 6:
                        System.out.println("Thanks for using Pakudex! Bye!");
                        System.exit(1);
                        return;
                    default:
                        System.out.println("Unrecognized menu selection!");
                        break;
                }
            }
        }
    public static void menu() {
            System.out.println("Pakudex Main Menu \n----------------- \n1. List Pakuri \n2. Show Pakuri \n3. Add Pakuri \n4. Evolve Pakuri \n5. Sort Pakuri \n6. Exit \n");

        }

}
