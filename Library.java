import java.util.ArrayList;
class Library {
  ArrayList<Book> books = new ArrayList<>();
  boolean checkOutByTitle(String title) {
    for (Book book: books) {
    if (book.title.toLowerCase().contains(title.toLowerCase())) {
        if (book.amountInStock>0) {
          book.amountInStock--;
          System.out.println(book.title+" checked out.");
          return true;
        }
      }
    }
    System.out.println(title+" could not be checked out.");
    return false;
  }
  void returnBookByTitle(String title) {
    for (Book book: books) {
    if (book.title.toLowerCase().contains(title.toLowerCase())) {
        if (book.amountInStock<book.totalAmount) {
          book.amountInStock++;
          System.out.println(title+" returned.");
        }
      }
    }
  }

  void removeDamagedBook(String title) {
    for (Book book: books) {
    if (book.title.toLowerCase().contains(title.toLowerCase())) {
          book.totalAmount--;
          System.out.println("1 copy of "+title+" has been removed.");

      }
    }
  }
  void addNewBook(String title) {
    for (Book book: books) {
    if (book.title.toLowerCase().contains(title.toLowerCase())) {
          book.amountInStock++;
          book.totalAmount++;
          System.out.println("1 copy of "+title+" has been added.");

      }
    }
  }

  void listAllBooks() {
    for (Book book: books) {
      System.out.println(book.title+" By "+book.author+" "+book.amountInStock+"/"+book.totalAmount+" in stock");
    }}

    void searchByTitle(String title){
      for (Book book: books) {
        if (book.title.toLowerCase().contains(title.toLowerCase())) {
          System.out.println(book.title+" By "+book.author+" "+book.amountInStock+"/"+book.totalAmount+" in stock");
        }}}

        void searchByAuthor(String author){
          for (Book book: books) {
            if (book.author.toLowerCase().contains(author.toLowerCase())) {
              System.out.println(book.title+" By "+book.author+" "+book.amountInStock+"/"+book.totalAmount+" in stock");
            }}}

            public static void main(String[] args) {
              Library library = new Library();
              //add initial books
              Book book0 = new Book("1984", "George Orwell", 2);
              library.books.add(book0);
              Book  book1 = new Book("The Hobbit", "J.R.R. Tolkien", 2);
              library.books.add(book1);
              Book  book2 = new Book("The Lord of The Rings", "J.R.R. Tolkien", 1);
              library.books.add(book2);
              Book  book3 = new Book("Burn Book", "Kara Swisher", 1);
              library.books.add(book3);
              //check out book in stock
              library.listAllBooks();
              library.checkOutByTitle("1984");
              library.searchByTitle("1984");
              library.returnBookByTitle("1984");
              System.out.println();
              //try to check out book not in stock
              library.checkOutByTitle("1984");
              library.checkOutByTitle("1984");
              library.searchByTitle("1984");
              library.checkOutByTitle("1984");
              library.searchByTitle("1984");
              System.out.println();
              //book returned
              library.returnBookByTitle("1984");
              library.searchByTitle("1984");
              System.out.println();
              //Scenario: Library got more copies of a book
              library.addNewBook("1984");
              library.searchByTitle("1984");
              System.out.println();
              //Scenario: one book was damaged (while checked out)
              library.removeDamagedBook("1984");
              library.searchByTitle("1984");
              System.out.println();

              //Scenario: book title not entered exactly
              library.searchByTitle("the lord of the rings");
              System.out.println();
              //Search by Author
              library.searchByAuthor("J.R.R. Tolkien");
              System.out.println();


            }
          }
          class Book {
            String title;
            String author;
            int amountInStock;
            int totalAmount;
            Book(String title, String author, int totalAmount) {
              this.title=title;
              this.author=author;
              this.totalAmount=totalAmount;
              this.amountInStock=totalAmount;
            }
          }
