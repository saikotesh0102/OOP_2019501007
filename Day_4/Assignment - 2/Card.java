public class Card {
    private String titleOfTheBook;
    private String authorOfTheBook;
    private String subjectOfTheBook;

    public Card() {

    }
    
    public Card(final String titleOfTheBook, final String authorOftheBook, final String subjectOfTheBook) {
        this.titleOfTheBook = titleOfTheBook;
        this.authorOfTheBook = authorOftheBook;
        this.subjectOfTheBook = subjectOfTheBook;
    }

    public void setTitleOfTheBook(final String titleOftheBook) {
        this.titleOfTheBook = titleOftheBook;
    }

    public String getTitleOfTheBook() {
        return this.titleOfTheBook;
    }

    public void setAuthorOfTheBook(final String authorOftheBook) {
        this.authorOfTheBook = authorOftheBook;
    }

    public String getAuthorOfTheBook() {
        return this.authorOfTheBook;
    }

    public void setSubjectOfTheBook(final String subjectOftheBook) {
        this.subjectOfTheBook = subjectOftheBook;
    }

    public String getSubjectOfTheBook() {
        return this.subjectOfTheBook;
    }

    public String toString() {
        String output = "Name = " + this.titleOfTheBook + "," + " Author = "
        + this.authorOfTheBook + "," + " Subject = " + this.subjectOfTheBook ;
        return output;
    }
}