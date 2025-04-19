import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void manageBooks() {

    }

    public static void manageMembers() {

    }

    public static void issueBooks() {

    }

    public static void returnBooks() {

    }

    public static void viewReports() {

    }

    public static int homePage() {

        String[] options = {"Manage Books", "Manage Members", "Issue Books", "Return Books", "View Reports", "Exit"};

        for(int i = 0; i < 6; i++){

            System.out.println(" " + (i+1) + ". " + options[i]);

        }

        System.out.print("Choose option: ");
        return input.nextInt();

    }

    public static void login() {

        boolean loginState = false; //Store login state
        String[] loginCredentials = {"Admin", "1234"}; //Store login credentials
        String[] loginInput = new String[2]; //Store login input

        do {

            //Take inputs and validate login
            System.out.print("Enter Username: ");
            loginInput[0] = input.next();
            System.out.print ("Enter Password: ");
            loginInput[1] = input.next();

            if (loginInput[0].equals(loginCredentials[0]) && loginInput[1].equals(loginCredentials[1]))
                loginState = true;
            else
                System.out.println("Invalid Credentials. Try again.");


        } while (!loginState);

    }

    public static void main(String[] args) {

        login();

        int option = homePage();

        switch (option) {
            case 1:
                manageBooks();
                break;
            case 2:
                manageMembers();
                break;
            case 3:
                issueBooks();
                break;
            case 4:
                returnBooks();
                break;
            case 5:
                viewReports();
                break;
            case 6:
                break;

        }
    }

}

