import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static String[][] books = new String[100][5];

    public static int bookCount = 0;

    public static String[] inputFields = {"Title", "Author", "Genre", "Quantity"};

    public static void manageBooks() {

        boolean exit = false;

        while (!exit) {
            String[] bookOptions = {"Add Book", "Update Book", "Delete Book", "View Books", "Search Books", "Go to Homepage"};

            for (int i = 0; i < 6; i++) {

                System.out.println(" " + (i + 1) + ". " + bookOptions[i]);

            }

            System.out.print("Choose option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    viewBooks();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }

    }

    public static void addBook() {

        boolean validity = false;

        String tempID = "0";

        while (!validity) {

            System.out.print("Enter Book ID: ");
            tempID = input.next();
            validity = true;

            for (int i = 0; books[i][0] != null; i++) {

                if (books[i][0].equals(tempID)) {
                    validity = false;
                    System.out.println("Enter Different ID");
                }

            }

        }

        books[bookCount][0] = tempID;

        for(int i = 0; i < 4; i++) {

            System.out.print("Enter " + inputFields[i] + "\t: ");
            books[bookCount][i+1] = input.next();

        }

        bookCount++;

    }

    public static void updateBook() {

        boolean validity = false;
        String tempID;
        int tempLocation = 0;

        while (!validity) {

            System.out.print("Enter Book ID: ");
            tempID = input.next();

            for (int i = 0; books[i][0] != null; i++) {

                if (books[i][0].equals(tempID)) {

                    validity = true;
                    i = tempLocation;

                }

            }

            if (validity) {
                for(int i = 0; i < 4; i++) {

                    System.out.print("Enter " + inputFields[i] + "\t: ");
                    books[tempLocation][i+1] = input.next();

                }
            } else {

                System.out.println("Incorrect ID");

            }
        }


    }

    public static void deleteBook() {

    }

    public static void viewBooks() {

        System.out.println("Book ID\tTitle\tAuthor\tGenre\tQuantity");

        for(int i = 0; i < bookCount; i++){

            System.out.println(books[i][0] + "\t" + books[i][1] + "\t" + books[i][2] + "\t" + books[i][3] + "\t\t" + books[i][4]);

        }

    }

    public static void searchBook() {

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

        String[] homeOptions = {"Manage Books", "Manage Members", "Issue Books", "Return Books", "View Reports", "Exit"};

        for(int i = 0; i < 6; i++){

            System.out.println(" " + (i+1) + ". " + homeOptions[i]);

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
        boolean exit = false;

        while (!exit){

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
                    exit = true;
                    break;
            }
        }
    }

}

