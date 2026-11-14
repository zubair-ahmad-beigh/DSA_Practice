package machineCoding;

import java.util.*;

public class libraryMang {
    static class Book{
        int id;
        String title;
        String author;
        boolean available;
        Book(int id,String title,String author){
            this.id=id;
            this.title=title;
            this.author=author;
            this .available=true;
        }
    }
    static class User{
        int id;
        String name;
        Set<Integer>borrowedBooks=new HashSet<>();
        User(int id,String name){
            this.id=id;
            this .name=name;
        }
    }
    static Map<Integer,Book> books=new HashMap<>();
    static Map<Integer,User> users=new HashMap<>();
    static Scanner sc=new Scanner(System.in);
    static void addBook(){
        System.out.println("Enter Book ID:");
        int id=sc.nextInt();
        sc.nextLine();
        if(books.containsKey(id)){
            System.out.println("Book ID already exists!");
            return;
        }
        System.out.println("Enter Title: ");
        String title=sc.nextLine();
        System.out.println("Enter Author: ");
        String author=sc.nextLine();
        books.put(id,new Book(id,title,author));
        System.out.println("Book added successfully!");
    }
    static void registerUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (users.containsKey(id)) {
            System.out.println("User already exists!");
            return;
        }

        System.out.print("Enter User Name: ");
        String name = sc.nextLine();

        users.put(id, new User(id, name));

        System.out.println("User registered successfully!");
    }

    static void issueBook(){
        System.out.println("Enter Book ID: ");
        int bookId=sc.nextInt();
        System.out.println("Enter User ID: ");
        int usedId=sc.nextInt();
        Book book=books.get(bookId);
        User user=users.get(usedId);
        if(book==null || user==null){
            System.out.println("Book or User not found!");
            return;
        }
        if(!book.available){
            System.out.println("Book is not available!");
            return;
        }
        if(user.borrowedBooks.size()>=3){
            System.out.println("Borrowing limit reached!");
            return;
        }
        book.available=false;
        user.borrowedBooks.add(bookId);
        System.out.println("Book issued successfully");
    }
    static void returnBook(){
        System.out.println("Enter Book ID: ");
        int bookId= sc.nextInt();
        System.out.println("Enter User ID: ");
        int userId= sc.nextInt();
        Book book=books.get(bookId);
        User user=users.get(userId);
        if(book==null || user==null){
            System.out.println("Book or User not found!");
            return;
        }
        if(!user.borrowedBooks.remove(bookId)){
            System.out.println("This user has not borrowed this book!");
            return;
        }
        book.available=true;
        System.out.println("Book returned successfully!");
    }
    static void searchBook(){
        sc.nextLine();
        System.out.println("Enter book title: ");
        String title=sc.nextLine();
        boolean found=false;
        for (Book book:books.values()){
            if(book.title.equalsIgnoreCase(title)){
                System.out.println(book.id+"|"+
                        book.title+"|"+
                        book.author+"|"+
                        (book.available?"Available":"Issued"));
                found=true;
            }
        }
        if(!found){
            System.out.println("Book not found!");
        }
    }
    static void displayBooks(){
        for (Book book:books.values()){
            if(book.available){
                System.out.println(book.id+"|"+
                        book.title+"|"+
                        book.author);
            }
        }
    }
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Display Available Books");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    registerUser();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    searchBook();
                    break;

                case 6:
                    displayBooks();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


}
