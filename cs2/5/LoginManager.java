public class LoginManager {
    private static String[] allowed_usernames = { "jerry", "tom", "enrique" };
    private static String[] allowed_passwords = { "123Welcome", "Qwerti", "Azertu2" };
    private static int attempts = 0;

    public static boolean login(String userName, String password) {
        attempts++;

        if (attempts > 3) {
            return false;
        }

        for (int i = 0; i < allowed_usernames.length; i++) {
            if (userName.toLowerCase().equals(allowed_usernames[i].toLowerCase())
                    && password.equals(allowed_passwords[i])) {
                return true;
            }
        }
        return false;
    }

    public static int getAttempts() {
        return attempts;
    }
}