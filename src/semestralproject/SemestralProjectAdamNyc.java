package semestralproject;

/**
 * Semestralni prace: uloha 18 - nacteni matice od uzivatele, usporadani prvnich
 * prvku kazdeho radku matice tak, aby tvorily neklesajici posloupnost
 *
 * Vanocni uloha: nakresleni vanocniho prani podle hodnot zadanych uzivatelem
 * (barva svicky a pocet dni do vanoc), prani se meni podle hodnot na vstupu
 *
 * @author Adam Nýč
 * @version 0.1 14/12/22
 */
import java.util.Scanner;

public class SemestralProjectAdamNyc {

    static Scanner sc = new Scanner(System.in);

    //main metoda
    public static void main(String[] args) {
        int volba;
        boolean end = false;

        //uvod a zadani volby
        System.out.println("VITEJTE!");
        do {
            System.out.println("");
            displayMenu();
            volba = sc.nextInt();
            switch (volba) {
                case 1:
                    System.out.println("");
                    seminarniPrace();
                    break;
                case 2:
                    System.out.println("");
                    vanocniUloha();
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("");
                    System.out.println("Neplatna volba.");
            }
        } while (!end);
    }

    //metoda pro vypis menu
    private static void displayMenu() {
        System.out.println("Zadejte volbu:");
        System.out.println("1. - Seminarni prace");
        System.out.println("2. - Vanocni uloha");
        System.out.println("0. - Konec");
    }

    //metoda - SEMESTRALNI PRACE 
    private static void seminarniPrace() {

        int rowNumber;
        int columnNumber;
        double[][] matrix;

        System.out.println("Zadejte rozmery matice.\n"
                + "Pokud budete chtit program ukoncit, misto poctu "
                + "radku zadejte nekladne cislo.");
        System.out.println("Zadejte pocet radku (cele cislo).");
        //ukonceni, pokud se misto poctu radku zada nekladne cislo
        while ((rowNumber = sc.nextInt()) > 0) {

            //test spravneho poctu radku
            if (rowNumber == 1) {
                System.out.println("Neplatny rozmer. Matice musi mit "
                        + "vice nez 1 radek.");

            } else {
                System.out.println("Zadejte pocet sloupcu (cele cislo).");
                columnNumber = sc.nextInt();

                //test spravneho poctu sloupcu
                if (columnNumber < 2) {
                    System.out.println("Neplatna volba. Matice musi mit "
                            + "vice nez 1 sloupec.");

                } else {
                    //nacteni prvku matice od uzivatele
                    matrix = new double[rowNumber][columnNumber];
                    System.out.println("Zadejte prvky matice (realna cisla).");
                    for (int i = 0; i < rowNumber; i++) {
                        for (int j = 0; j < columnNumber; j++) {
                            matrix[i][j] = sc.nextDouble();
                        }
                    }

                    //usporadani a vypsani upravene matice pomoci metod
                    matrixSort(matrix);
                    System.out.println("Upravena matice:");
                    matrixDisplay(matrix);
                }
            }

            //uvod opakovani - moznost zadat dalsi matice nebo ukoncit program
            System.out.println("");
            System.out.println("Zadejte rozmery matice.\n"
                    + "Pokud budete chtit program ukoncit, misto poctu "
                    + "radku zadejte nekladne cislo.");
            System.out.println("Zadejte pocet radku (cele cislo).");
            //opakovani cyklu while
        }
    }

    //metoda pro usporadani radku matice (SEMESTRALNI PRACE)    
    public static void matrixSort(double[][] a) {
        double min;
        for (int i = 0; i < a.length - 1; i++) {
            min = Double.MAX_VALUE;
            for (int j = i; j < a.length; j++) {
                if (a[j][0] < min && j == i) {
                    //pokud je min na pozici i, nemusi se prohazovat radky
                    min = a[j][0];
                } else if (a[j][0] < min) {
                    //min je na jine pozici nez i
                    min = a[j][0];
                    rowSwap(a, i, j);
                }
            }
        }
    }

    //metoda pro prohozeni radku matice (SEMESTRALNI PRACE)
    public static void rowSwap(double[][] a, int m, int n) {
        double[] temp = new double[a[0].length];
        temp = a[m];
        a[m] = a[n];
        a[n] = temp;

    }

    //metoda pro vypis upravene matice (SEMESTRALNI PRACE)
    public static void matrixDisplay(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.format(" %10.2f ", a[i][j]);
            }
            System.out.println("");
        }
    }

    //metoda - VANOCNI ULOHA
    private static void vanocniUloha() {

        //promenne
        int pocetDni;
        int barva;
        int vyska;
        int maxDny = 24;
        int plamen = 3;
        final int SIRKA_SVICKA = 11;
        final int SIRKA = SIRKA_SVICKA * 7;
        boolean spatnaVolba;

        //barvy
        String COLOR = "barva";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        String WHITE = "\u001b[0m";
        String YELLOW = "\u001b[33;1m";
        String GREY = "\u001b[30;1m";

        //uvod
        System.out.print(GREEN + "|");
        for (int c = 1; c <= (SIRKA); c++) {
            System.out.print(RED + "-");
        }
        System.out.print(GREEN + "|");
        System.out.println("");
        System.out.print(GREEN + "|");
        for (int a = 1; a <= 31; a++) {
            System.out.print(" ");
        }
        System.out.print(YELLOW + "~VANOCNI PRANI~");
        for (int b = 1; b <= 31; b++) {
            System.out.print(" ");
        }
        System.out.print(GREEN + "|");
        System.out.println("");
        System.out.print(GREEN + "|");
        for (int c = 1; c <= (SIRKA); c++) {
            System.out.print(RED + "-");
        }
        System.out.print(GREEN + "|");
        System.out.println("\n");

        //vstup od uzivatel 1 - barva        
        do {
            spatnaVolba = false;
            System.out.println("Jaka barva svicky by se Vam libila? "
                    + "1 - bila. 2 - cervena, 3 - fialova, 4 - modra");
            barva = sc.nextInt();

            switch (barva) {
                case 1:
                    COLOR = WHITE;
                    break;
                case 2:
                    COLOR = RED;
                    break;
                case 3:
                    COLOR = PURPLE;
                    break;
                case 4:
                    COLOR = BLUE;
                    break;
                default:
                    System.out.println("Spatna volba.");
                    spatnaVolba = true;
            }

        } while (spatnaVolba == true);

        //vstup uzivatele 2 - pocet dni do Vanoc
        System.out.println("Kolik dni zbyva do Vanoc?");
        pocetDni = sc.nextInt();
        vyska = pocetDni + 6;

        if (pocetDni > 24) {
            System.out.println("\n \n \n");
            System.out.print(GREEN + "|");
            for (int c = 1; c <= (SIRKA); c++) {
                System.out.print(RED + "-");
            }
            System.out.print(GREEN + "|");
            System.out.println("");
            System.out.print(GREEN + "|");
            for (int a = 1; a <= 13; a++) {
                System.out.print(" ");
            }
            System.out.print(YELLOW + "VANOCE JSOU JESTE DALEKO. :("
                    + " Odpocitavame od 1.12.");
            for (int b = 1; b <= 14; b++) {
                System.out.print(" ");
            }
            System.out.print(GREEN + "|");
            System.out.println("");
            System.out.print(GREEN + "|");
            for (int c = 1; c <= (SIRKA); c++) {
                System.out.print(RED + "-");
            }
            System.out.print(GREEN + "|");
            System.out.println("\n\n\n");
        } else {
            System.out.println("\n\n\n");

            //horni ramecek        
            for (int a = 1; a <= 3; a++) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= (SIRKA); b++) {
                    System.out.print(RED + "-");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }
            for (int a = 1; a <= 4; a++) {
                System.out.print(GREEN + "|");
                for (int b = (4 - a); b >= 1; b--) {
                    System.out.print(RED + "-");
                }
                System.out.print(GREEN + "|");
                for (int c = 1; c <= ((SIRKA) - (10 - 2 * a)); c++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                for (int d = 4 - a; d >= 1; d--) {
                    System.out.print(RED + "-");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //mezera nad svickou
            for (int a = 0; a <= (maxDny - pocetDni); a++) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= (SIRKA); b++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //plamen - horni cast
            for (int a = 1; a <= plamen; a++) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= 33; b++) {
                    System.out.print(" ");
                }
                for (int c = (plamen) - a + 3; c >= 1; c--) {
                    System.out.print(" ");
                }

                for (int d = 1; d <= a; d++) {
                    System.out.print(YELLOW + "S ");
                }
                for (int e = 1; e <= 33 + (5 - a); e++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //plamen - spodni cast
            for (int a = (plamen); a >= 1; a--) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= 33; b++) {
                    System.out.print(" ");
                }

                for (int c = 1; c <= ((plamen) - a) + 3; c++) {
                    System.out.print(" ");
                }
                for (int d = a; d >= 1; d--) {
                    if (a == 1) {
                        System.out.print(WHITE + "| ");
                    } else {
                        System.out.print(YELLOW + "S ");
                    }
                }
                for (int e = 1; e <= 33 + (5 - a); e++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //vrchni okraj svicky (zmena barvy)
            for (int a = 2; a >= 1; a--) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= (SIRKA / 2 - 3 - (2 - a)); b++) {
                    System.out.print(" ");
                }
                for (int c = 1; c <= (SIRKA_SVICKA - 2 * a); c++) {
                    System.out.print(COLOR + "*");
                }
                for (int d = 1; d <= (SIRKA / 2 - 3 - (2 - a)); d++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //svicka (zmena barvy a velikosti)
            for (int a = 1; a <= vyska; a++) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= (SIRKA / 2) - 5; b++) {
                    System.out.print(" ");
                }
                for (int c = 1; c <= 11; c++) {
                    System.out.print(COLOR + "*");
                }
                for (int d = 1; d <= (SIRKA / 2) - 5; d++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //dolni okraj svicky (zmena barvy)
            System.out.print(GREEN + "|");
            for (int a = 1; a <= (SIRKA / 2 - ((SIRKA_SVICKA / 2) - 1)); a++) {
                System.out.print(" ");
            }
            for (int b = 1; b <= (SIRKA_SVICKA - 2); b++) {
                System.out.print(COLOR + "*");
            }
            for (int c = 1; c <= (SIRKA / 2 - ((SIRKA_SVICKA / 2) - 1)); c++) {
                System.out.print(" ");
            }
            System.out.print(GREEN + "|");
            System.out.println("");

            //horni cast stojanku
            for (int a = 1; a <= 5; a++) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= ((SIRKA / 2) - (SIRKA_SVICKA - 1) / 2) - 3; b++) {
                    System.out.print(" ");
                }
                for (int c = 1; c <= a - 1; c++) {
                    System.out.print(" ");
                }
                for (int d = 1; d <= (SIRKA_SVICKA - a - 1); d++) {
                    System.out.print(GREY + "V ");
                }
                for (int e = 1; e <= ((SIRKA / 2) - (SIRKA_SVICKA / 2) - 5 + a); e++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
                if (a == 5) {
                    System.out.print(GREEN + "|");
                    for (int f = 1; f <= ((SIRKA / 2) - (SIRKA_SVICKA - 1) / 2) - 4 + a; f++) {
                        System.out.print(" ");
                    }
                    for (int g = 1; g <= (SIRKA_SVICKA - a - 1); g++) {
                        System.out.print(GREY + "V ");
                    }
                    for (int h = 1; h <= ((SIRKA / 2) - (SIRKA_SVICKA / 2) - 5 + a); h++) {
                        System.out.print(" ");
                    }
                    System.out.print(GREEN + "|");
                    System.out.println("");
                }

            }

            //dolni cast stojanku
            for (int a = 1; a <= 2; a++) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= (SIRKA / 2) - 6; b++) {
                    System.out.print(" ");
                }
                for (int c = 1; c <= 7; c++) {
                    System.out.print(GREY + "V ");
                }
                for (int d = 1; d <= (SIRKA / 2) - 7; d++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //spodni ramecek
            for (int a = 4; a >= 1; a--) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= (4 - a); b++) {
                    System.out.print(RED + "-");
                }
                System.out.print(GREEN + "|");
                for (int c = 1; c <= (SIRKA) - 10 + 2 * a; c++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                for (int d = 0; d <= (4 - a) - 1; d++) {
                    System.out.print(RED + "-");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }
            for (int a = 1; a <= 3; a++) {
                System.out.print(GREEN + "|");
                for (int b = 1; b <= (SIRKA); b++) {
                    System.out.print(RED + "-");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }

            //text pod pranim
            if (pocetDni == 0) {
                System.out.print(GREEN + "|");
                for (int a = 1; a <= 22; a++) {
                    System.out.print(" ");
                }
                System.out.print(YELLOW + "VANOCE JSOU TU! STASTNE A VESELE!");
                for (int b = 1; b <= 22; b++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            } else {
                System.out.print(GREEN + "|");
                for (int a = 1; a <= 29; a++) {
                    System.out.print(" ");
                }
                System.out.print(YELLOW + "VANOCE SE BLIZI...");
                for (int b = 1; b <= 30; b++) {
                    System.out.print(" ");
                }
                System.out.print(GREEN + "|");
                System.out.println("");
            }
            System.out.print(GREEN + "|");
            for (int c = 1; c <= (SIRKA); c++) {
                System.out.print(RED + "-");
            }
            System.out.print(GREEN + "|");
            System.out.println("\n\n\n");
        }

    }

}
