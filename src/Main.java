import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        DiceRoller roller = new DiceRoller();
        RollFormatter formatter = new RollFormatter();

        System.out.println("Rolagens: ");
        int nRolls = scanner.nextInt();

        if (nRolls < 1) {
            scanner.close();
            return;
        }

        System.out.println("Modificador: ");
        int modifier = scanner.nextInt();

        System.out.println("Modo:");
        System.out.println("1 - Somar rolagens");
        System.out.println("2 - Rolagens isoladas");
        int option = scanner.nextInt();

        int[] rolls = roller.rollMultipleD20(nRolls);

        System.out.println("Resultado:");

        if (option == 1) {
            System.out.println(formatter.formatSum(rolls, modifier));
        } else if (option == 2) {
            System.out.println(formatter.formatEach(rolls, modifier));
        }

        scanner.close();
    }
}
