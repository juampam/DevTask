package model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private String csvFileName = "src/db/users.csv";

    public UserManager() {
        users = new ArrayList<>();
        loadUsersFromCSV();
    }

    public void signUp(String username, String email, String password, String userType) {
        // Check if the username or email is already taken
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
                System.out.println("Username or email is already taken.");
                return;
            }
        }

        // Create a new user
        if (userType.equals("dev")) {
            users.add(new DevUser(username, email, password, true));
        } else if (userType.equals("normal")) {
            users.add(new NormalUser(username, email, password, true));
        } else {
            System.out.println("Invalid user type.");
            return;
        }
        
        saveUsersToCSV();
        System.out.println("Sign-up successful.");
    }

    public List<User> getUsers() {
        return users;
    }

    private void loadUsersFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userAttributes = line.split(",");
                if (userAttributes.length == 4) { // Check if there are four attributes
                    String username = userAttributes[0];
                    String email = userAttributes[1];
                    String password = userAttributes[2];
                    String userType = userAttributes[3];
                    if (userType.equals("dev"))
                        users.add(new DevUser(username, email, password,false));
                    else if (userType.equals("normal"))
                        users.add(new NormalUser(username, email, password,false));
                    else {
                        System.out.println("Invalid user type: " + userType);
                    }
                } else {
                    System.out.println("Invalid CSV line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users from CSV file: " + e.getMessage());
        }
    }
    

    private void saveUsersToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFileName))) {
            for (User user : users) {
                if (user instanceof NormalUser) {
                    NormalUser normalUser = (NormalUser) user;
                    String csvLine = normalUser.getUsername() + "," + normalUser.getEmail() + "," + normalUser.getPassword()+ "," + "normal";
                    bw.write(csvLine);
                    bw.newLine();
                }
                else if (user instanceof DevUser) {
                    DevUser devUser = (DevUser) user;
                    String csvLine = devUser.getUsername() + "," + devUser.getEmail() + "," + devUser.getPassword()+ "," + "dev";
                    bw.write(csvLine);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            // Handle any exceptions, such as a write error
        }
    }
}
