/**
 * Solution to Practical 9
 * 
 * @author WIT 
 * @version 1.0
 */
public class Library
{
    //attributes (instance variables)
    private Book[] books;
    private int total;
    
    //Constructors
    public Library (int maxNumBooks)
    {
        books = new Book[maxNumBooks];
        total=0;
    }

    //accessor 
    public int getTotal()
    {
        return total;
    }
    
    // check if the list is full
    public boolean isFull()
    {
       if (total == books.length)
       {
          return true; // list is full
       }
       else
       {
          return false; // list is empty
       }
    }

    // check if the list is empty
    public boolean isEmpty()
    {
       if (total == 0)
       {
          return true; // list is empty
       }
       else
       {
          return false; // list is not empty
       }
    }
    
    //add a book object to the array, providing there is space.
    public boolean add(Book book)
    {
        if (!isFull())
        {
            books[total] = book;
            total++;
            return true;
        }
        else 
          return false;
    }
    
    //return a string containing all the books in the array.
    public String list()
    {
        String tempString = "";
        for (int i = 0; i < total; i++)
        {
            Book tempBook = books[i];
            tempString = tempString 
                       + tempBook.toString()
                       + "\n";
        }
        return tempString;
    }
    
    //return a string containing all the books in the array that were written by a specific author.
    public String listByAuthor(String author)
    {
        String tempString = "";
        author = author.toLowerCase();
        for (int i = 0; i < total; i++)
        {
            if (books[i].getAuthor().toLowerCase().equals(author))
            {
               Book tempBook = books[i];
               tempString = tempString 
                          + tempBook.toString()
                          + "\n";
            }
        }
        return tempString;
    }
    
    //return a string containing all the books in the array that have the passed keyword in the title.
    public String listByTitleKeyword(String keyword)
    {
        String tempString = "";
        keyword = keyword.toLowerCase();
        for (int i = 0; i < total; i++)
        {
            if (books[i].getTitle().toLowerCase().contains(keyword))
            {
               Book tempBook = books[i];
               tempString = tempString 
                          + tempBook.toString()
                          + "\n";
            }
        }
        return tempString;
    }
    
    //return a string containing all the books in the array that cost the price (or above) passed as a parameter
    public String listByMinimumCost(double minCost)
    {
        String tempString = "";
        for (int i = 0; i < total; i++)
        {
            if (books[i].getCost() >= minCost)
            {
               Book tempBook = books[i];
               tempString = tempString 
                          + tempBook.toString()
                          + "\n";
            }
        }
        return tempString;
    }
    
    private int search (String ISBN)
    {
        for (int i = 0; i < total; i++)
        {
            if (books[i].getISBN().equals(ISBN))
            {
                return i;
            }
        }
        return -999;
    }
    
    public Book getItem(String ISBN)
    {
        int index = search(ISBN);
        if (index == -999)
        {
            return null;
        }
        else
        {
            return books[index];
        }
    }
    
    public boolean remove(String ISBN)
    {
        int index = search(ISBN);
        if (index == -999)
        {
            return false;
        }
        else 
        {
            for (int i = index; i < total - 1; i++)
            {
                books[index] = books[index+1];
            }
            total--;
            return true;
        }
    }   
}