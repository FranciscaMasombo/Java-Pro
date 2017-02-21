public class LibrarySystem
{
    public static void main(String args[])
    {
       char option;
       
       System.out.println("What is the maximum number of books that can be stored in your library? ");
       Library bookWorm = new Library(EasyScanner.nextInt());
       
       do
       {
          System.out.println("\nThe Bookworm Library");
          System.out.println(" 1. Enter a new book");
          System.out.println(" 2. List all books");
          System.out.println(" 3. Search menu");
          System.out.println(" 4. Remove a book");
          System.out.println(" 5. Loan a book");
          System.out.println(" 6. Return a book");          
          System.out.println(" 0. Quit");
          System.out.println();
          System.out.print("Enter option [0-6]: ");

          // get option
          option = EasyScanner.nextChar();
          System.out.println();

          // process menu options
          switch (option)
          {
             case '1': addBook(bookWorm);
                       break;
             case '2': listBook(bookWorm);
                       break;
             case '3': searchMenu(bookWorm);
                       break;
             case '4': removeBook(bookWorm);
                       break;
             case '5': loanBook(bookWorm);
                       break;
             case '6': returnBook(bookWorm);
                       break;
             case '0': break;
             default : System.out.println("Invalid entry");
          }
        }while (option != '0');
    } 
    
    private static void searchMenu(Library bookWorm)
    {
       char option = ' ';
       do
       {
          System.out.println("\nSearch for books by:");
          System.out.println("\t 1. ISBN");
          System.out.println("\t 2. Author");
          System.out.println("\t 3. Title keyword");
          System.out.println("\t 4. Minimum cost price");
          System.out.println("\t 0. Return to main menu");
          System.out.println();
          System.out.print("Enter option [0-4]: ");

          // get option
          option = EasyScanner.nextChar();
          System.out.println();

          // process menu options
          switch (option)
          {
             case '1': searchBook(bookWorm);
                       break;
             case '2': searchBookAuthor(bookWorm);
                       break;
             case '3': searchBookTitle(bookWorm);
                       break;
             case '4': searchBookCostPrice(bookWorm);
                       break;
             case '0': break;
             default : System.out.println("Invalid entry");
          }
        }while (option != '0');       
    }
       
    // add a book
    private static void addBook(Library bookWorm)
    {
        // get details from user
        System.out.println("Enter the new book details.");
        System.out.print  ("    ISBN number: ");
        String ISBN = EasyScanner.nextString();
        System.out.print  ("    Author:      ");
        String author = EasyScanner.nextString();
        System.out.print  ("    Title:       ");
        String title = EasyScanner.nextString();
        System.out.print  ("    Cost:        ");
        double cost = EasyScanner.nextDouble();

        Book book = new Book(ISBN, author, title, cost);

        // add book to the array
        boolean ok = bookWorm.add(book);
        if (!ok)           //if(ok == false)
        {
            System.out.println("The array is full - your book has not been added");
        }
        else
        {
            System.out.println("Your book has been created");
        }
    }     
    
    private static void listBook(Library bookWorm)
    {
        String listBooks = bookWorm.list();
        if (listBooks.equals(""))
        {
            System.out.println("The library has no books");
        }
        else
        {
            System.out.println("The books that are in the library are:");
            System.out.println(listBooks);
        }   
    }

    private static void searchBook(Library bookWorm)
    {
       // get details from user
       System.out.print("Enter the ISBN number: ");
       String ISBN = EasyScanner.nextString();
       Book book = bookWorm.getItem(ISBN);
   
       if (book == null)
       {
          System.out.println("No book with this ISBN exists in the library.");
       }
       else
       {
          System.out.println(book);
       }
    }

    private static void searchBookAuthor(Library bookWorm)
    {
       // get details from user
       System.out.print("Enter the full author name: ");
       String author = EasyScanner.nextString();
       String books = bookWorm.listByAuthor(author);
   
       if (books.equals(""))
       {
          System.out.println("No books with this author exists in the library.");
       }
       else
       {
          System.out.println(books);
       }
    }

    private static void searchBookTitle(Library bookWorm)
    {
       // get details from user
       System.out.print("Enter the keyword that appears in the title: ");
       String title = EasyScanner.nextString();
       String books = bookWorm.listByTitleKeyword(title);
   
       if (books.equals(""))
       {
          System.out.println("No books with this keyword in the title are in the library.");
       }
       else
       {
          System.out.println(books);
       }
    }
    
    private static void searchBookCostPrice(Library bookWorm)
    {
       // get details from user
       System.out.print("Enter the minimum cost price for the search: ");
       double minCost = EasyScanner.nextDouble();
       String books = bookWorm.listByMinimumCost(minCost);
   
       if (books.equals(""))
       {
          System.out.println("No books costing the same or more than " + minCost + " are in the library");
       }
       else
       {
          System.out.println(books);
       }
    }
    
    
   private static void removeBook(Library bookWorm)
   {
      System.out.print("Enter the ISBN number: ");
      String ISBN = EasyScanner.nextString();
    
      boolean ok = bookWorm.remove(ISBN);
      if (!ok)
      {
         System.out.println("No book with this ISBN exists in the library.");
      }
      else
      {
        System.out.println("Book removed.");
      }
   }

   private static void loanBook(Library bookWorm)
   {
       // get details from user
       System.out.print("Enter the ISBN number: ");
       String ISBN = EasyScanner.nextString();
       Book book = bookWorm.getItem(ISBN);
   
       if (book == null)
       {
          System.out.println("No book with this ISBN exists in the library.");
       }
       else
       {
          if (book.getLoanStatus())
          {
              System.out.println("The book is already on loan.");
          }
          else
          {
              System.out.println("The book is available for loan and is now set to 'on loan'");
              book.setLoanStatus(true);
          }
       }
   }

   private static void returnBook(Library bookWorm)
   {
       // get details from user
       System.out.print("Enter the ISBN number: ");
       String ISBN = EasyScanner.nextString();
       Book book = bookWorm.getItem(ISBN);
   
       if (book == null)
       {
          System.out.println("No book with this ISBN exists in the library.");
       }
       else
       {
          if (book.getLoanStatus())
          {
              System.out.println("The book is now returned and back in the library.");
              book.setLoanStatus(false);
          }
          else
          {
              System.out.println("The book is already in the library.");
          }
       }
   }

   
} 