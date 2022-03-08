import java.math.BigInteger;

public class Java2 {
    public static void main(String[] args) {
        User user = new User("Ivan", "Petrov");
        String fullName = UserUtil.getFullName(user);
        System.out.println(fullName);
    }

}

class UserUtil {
    public static String getFullName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
