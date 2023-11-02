import java.util.List;
import model.User;
import model.UserManager;

public class Main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();
        List<User> users = userManager.getUsers();
        userManager.signUp("c", "c", "123", "dev");

        // Example of Login
        String username = "c";
        String enteredPassword = "123";

        // Find the user with the given username
        User loginUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                loginUser = user;
                break;
            }
        }

        //
        System.out.println(loginUser.getUsername()+" "+loginUser.getPassword());
        if (loginUser != null && loginUser.login(enteredPassword)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }

    }
}