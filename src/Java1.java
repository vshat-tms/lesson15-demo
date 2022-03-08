import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java1 {
    public static void main(String[] args) {
        String text = "Т 9 нбсуб, ежгшполй!";
        System.out.println(shiftString2(text, -1));

        Action<String> stringAction = s -> {
            String prefix = "hello: ";
            System.out.println(prefix + s);
        };

//        String originalText = "С 8 марта, девчонки!";
//        System.out.println(shiftString(originalText, 1));
    }

    private static String shiftString(String sourceString, int shiftValue) {
        char[] chars = sourceString.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char aChar : chars) {
            int charCode = aChar;
            int newCharCode = charCode;
            if (aChar != ' ' && aChar != ',' && aChar != '!') {
                newCharCode = charCode + shiftValue;
            }
            char newChar = (char) newCharCode;
            sb.append(newChar);
        }

        return sb.toString();
    }

    private static String shiftString2(String sourceString, int shiftValue) {
        StringBuilder sb = new StringBuilder();


        sourceString.chars()
                .map(operand -> operand + shiftValue)
                .mapToObj(value -> (char) value)
                .map(character -> character == ' ' ? (char)(character - shiftValue) : character)
                .forEach(sb::append);

        return sb.toString();
    }


    static class MyConsumer implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s);
        }

    }
}
