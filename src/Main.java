import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static LocalDate date = LocalDate.now();

    public static LocalDate issueDate, dueDate;

    public static boolean loginState = false, exit = false, bookAvailable = false;

    public static String[] bookOptions = {"Title", "Author", "Genre", "Quantity"};

    public static String[] memberOptions = {"Name", "Contact", "Email"};

    public static String[][] books = new String[10][5];

    public static String[][] members = new String[10][5];

    public static String[][] issuedBooks = new String[10][3];

    public static int bookCount = 0, updatePosition = 0, mainPosition = 0, memberCount = 0, issueCount = 0, tempBooksIssued = 0, tempBookIssuedPosition = 0;

    public static String tempID = "0", tempBookID, tempMemberID;

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

            switch (input.nextInt()) {

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

    public static boolean bookCheck() {

        boolean presence = false;

        System.out.print("Enter Book ID : ");
        tempID = input.next();

        for (int i = 0; i < bookCount; i++) {

            if (books[i][0].equals(tempID)) {

                presence = true;
                updatePosition = i;

            }

        }

        tempBookID = books[updatePosition][0];

        return presence;
    }

    public static void bookInput() {

        int tempQty;

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter " + bookOptions[i] + " : ");
            books[mainPosition][i+1] = input.next();

        }

        do {

            System.out.print("Enter " + bookOptions[3] + " : ");
            tempQty = input.nextInt();

            if (tempQty < 0) {

                System.out.println("Input must be positive");

            }

        } while (tempQty < 0);

        books[mainPosition][4] = Integer.toString(tempQty);

    }

    public static void addBookFunction() {

        boolean validity;

        do {

            validity = bookCheck();

            if (!validity)
                break;

            System.out.println("Book ID Already in Use!");

        } while (validity);

        bookCount++;
        books[bookCount-1][0] = tempID;
        mainPosition = bookCount-1;

        bookInput();

        System.out.println("Book Added Successfully");

    }

    public static void updateBookFunction() {

        boolean validity = false;

        while (!validity) {

            validity = bookCheck();

            if (validity)
                break;

            System.out.println("Invalid Book ID!");

        }

        mainPosition = updatePosition;

        bookInput();

        System.out.println("Book Updated Successfully");

    }

    public static void deleteBookFunction() {

        boolean validity = false;

        while (!validity) {

            validity = bookCheck();

            if (validity)
                break;

            System.out.println("Invalid Book ID!");

        }

        int x = updatePosition;

        for (int i = x; i < (bookCount-1); i++) {

            for (int y = 0; y < 5; y++) {

                books[i][y] = books[i+1][y];

            }

        }

        bookCount--;

    }

    public static void searchBookFunction() {

        boolean validity = false;

        while (!validity) {

            validity = bookCheck();

            if (validity)
                break;

            System.out.println("Invalid Book ID!");

        }

        mainPosition = updatePosition;

        System.out.println("Book ID\tTitle\tAuthor\tGenre\tQuantity");

        System.out.println(books[mainPosition][0] + "\t" + books[mainPosition][1] + "\t" + books[mainPosition][2] + "\t" + books[mainPosition][3] + "\t\t" + books[mainPosition][4]);



    }

    public static void viewBooksFunction() {

        System.out.println("Book ID\tTitle\tAuthor\tGenre\tQuantity");

        for(int i = 0; i < bookCount; i++){

            System.out.println(books[i][0] + "\t" + books[i][1] + "\t" + books[i][2] + "\t" + books[i][3] + "\t\t" + books[i][4]);

        }

    }


    //Member Management

    public static void manageMembersPage() {

        String[] memberFunctions = {"Add Member", "Update Member", "Delete Member", "Search Member", "View Member", "Exit"};

        boolean exitMMP = false;

        while (!exitMMP){

            for (int i = 0; i < 6; i++) {

                System.out.println((i + 1) + ". " + memberFunctions[i]);

            }

            System.out.print("Choose Option: ");

            switch (input.nextInt()) {

                case 1:
                    addMemberFunction();
                    break;
                case 2:
                    updateMemberFunction();
                    break;
                case 3:
                    deleteMemberFunction();
                    break;
                case 4:
                    searchMemberFunction();
                    break;
                case 5:
                    viewMembersFunction();
                    break;
                case 6:
                    exitMMP = true;
                    break;

            }
        }
    }


    public static boolean memberCheck() {

        boolean presence = false;

        System.out.print("Enter Member ID : ");
        tempID = input.next();

        for (int i = 0; i < memberCount; i++) {

            if (members[i][0].equals(tempID)) {

                presence = true;
                updatePosition = i;
                tempBookIssuedPosition = i;

            }

        }

        tempMemberID = members[updatePosition][0];

        return presence;
    }

    public static void memberInput() {


        System.out.print("Enter " + memberOptions[0] + " : ");
        members[mainPosition][1] = input.next();

        System.out.print("Enter " + memberOptions[1] + " : ");
        members[mainPosition][2] = input.next();

        System.out.print("Enter " + memberOptions[2] + " : ");
        members[mainPosition][3] = input.next();

        members[mainPosition][4] = "0";


    }

    public static void addMemberFunction() {

        boolean validity;

        do {

            validity = memberCheck();

            if (!validity)
                break;

            System.out.println("Member ID Already in Use!");

        } while (validity);

        memberCount++;
        members[memberCount-1][0] = tempID;
        mainPosition = memberCount-1;

        memberInput();

        System.out.println("Member Added Successfully");


    }

    public static void updateMemberFunction() {

        boolean validity = false;

        while (!validity) {

            validity = memberCheck();

            if (validity)
                break;

            System.out.println("Invalid Member ID!");

        }

        mainPosition = updatePosition;

        memberInput();

        System.out.println("Member Updated Successfully");

    }

    public static void deleteMemberFunction() {

        boolean validity = false;

        while (!validity) {

            validity = memberCheck();

            if (validity)
                break;

            System.out.println("Invalid Member ID!");

        }

        int x = updatePosition;

        for (int i = x; i < (memberCount-1); i++) {

            for (int y = 0; y < 5; y++) {

                members[i][y] = members[i+1][y];

            }

        }

        memberCount--;

    }

    public static void searchMemberFunction() {

        boolean validity = false;

        while (!validity) {

            validity = memberCheck();

            if (validity)
                break;

            System.out.println("Invalid Member ID!");

        }

        mainPosition = updatePosition;

        System.out.println("Member ID\tName\tContact\tEmail");

        System.out.println(members[mainPosition][0] + "\t" + members[mainPosition][1] + "\t" + members[mainPosition][2] + "\t" + members[mainPosition][3]);

    }

    public static void viewMembersFunction() {

        System.out.println("Member ID\tName\tContact\tEmail");

        for(int i = 0; i < memberCount; i++){

            System.out.println(members[i][0] + "\t" + members[i][1] + "\t" + members[i][2] + "\t" + members[i][3]);

        }

    }


    //Issue Books

    public static boolean bookAvailabilityCheck() {

        int tempQty;

        bookAvailable = false;

        tempQty = Integer.parseInt(books[updatePosition][4]);

        if (tempQty <= 0)
            System.out.println("Book Not Available!");
        else {

            bookAvailable = true;
            tempQty--;

            books[updatePosition][4] = Integer.toString(tempQty);

        }

        return bookAvailable;

    }

    public static void issueBookPage() {


        boolean validity = false;

        while (!validity) {

            validity = memberCheck();

            if (validity)
                break;

            System.out.println("Invalid Member ID!");

        }

        issuedBooks[issueCount][0] = tempID;

        if (members[updatePosition][4] == null)
            members[updatePosition][4] = "1";
        else {

            tempBooksIssued = Integer.parseInt(members[updatePosition][4]);
            tempBooksIssued++;
            members[updatePosition][4] = Integer.toString(tempBooksIssued);

        }

        validity = false;
        bookAvailable = false;

        while (!validity || !bookAvailable) {

            validity = bookCheck();

            if (validity) {

                bookAvailable = bookAvailabilityCheck();

            } else {

                System.out.println("Invalid Book ID!");

            }

        }

        issuedBooks[issueCount][1] = tempID;

        System.out.print("Enter Due date (YYYY-MM-DD) : ");
        issuedBooks[issueCount][2] = input.next();


        issueCount++;

    }


    //Return Book

    public static void returnBookPage() {

        int position = 0;

        boolean inSystem = false;

        boolean validity = false;

        while (!inSystem) {

            while (!validity) {

                validity = memberCheck();

                if (validity)
                    break;

                System.out.println("Invalid Member ID!");

            }

            validity = false;

            while (!validity) {

                validity = bookCheck();

                if (validity)
                    break;

                System.out.println("Invalid Book ID!");

            }

            for (int i = 0; i <= (issueCount -1); i++) {

                if (issuedBooks[i][0].equals(tempMemberID) && issuedBooks[i][1].equals(tempBookID)) {

                    inSystem = true;
                    position = i;

                    int tempQty = Integer.parseInt(books[updatePosition][4]);

                    tempQty++;

                    books[updatePosition][4] = Integer.toString(tempQty);

                    break;

                }

            }

            if (!inSystem) {

                System.out.println("No record found for the given Member ID and Book ID");
                break;
            }

        }

        for (int i = position; i < (issueCount - 1); i++) {

            for (int y = 0; y < 3; y++) {

                issuedBooks[i][y] = issuedBooks[i+1][y];

            }

        }

        tempBooksIssued = Integer.parseInt(members[tempBookIssuedPosition][4]);
        tempBooksIssued--;
        members[tempBookIssuedPosition][4] = Integer.toString(tempBooksIssued);

        issueCount--;

    }


    //View Reports

    public static void reportsPage() {

        System.out.println("1. Overdue Books");
        System.out.println("2. Books Issued Per Member");
        System.out.println("3. Exit");

        System.out.print("Select Option:");
        int option = input.nextInt();

        switch (option) {

            case 1:
                overdueBooks();
                break;
            case 2:
                booksIssuedPerMember();
                break;
            case 3:
                break;

        }

    }

    public static void overdueBooks() {

        int fineAmount = 0;
        int dayOne = 0, dayTwo = 0;
        double dayDifference = 0;
        LocalDate thisDay;


        System.out.println("Book ID\tMember ID\tDue Date\tDays Overdue\tFine Amount");

        for (int i = 0; i < issueCount; i++) {

            dueDate = LocalDate.parse(issuedBooks[i][2]);
            thisDay = LocalDate.now();

            dayOne = dueDate.getDayOfYear();
            dayTwo = thisDay.getDayOfYear();

            dayDifference = dayTwo - dayOne;

            if (thisDay.isAfter(dueDate)) {

                System.out.println(issuedBooks[i][1] + "\t" + issuedBooks[i][0] + "\t\t\t" + issuedBooks[i][2] + "\t" + dayDifference + "\t\t\t" + (dayDifference*0.5));
            }
        }


    }

    public static void booksIssuedPerMember() {

        System.out.println("Member ID\tBooks Issued");

        for (int i = 0; i < memberCount; i++) {

            if (members[i][4].equals("0"))
                continue;
            else
                System.out.println(members[i][0] + "\t\t\t" + members[i][4]);

        }

    }


    //Main Method

    public static void main(String[] args) {

/*
//Data For Testing

        String[][] testingBooks = {
                {"1001", "1001", "1001", "1001", "2"},
                {"1002", "1002", "1002", "1002", "3"}
        };
        books = testingBooks;
        bookCount = 2;

        String[][] testingMembers = {
                {"001", "001", "001", "001", "0"},
                {"002", "002", "002", "002", "0"}
        };
        members = testingMembers;
        memberCount = 2;

        String[][] testingIssuedBooks = {
                {"001", "1001", "2025-03-03"},
                {"002", "1002", "2025-03-03"}

        };
        issuedBooks = testingIssuedBooks;
        issueCount = 2;

//End of Testing Data
*/

        while (!loginState) {

            loginPage();

        }

        System.out.println(date);

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