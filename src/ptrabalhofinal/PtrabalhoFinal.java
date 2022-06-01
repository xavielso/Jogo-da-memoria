package ptrabalhofinal;

import java.util.Scanner;

public class PtrabalhoFinal {

    static String[][] gabarito = new String[4][4];
    static String[][] tabuleiro = new String[4][4];

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int contador = 8, linha1, coluna1, linha2, coluna2, contador1 = 0;
        boolean conferir;
        String sair = "SIM";
        sortearLetras();
        mostrar1();
        mostrar();
        do {
            do {

                do {
                    System.out.print("\nQual linha que você deseja:");
                    linha1 = ler.nextInt();

                    System.out.print("Qual coluna que você deseja:");
                    coluna1 = ler.nextInt();
                    System.out.println("\n");
                    linha1--;
                    coluna1--;

                    conferir = conferindo(linha1, coluna1);
                } while (conferir == false);

                tabuleiro[linha1][coluna1] = gabarito[linha1][coluna1];
                
                mostrar();
                do {
                    System.out.print("\nQual linha que você deseja:");
                    linha2 = ler.nextInt();
                    System.out.print("Qual coluna que você deseja:");
                    coluna2 = ler.nextInt();
                    linha2--;
                    coluna2--;

                    conferir = conferindo(linha2, coluna2);
                    System.out.println("\n");
                } while (conferir == false);
                tabuleiro[linha2][coluna2] = gabarito[linha2][coluna2];
                mostrar();

                if (!gabarito[linha1][coluna1].equals(gabarito[linha2][coluna2])) {
                    tabuleiro[linha1][coluna1] = "#";
                    tabuleiro[linha2][coluna2] = "#";
                    contador1++;

                } else {
                    contador1++;

                    contador--;
                }

            } while (contador != 0);
            System.out.println("\nVOCÊ FEZ:" + contador1 + " JOGADAS");

            System.out.println("\nDeseja parar de jogar? (SIM OU NÃO): ");
            sair = ler.next();
        } while (sair.equalsIgnoreCase("SIM"));
    }

    public static boolean conferindo(int linha, int coluna) {
        
        if (linha < 4 && coluna < 4 && linha>=0 && coluna>=0) {
            
            if (tabuleiro[linha][coluna].equals("#")) {
                return true;
            } else {
                System.out.println("NÃO PODE SELECIONAR ESSA OPÇÃO!");
                return false;
            }

        } else {
            System.out.println("LINHA OU COLUNA, NÃO EXISTE!");
            return false;
        }

    }

    public static void mostrar() {

        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1);

            for (int j = 0; j < 4; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
            }

            System.out.println(" ");
        }
        for (int i = 0; i < 4; i++) {
            System.out.print("  " + (i + 1));
        }
    }
public static void mostrar1() {

        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1);

            for (int j = 0; j < 4; j++) {
                System.out.print(" " + gabarito[i][j] + " ");
            }

            System.out.println(" ");
        }
        for (int i = 0; i < 4; i++) {
            System.out.print("  " + (i + 1));
        }
        System.out.println("\n");
    }
    public static void sortearLetras() {
        String[] letras = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
        int linha, coluna;

        for (int i = 0; i < 16; i++) {
            do {
                linha = (int) (Math.random() * 4);
                coluna = (int) (Math.random() * 4);

            } while (gabarito[linha][coluna] != null);
            gabarito[linha][coluna] = letras[i];
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tabuleiro[i][j] = "#";
            }
        }

    }
}
