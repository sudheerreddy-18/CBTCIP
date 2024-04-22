import java.util.*;
class Book 
{
    String title;
    String author;
    String category;
    boolean available;
    public Book(String title, String author, String category) 
    {
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }
    public String getTitle() 
    {
        return title;
    }
    public String getAuthor() 
    {
        return author;
    }
    public String getCategory() 
    {
        return category;
    }
    public boolean isAvailable() 
    {
        return available;
    }
    public void setAvailable(boolean available) 
    {
        this.available = available;
    }
}
class Member 
{
    String name;
    String email;
    public Member(String name, String email) 
    {
        this.name = name;
        this.email = email;
    }
    public String getName() 
    {
        return name;
    }
    public String getEmail() 
    {
        return email;
    }
}
class Library 
{
    List<Book> books;
    List<Member> members;
    public Library() 
    {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    public void addBook(Book book) 
    {
        books.add(book);
    }
    public void addMember(Member member) 
    {
        members.add(member);
    }
    public void displayBooks() 
    {
        System.out.println("Library Books:");
        for (Book book : books) 
        {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Category: " + book.getCategory() + ", Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
        }
    }
    public Book findBookByTitle(String title) 
    {
        for (Book book : books) 
        {
            if (book.getTitle().equalsIgnoreCase(title)) 
            {
                return book;
            }
        }
        return null;
    }
    public void issueBook(Member member, Book book) 
    {
        if (book.isAvailable()) 
        {
            System.out.println("Book '" + book.getTitle() + "' issued to " + member.getName());
            book.setAvailable(false);
        } 
        else 
        {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is currently not available.");
        }
    }
    public void returnBook(Member member, Book book) 
    {
        if (!book.isAvailable()) 
        {
            System.out.println("Book '" + book.getTitle() + "' returned by " + member.getName());
            book.setAvailable(true);
        } 
        else 
        {
            System.out.println("This book is already available in the library.");
        }
    }
}
public class DigitalLibraryManagement 
{
    public static Member findMemberByName(Library library, String name) 
    {
        for (Member member : library.members) {
            if (member.getName().equalsIgnoreCase(name)) 
            {
                return member;
            }
        }
        return null;
    }
    public static void main(String[] args) 
    {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        library.addBook(new Book("The Guide", "R.K. Narayan", "Category1"));
        library.addBook(new Book("The Great Indian Novel", "Shashi Tharoor", "Category2"));
        library.addBook(new Book("Half Girlfriend", "Chetan Bhagat", "Category1"));
        library.addBook(new Book("The Shadow Lines ", "Amitav Ghosh", "Category2"));
        library.addMember(new Member("Sudheer", "sudheer@gmail.com"));
        library.addMember(new Member("Arun", "arun@gmail.com"));
        library.addMember(new Member("Raghu", "raghu@gmail.com"));
        System.out.println("Welcome to Digital Library Management System");
        boolean exit = false;
        while (!exit) 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String memberName = sc.nextLine();
                    Member member = findMemberByName(library, memberName);
                    if (member == null) 
                    {
                        System.out.println("Member not found.");
                        break;
                    }
                    System.out.print("Enter book title: ");
                    String bookTitle = sc.nextLine();
                    Book bookToIssue = library.findBookByTitle(bookTitle);
                    if (bookToIssue == null) 
                    {
                        System.out.println("Book not found.");
                        break;
                    }
                    library.issueBook(member, bookToIssue);
                    break;
                case 3:
                    System.out.print("Enter member name: ");
                    memberName = sc.nextLine();
                    member = findMemberByName(library, memberName);
                    if (member == null) 
                    {
                        System.out.println("Member not found.");
                        break;
                    }
                    System.out.print("Enter book title: ");
                    bookTitle = sc.nextLine();
                    Book bookToReturn = library.findBookByTitle(bookTitle);
                    if (bookToReturn == null) 
                    {
                        System.out.println("Book not found.");
                        break;
                    }
                    library.returnBook(member, bookToReturn);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        sc.close();
    }
}

