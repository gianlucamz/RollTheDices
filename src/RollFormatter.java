import java.util.Arrays;

public class RollFormatter {

    public String formatSum(int[] rolls, int modifier) {
        int sum = 0;
        StringBuilder expression = new StringBuilder("(");

        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
            expression.append(rolls[i]);

            if (i < rolls.length - 1) {
                expression.append(" + ");
            }
        }

        expression.append(")");

        int finalResult = sum + modifier;

        if (modifier == 0) {
            return String.format("%d %s", sum, expression);
        }

        if (modifier > 0) {
            return String.format("%d %s + %d", finalResult, expression, modifier);
        } else {
            return String.format("%d %s - %d", finalResult, expression, Math.abs(modifier));
        }
    }

    public String formatEach(int[] rolls, int modifier) {
        final String BOLD = "\u001B[1m";
        final String RESET = "\u001B[0m";

        int[] sorted = rolls.clone();

        Arrays.sort(sorted);

        StringBuilder sb = new StringBuilder();

        for (int idx = sorted.length - 1; idx >= 0; idx--) {
            int base = sorted[idx];
            int finalValue = base + modifier;

            boolean isHighest = (idx == sorted.length - 1);

            if (isHighest)
                sb.append(BOLD);

            if (modifier == 0) {
                sb.append(base);
            } else if (modifier > 0) {
                sb.append(finalValue)
                        .append(" (")
                        .append(base)
                        .append(" + ")
                        .append(modifier)
                        .append(")");
            } else {
                sb.append(finalValue)
                        .append(" (")
                        .append(base)
                        .append(" - ")
                        .append(Math.abs(modifier))
                        .append(")");
            }

            if (isHighest)
                sb.append(RESET);

            if (idx > 0) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}