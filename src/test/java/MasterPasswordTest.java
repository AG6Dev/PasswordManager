import org.mindrot.jbcrypt.BCrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MasterPasswordTest {
    public static void main(String[] args) {
        try {
            String masterPassword = "MySecureMasterPassword";
            String storedHashedPassword = hashMasterPassword(masterPassword);
            System.out.println(storedHashedPassword);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String enteredPassword = reader.readLine();
            boolean isCorrectPassword = verifyMasterPassword(enteredPassword, storedHashedPassword);

            if (isCorrectPassword) {
                System.out.println("Password is correct. Access granted!");
            } else {
                System.out.println("Incorrect password. Access denied!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String hashMasterPassword(String masterPassword) {
        String salt = BCrypt.gensalt();
        System.out.println("Salt is: " + salt);
        return BCrypt.hashpw(masterPassword, salt);
    }

    private static boolean verifyMasterPassword(String enteredPassword, String storedHashedPassword) {
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }
}
