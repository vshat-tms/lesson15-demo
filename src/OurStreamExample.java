import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OurStreamExample {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"one", "TWO", "three"};

        for (String s : stringArray) {
            // .map(new LowerCaseTransformation())
            String lowerS = s.toLowerCase();

            //  .filter(new StartsWithTStringPredicate())
            if(s.startsWith("t")) {
                // .map(new UpperCaseTransformation())
                String upperS = lowerS.toUpperCase();

                System.out.println(upperS);
            }
        }

        // .map(new LowerCaseTransformation())
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            newList.add(stringArray[i].toLowerCase());
        }

        // .filter(new StartsWithTStringPredicate())
        List<String> newList2 = new ArrayList<>();
        for (String s : newList) {
            if(s.startsWith("t")) {
                newList2.add(s);
            }
        }

        // .map(new UpperCaseTransformation())
        List<String> newList3 = new ArrayList<>();
        for (String s : newList2) {
            newList3.add(s.toUpperCase());
        }

        //.forEach(new PrintStringAction());
        for (String s : newList3) {
            System.out.println(s);
        }



        new MyStream(stringArray)
                .map(new LowerCaseTransformation())
                .filter(new StartsWithTStringPredicate())
                .map(new UpperCaseTransformation())
                .forEach(new PrintStringAction());
    }
}

class MyStream {
    private final String[] charArray;

    MyStream(String[] charArray) {
        this.charArray = charArray;
    }

    public void forEach(StringAction action) {
        for (String s : charArray) {
            action.doSomethingWithString(s);
        }
    }

    public MyStream map(StringTransformation action) {
        String[] newCharArray = new String[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            newCharArray[i] = action.transformString(charArray[i]);
        }

        return new MyStream(newCharArray);
    }

    public MyStream filter(StringPredicate predicate) {
        List<String> list = new ArrayList<String>();

        for (String s : charArray) {
            if (predicate.checkString(s)) {
                list.add(s);
            }
        }

        return new MyStream(list.toArray(new String[0]));
    }

}

interface StringPredicate {
    boolean checkString(String s);
}

class StartsWithTStringPredicate implements StringPredicate {
    @Override
    public boolean checkString(String s) {
        return s.startsWith("t");
    }
}


interface StringTransformation {
    String transformString(String s);
}

class UpperCaseTransformation implements StringTransformation {

    @Override
    public String transformString(String s) {
        return s.toUpperCase();
    }
}

class LowerCaseTransformation implements StringTransformation {

    @Override
    public String transformString(String s) {
        return s.toLowerCase();
    }
}

interface StringAction {
    void doSomethingWithString(String s);
}

class PrintStringAction implements StringAction {
    @Override
    public void doSomethingWithString(String s) {
        System.out.println("Your string: " + s);
    }
}


class PureFunctionExample {
    public static void main(String[] args) {
        MathUtils.findMin(Arrays.asList(0, 1, 2, 3));
    }
}

class NonPureClass {
    private int numberToAdd = 2;


    public int addNumber(int number) {
        numberToAdd +=2;


        return number + numberToAdd;
    }
}

class MathUtils {
    private MathUtils() {

    }

    public static int findMin(List<Integer> list) {
        ///
        return  0;
    }
}