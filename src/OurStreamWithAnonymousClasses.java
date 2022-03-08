public class OurStreamWithAnonymousClasses {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"one", "TWO", "three"};

        StringPredicate predicate = new StringPredicate() {
            @Override
            public boolean checkString(String s) {
                return s.length() == 3;
            }
        };

        StringAction action = new StringAction() {
            @Override
            public void doSomethingWithString(String s) {
                System.out.println(s);
            }
        };


        new MyStream(stringArray)
                .filter(predicate)
                .forEach(action);
    }
}


