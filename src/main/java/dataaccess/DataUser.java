package dataaccess;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import model.User;



public class DataUser {

    public static Map<Integer, User> usersPassword = new HashMap<Integer, User>();



    private static int count = 0;
    private static boolean isLoggedIn = false;
    public static void addUsers() {

        User user1 = new User("mike", "mike");
        User user2 = new User("yonas", "yonas");
        User user3 = new User("hana", "123");

        add(user1);
        add(user2);
        add(user3);

    }

    private static void add(User user) {
        usersPassword.put(count, user);
        count++;
    }

    public static User checkUser(String username, String password) {
        Iterator userPasswords = usersPassword.entrySet().iterator();
        while (userPasswords.hasNext()) {
            Entry<Integer, User> mappairs = (Entry<Integer, User>) userPasswords.next();
            if (username.equals(mappairs.getValue().getUsername())
                    && password.equals(mappairs.getValue().getPassword())) {
                isLoggedIn = true;
                return mappairs.getValue();

            }

        }
        return null;
    }
    public static boolean hasLoggedIn()
    {
        return isLoggedIn;
    }

}
