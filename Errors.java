class BookNotFoundException extends Exception{
    @Override
    public String toString() {
        return "BookNotFoundException";
    }
    @Override
    public String getMessage() {
        return toString()+": The book which you are looking for is currently unavailable\n\tSorry for the inconvenience :(";
    }
}

class BookDetailsNotCorrectException extends Exception{
    @Override
    public String toString() {
        return "BookDetailsNotCorrectException";
    }
    @Override
    public String getMessage() {
        return toString()+": Could not return the book because the details which you have entered is incorrect.\n\tPlease check and try again." ;
    }         
}
