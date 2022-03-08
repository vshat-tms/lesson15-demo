import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class JavaStreamWithLambdas {
    public static void main(String[] args) {
        Function<Integer, Integer> myLambda = n -> doubleValue(n);
        Function<Integer, Integer> myLambda2 = JavaStreamWithLambdas::doubleValue;


        Consumer<String> stringConsumer = x -> System.out.println(x);
        Consumer<String> stringConsumer2 = System.out::println;
        Predicate<Integer> integerPredicate = n -> n % 2 == 0;


        Function<Integer, Integer> integerIntegerFunction = n -> n * 2;
        Stream.of(1, 2, 3, 4, 5)
                .filter(integerPredicate)
                .map(integerIntegerFunction)
                .map(n -> "[" + n + "]")
                .forEach(stringConsumer);


    }

    private static int doubleValue(int x) {
        return x * 2;
    }
}


