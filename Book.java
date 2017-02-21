public class Book
{
    
    private String ISBN;
    private String author;          
    private String title;           
    private double cost;               
    private boolean loanStatus;           
    
   public Book (String ISBN, String author, String title, double cost)
    {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.cost = cost;
        loanStatus = false;
    }

    public String getISBN()
    {
        return ISBN;
    }
    
    public String getAuthor()
    {
        return author;
    }
     
    public String getTitle()
    {
        return title;
    }
     
    public double getCost()
    {
        return cost;
    }
   
    public boolean getLoanStatus()
    {
        return loanStatus;
    }   

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
   
    public void setCost(double cost)
    {
        this.cost = cost;
    }
   
    public void setLoanStatus(boolean loanStatus)
    {
         this.loanStatus = loanStatus;
    }    
    
    public String toString()
    {
        String loanStatusString = "";
        if (loanStatus)  
            loanStatusString = "on loan";
        else             
            loanStatusString = "available";
           
        return ("ISBN: " + ISBN +
                ", title: " + title + 
                ", author: " + author + 
                ", cost: €" + cost + 
                ", loan Status: " + loanStatusString);
    }
}