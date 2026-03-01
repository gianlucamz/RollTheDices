import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        DiceRoller roller = new DiceRoller();
        RollFormatter formatter = new RollFormatter();

        System.out.println("Rolagens: ");

        if (!scanner.hasNextInt()) {
            return;
        }
        int nRolls = scanner.nextInt();

        if (nRolls < 1) {
            return;
        }

        System.out.println("Modificador: ");

        if (!scanner.hasNextInt()) {
            return;
        }
        int modifier = scanner.nextInt();

        System.out.println("Modo:");
        System.out.println("1 - Somar rolagens");
        System.out.println("2 - Rolagens isoladas");

        if (!scanner.hasNextInt()) {
            return;
        }
        int option = scanner.nextInt();

        if (option != 1 && option != 2) {
            return;
        }

        int[] rolls = roller.rollMultipleD20(nRolls);

        System.out.println("Resultado:");

        if (option == 1) {
            System.out.println(formatter.formatSum(rolls, modifier));
        } else {
            System.out.println(formatter.formatEach(rolls, modifier));
        }
    }
}