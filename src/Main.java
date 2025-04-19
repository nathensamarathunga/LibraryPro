import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

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

    }

}

