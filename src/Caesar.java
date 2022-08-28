package Java6;
import java.util.Scanner;

public class caesar {
    public static void main(String[] args) {
    //Vlene per alfabetin anglez (26 shkronja) dhe eshte perdorur tabela ASCII (Vlerat ascii).

        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter: ");
        System.out.println("Encryption 1:");
        System.out.println("Decryption 2: ");
        int zgjedhja = input.nextInt();

        while (!(zgjedhja == 1 || zgjedhja == 2)) {     //Loop nese shtyp diçka tjeter ne vend te 1 dhe 2.
            System.out.println("Please write 1 or 2!");
            zgjedhja = input.nextInt();
        }

        input.nextLine();

        if (zgjedhja == 1) {
            System.out.print("Please write a text: ");
            String temp = input.nextLine();

            int[] varguUpper = new int[temp.length()]; //Nese shkruajme shkronja te vogla edhe rezultati me dal me shkronja te vogla.
            for (int i = 0; i < temp.length(); i++) {
                if (Character.isLowerCase(temp.charAt(i))) {
                    varguUpper[i] = 1;
                }
            }

            String fjalia = temp.toUpperCase();
            System.out.print("Please write the number of key: ");
            long k = input.nextLong();

            long[] vargu = new long[fjalia.length()];
            for (int i = 0; i < fjalia.length(); i++) {

                if (fjalia.charAt(i) == '\u0020') {
                    vargu[i] = 32;
                }

                else if ((int) fjalia.charAt(i) + k > 90) {

                    int t = 90 - (int) fjalia.charAt(i);
                    for (int f = 65; f <= 90; f++) {
                        t++;
                        if (t == k) {
                            vargu[i] = f;
                            break;
                        }
                        if (f == 90) {
                            f = 64;
                        }
                    }
                }
                else {
                    vargu[i] = (int) fjalia.charAt(i) + k;
                }
            }

            input.nextLine();
            System.out.print("The encrypted text in Caesar cipher is: ");
            for (int t = 0; t < vargu.length; t++) {
                char c = (char) vargu[t];
                if (varguUpper[t] == 1) {
                    System.out.print(Character.toLowerCase(c));
                }
                else
                System.out.print(c);
            }
        }

        //DECRYPTION / DEKRIPTIMI / DECHIPHERING
        if (zgjedhja == 2) {
            System.out.print("Please write a text: ");
            String temp = input.nextLine();

            int[] varguUpper = new int[temp.length()]; //Nese shkruajme shkronja te vogla edhe rezultati me dal me shkronja te vogla.
            for (int i = 0; i < temp.length(); i++) {
                if (Character.isLowerCase(temp.charAt(i))) {
                    varguUpper[i] = 1;
                }
            }

            String fjalia = temp.toUpperCase();
            System.out.print("Please write the number of key: ");
            long k = input.nextLong();

            long[] vargu = new long[fjalia.length()];
            for (int i = 0; i < fjalia.length(); i++) {

                if (fjalia.charAt(i) == '\u0020') {
                    vargu[i] = 32;
                }

                else if ((int) fjalia.charAt(i) - k < 65) {

                    int t = (int) fjalia.charAt(i) - 65;
                    for (int f = 90; f >= 65; f--) {
                        t++;
                        if (t == k) {
                            vargu[i] = f;
                            break;
                        }

                        if (f == 65) {
                            f = 91;
                        }
                    }
                }
                else {
                    vargu[i] = (int) fjalia.charAt(i) - k;
                }
            }

            input.nextLine();
            System.out.print("The decrypted text in Caesar cipher is: ");
            for (int t = 0; t < vargu.length; t++) {
                char c = (char) vargu[t];
                if (c == '$') {
                    continue;
                }
                if (varguUpper[t] == 1) {
                    System.out.print(Character.toLowerCase(c));
                }
                else
                    System.out.print(c);
            }
        }
    }
}
