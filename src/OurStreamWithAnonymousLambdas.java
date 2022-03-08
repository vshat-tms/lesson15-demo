public class OurStreamWithAnonymousLambdas {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"one", "TWO", "three"};

        new MyStream(stringArray)
                .filter(s -> s.length() == 3)
                .map(s -> "<" + s + ">")
                .filter(s -> s.charAt(1) == 'o')
                .forEach(s1 -> System.out.println(s1));
    }
}


