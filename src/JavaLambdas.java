import java.util.Arrays;
import java.util.List;

public class JavaLambdas {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Petr", "Oleg");

        Action<String> action = new PrintStringAction2();


        Action<String> anotherAction = new Action<String>() {
            @Override
            public void doSomething(String data) {
                System.out.println("Print from anonim: " + data);
            }
        };

        Action<String> lambdaAction =
                data -> System.out.println("Print from lamda: " + data);


//
//        action.doSomething("String 1");
//        anotherAction.doSomething("String 2");


        forEach(names, data -> System.out.println("my data: " + data));

    }

    private static void forEach(List<String> items, Action<String> action) {
        for (String item : items) {
            action.doSomething(item);
        }
    }
}

interface Action<T> {
    void doSomething(T data);
}

class PrintStringAction2 implements Action<String> {

    @Override
    public void doSomething(String data) {
        System.out.println("Printing: " + data);
    }
}
