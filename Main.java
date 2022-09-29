import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        int ch;
        while (true) {
            System.out.println("PRESS 1 TO SEE AVAILABLE BOOKS\nPRESS 2 TO ISSUE A BOOK\nPRESS 3 TO RETURN A BOOK\nPRESS 4 TO ADD A BOOK\nPRESS 5 TO EXIT"); 
            ch = sc.nextInt();
            sc.nextLine();
            String book,author,name,date;
            switch(ch){
                case 1:
                    lib.showAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter your name = ");
                    name = sc.nextLine();
                    System.out.print("Enter book name = ");
                    book = sc.nextLine();
                    System.out.print("Enter author's name = ");
                    author = sc.nextLine();
                    try{
                        lib.issueBook(book, author, name);
                    }
                    catch(BookNotFoundException e){
                        System.out.println(e.getMessage());     
                    }
                    break;
                
                case 3:
                    System.out.print("Enter your name = ");
                    name = sc.nextLine();
                    System.out.print("Enter book name = ");
                    book = sc.nextLine();
                    System.out.print("Enter author's name = ");
                    author = sc.nextLine();
                    System.out.print("Enter date of issue = ");
                    date = sc.nextLine();

                    try{
                        lib.returnBook(book, author, name, date);
                    }
                    catch(BookDetailsNotCorrectException e){
                        System.out.println(e.getMessage());     
                    }
                    break;

                case 4:
                    System.out.print("Enter book name = ");
                    book = sc.nextLine();
                    System.out.print("Enter author's name = ");
                    author = sc.nextLine();
                    lib.addBook(book, author);
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("INVALID INPUT !");
            }
        }
    }
}
