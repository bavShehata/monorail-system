
package Monorail.src.monorail;

import java.util.HashMap;
import java.util.Scanner;

public class User {

    Scanner input = new Scanner(System.in);
    protected int ssn;
    private String username;
    private String password;
    private String email;
    protected boolean isLoggedIn = false;
    static HashMap<String, String> userDObjc = new HashMap<String, String>();// stores username as key and
                                                                             // password+email as values

    public void createAccount() {
        System.out.println("Please enter your ssn");
        ssn = input.nextInt();

        int l;
        do {
            System.out.println("Please enter your username with more than 4 characters");
            username = input.nextLine();
            l = username.length();
        } while (l <= 4);

        System.out.println("Please enter your email");
        email = input.nextLine();

        for (int i = 0; i <= email.length(); i++) {
            if (email.charAt(i) == '@') {
                break;
            }

            else {
                if (i == email.length()) {
                    System.out.println("Inalid email");
                }
            }
        }
        // the same as username System.out.println("Enter a password"); password =
        input.nextLine();

        while (password.length() <= 5) {
            System.out.println("Password not secure enough.Enter one with more than 5 characters.");
        }

        // adding a user userDObjc.put(username, password);

    }

    public void login() {

        System.out.println("Please enter your username");
        username = input.nextLine();
        int i;
        do {

            System.out.println("Enter your password");
            password = input.nextLine();
            i = password.length();
        } while (i <= 5);

        String s;
        s = userDObjc.get(username);
        if (username == s) {
            System.out.println("Welcome " + username);
            isLoggedIn = true;

        }

        else {
            System.out.println("Incorrect password");

        }

    }

    public void deleteAccount(String us) {

        String value;
        value = userDObjc.get(us);
        if (value != null) {
            userDObjc.remove(us);
            System.out.println("Account deleted successfully");

        } else {
            System.out.println("no account found \n");
        }
    }

    public void manageAccount() {

        int choice;

        System.out.println("To modify username enter 1 ");
        System.out.println("To modify password enter 2 ");
        choice = input.nextInt();
        String old;
        switch (choice) {

            case 1:

                System.out.println("Enter new username");
                username = input.nextLine();

                while (username.length() <= 4) {
                    System.out.println("Username should have more than 4 characters.");
                    username = input.nextLine();
                }
                userDObjc.put(username, password);
                break;

            case 2:

                System.out.println("Enter old one");
                old = input.nextLine();

                System.out.println("Enter new one");
                password = input.nextLine(); // Check for more than 5 characters
                while (password.length() <= 5) {
                    System.out.println("Password not secure enough.Enter one with more than 5 characters.");
                }
                userDObjc.replace(username, old, password);
                break;

            default:
        }

    } // Add a list of options // logout // manageAccount // deleteAccount void

    public void userMenu() {

        System.out.println("select an option ");
        System.out.println("1-logout ");
        System.out.println("2-manageAccount");
        System.out.println("3-deleteAccount");
        int option = input.nextInt();

        switch (option) {

            case 1:
                isLoggedIn = false;
                break;

            case 2:
                manageAccount();
                break;
            case 3:
                deleteAccount(username);
                break;

            default:

        }
    }
}
