import java.util.Random;

public class DiceRoller {

    private final Random random = new Random();

    public int rollD20() {
        return random.nextInt(1, 21);
    }

    public int[] rollMultipleD20(int nRolls) {
        int[] results = new int[nRolls];

        for (int i = 0; i < nRolls; i++) {
            results[i] = rollD20();
        }

        return results;
    }
}
