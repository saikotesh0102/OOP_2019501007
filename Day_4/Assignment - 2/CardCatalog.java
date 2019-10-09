import java.util.*;

public class CardCatalog {
    int index ;
    Card [] Catalog;

    public CardCatalog(){
        Catalog = new Card[10];
        index = 0;
    }

    public Card getBookTitle(String title){
        for(int i=0; i < Catalog.length; i++) {
            if(Catalog[i].getTitleOfTheBook().equals(title)) {
                return Catalog[i];
            }
        }return null;
    }

    public Card getBookAuthor(String author){
        for(int i=0; i < Catalog.length; i++) {
            if(Catalog[i].getAuthorOfTheBook().equals(author)) {
                return Catalog[i];
            }
        }return null;
    }

    public Card getBookSubject(String subject){
        for(int i=0; i < Catalog.length; i++) {
            if(Catalog[i].getSubjectOfTheBook().equals(subject)) {
                return Catalog[i];
            }
        }return null;
    }

    public void addCard(Card addition){
        Catalog[index] = addition;
        index++;
    }

    public void removeTitle(String removeTitle){
        for(int i = 0; i < Catalog.length; i++){
            if(Catalog[i].getTitleOfTheBook().equals(removeTitle)){
                Catalog[i] = null;
            }
       }
    }

    public void printCatalog(){
        for(int i = 0; i < Catalog.length;i++){
            if(this.Catalog[i] != null){
                System.out.println(Catalog[i]);
            }
        }
    }
    public static void main(String[] args) {
        Card firstCard = new Card();
        firstCard.setAuthorOfTheBook("J.K.Rowling");
        firstCard.setTitleOfTheBook("Harry Potter");
        firstCard.setSubjectOfTheBook("Fiction");

        Card secondCard = new Card();
        secondCard.setAuthorOfTheBook("George R.R Martin");
        secondCard.setTitleOfTheBook("A Song of Ice and Fire");
        secondCard.setSubjectOfTheBook("Fantasy");

        Card thirdCard = new Card();
        thirdCard.setAuthorOfTheBook("Stephen Hawking");
        thirdCard.setTitleOfTheBook("A Brief History of Time");
        thirdCard.setSubjectOfTheBook("Science");

        CardCatalog addCard = new CardCatalog();
        addCard.addCard(firstCard);
        addCard.addCard(secondCard);
        addCard.addCard(thirdCard);
        addCard.printCatalog();
    }
}