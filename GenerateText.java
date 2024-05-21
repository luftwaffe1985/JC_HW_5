import java.util.Random;

public class GenerateText {
    private static final Random random = new Random();
    private static final int char_length = 75;
    private static final int char_height = 100;

    // Generates a sequence of symbols
    public static String generateSymbols(int amount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            stringBuilder.append((char) random.nextInt(char_length, char_height + 1));
        }
        return stringBuilder.toString();
    }
}