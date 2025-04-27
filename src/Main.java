import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static boolean loginState = false, exit = false;

    public static String[] bookOptions = {"Title", "Author", "Genre", "Quantity"};

    public static String[][] books = new String[10][5];

    public static int bookCount = 0, optionSelection;


    //Login & Home

    public static void loginPage() {

        String[] userPassword = {"Username", "Password"};
        String[] loginCredentials = {"Admin", "1234"};
        String[] inputCredentials = new String[2];

        for (int i = 0; i < 2; i++) {

            System.out.print("Enter " + userPassword[i] + ": ");
            inputCredentials[i] = input.next();

        }

        if (inputCredentials[0].equals(loginCredentials[0]) && inputCredentials[1].equals(loginCredentials[1]))
            loginState = true;
        else {

            System.out.println("Invalid credentials. Try Again.");

        }

    }

    public static int homePage() {

        String[] menuOptions = {"Manage Books", "Manage Members", "Issue Books", "Return Books", "View Reports", "Exit System"};

        for (int i = 0; i < 6; i++) {

            System.out.println((i+1) + ". " + menuOptions[i]);

        }

        System.out.print("Select Option : ");

        return input.nextInt();


    }


    //Book Management

    public static void manageBooksPage() {

        String[] bookFunctions = {"Add Book", "Update Book", "Delete Book", "Search Book", "View Book", "Exit"};

        boolean exitMBP = false;

        while (!exitMBP){

            for (int i = 0; i < 6; i++) {

                System.out.println((i + 1) + ". " + bookFunctions[i]);

            }

            System.out.print("Choose Option: ");
            optionSelection = input.nextInt();

            switch (optionSelection) {

                case 1:
                    addBookFunction();
                    break;
                case 2:
                    updateBookFunction();
                    break;
                case 3:
                    deleteBookFunction();
                    break;
                case 4:
                    searchBookFunction();
                    break;
                case 5:
                    viewBooksFunction();
                    break;
                case 6:
                    exitMBP = true;
                    break;

            }
        }

    }

    public static void addBookFunction() {

        String tempID;

        boolean validity = false;

        while (!validity) {

            System.out.println("Enter Book ID : ");
            tempID = input.next();

            for (int i = 0; i < bookCount; i++) {

                if (books[i][0].equals(tempID))
                    validity = false;
                else {

                    validity = true;
                    bookCount++;
                    books[bookCount-1][0] = tempID;

                }

            }

            if (!validity)
                System.out.println("Book ID already in use!");

        }

        for (int i = 0; i < 4; i++) {

            System.out.println("Enter " + bookOptions[i] + " : ");
            books[bookCount][i] = input.next();

        }

    }

    public static void updateBookFunction() {

    }

    public static void deleteBookFunction() {

    }

    public static void searchBookFunction() {

    }

    public static void viewBooksFunction() {

    }


    //Member Management

    public static void manageMembersPage() {

    }

    public static void addMemberFunction() {

    }

    public static void updateMemberFunction() {

    }

    public static void deleteMemberFunction() {

    }

    public static void searchMemberFunction() {

    }

    public static void viewMembersFunction() {

    }


    //Issue Books

    public static void issueBookPage() {

    }


    //Return Book

    public static void returnBookPage() {

    }


    //View Reports

    public static void reportsPage() {

    }

    public static void overdueBooks() {

    }

    public static void booksIssuedPerMember() {

    }


    //Main Method

    public static void main(String[] args) {



        while (!loginState) {

            loginPage();

        }

        while (!exit) {

            int menuOption = homePage();

            switch (menuOption) {

                case 1:
                    manageBooksPage();
                    break;
                case 2:
                    manageMembersPage();
                    break;
                case 3:
                    issueBookPage();
                    break;
                case 4:
                    returnBookPage();
                    break;
                case 5:
                    reportsPage();
                    break;
                case 6:
                    break;

            }

            if (menuOption == 6)
                exit = true;

        }
    }
}
