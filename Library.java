import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Library{
    private ArrayList <String> booksAvailable = new ArrayList<>();
    private ArrayList <String> booksIssued = new ArrayList<>();
    private ArrayList <String> authorNames = new ArrayList<>();
    private ArrayList <String> userNames = new ArrayList<>();
    private ArrayList <String> issueDates = new ArrayList<>();
    void addBook(String book,String auth){
        /*To add book in the library donated by the user. */
        booksAvailable.add(book);
        authorNames.add(auth);
        System.out.println("Book Name - "+book+"\nAuthor - "+auth);
        System.out.println("Thank you for your contribution !\n\tHave a nice day ahead :)");
    }

    void returnBook(String book,String auth,String userName,String date)throws BookDetailsNotCorrectException{
        /*To return the book to the library that was issued to the user.  */
        
        // checking whether book was issued or not
        boolean isBookThere = false, isDateOfIssueTrue = false,isUserNameCorrect = false;
        for (int i = 0;i<booksIssued.size();i++){
            if (booksIssued.get(i).equalsIgnoreCase(book)){
                isBookThere = true;
                break;
            }
        }

        // checking whether the date of issue is correct or not
        for (int j = 0;j<issueDates.size();j++){
            if (issueDates.get(j).equalsIgnoreCase(date)){
                isDateOfIssueTrue = true;
                break;
            }
        }

        // checking whether the user name is correct or not
        for (int j = 0;j<userNames.size();j++){
            if (userNames.get(j).equalsIgnoreCase(userName)){
                isUserNameCorrect = true;
                break;
            }
        }
        if (isBookThere&&isDateOfIssueTrue&&isUserNameCorrect){
            booksAvailable.add(book);
            authorNames.add(auth);
            booksIssued.remove(book);
            userNames.remove(userName);
            issueDates.remove(date);

            System.out.println("Thanks for returning the book, hope you enjoyed reading\n\tPlease visit again :)");
        }
        else 
            throw new BookDetailsNotCorrectException();
        }

    void showAvailableBooks(){
        /*Shows books available in the library */
        if (booksAvailable.size()>0){
            System.out.println("Books available :- ");
            for (int i = 0;i<booksAvailable.size();i++) {
                System.out.println((i+1)+") "+booksAvailable.get(i)+"\t\t  - "+authorNames.get(i));
            }
        }
        else
            System.out.println("No book is available !");
    }

    void issueBook(String book,String auth,String userName)throws BookNotFoundException{
        /*Issues book to the user */
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = ldt.format(formatter);
        
        // checking whether the book is available or not
        boolean isBookThere = false;
        for (int i = 0;i<booksAvailable.size();i++){
            if (booksAvailable.get(i).equalsIgnoreCase(book)){
                isBookThere = true;
                authorNames.remove(i);
                break;
            }
        }
        if (isBookThere){
            booksAvailable.remove(book);
            booksIssued.add(book);
            userNames.add(userName);
            issueDates.add(date);

            System.out.println("Book name - "+book+"\nAuthor - "+auth);
            System.out.println("Issued to - "+userName+"\nIssued on - "+date);
            System.out.println("Please return the book within time or a fine of 500/- will be charged.");
        }
        else
           throw new BookNotFoundException();
    }
}


