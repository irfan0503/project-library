package src;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Library {
    private HashMap<String, Book> inventory;
    private HashMap<String, Member> members;

    public Library() {
        inventory = new HashMap<>();
        members = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getId(), book);
        logOperation("Book Added: " + book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        logOperation("Member Added: " + member);
    }

    public void issueBook(String bookId, String memberId) throws BookNotAvailableException {
        Book book = inventory.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            throw new BookNotAvailableException("Book or Member not found!");
        }

        if (book.isIssued()) {
            throw new BookNotAvailableException("Book already issued!");
        }

        book.setIssued(true);
        member.borrowBook(bookId);
        logOperation("Book Issued: " + book.getTitle() + " to " + member.getName());
    }

    public void returnBook(String bookId, String memberId, int daysLate) throws InvalidReturnException {
        Book book = inventory.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null || !book.isIssued() || !member.getBorrowedBookIds().contains(bookId)) {
            throw new InvalidReturnException("Invalid return attempt!");
        }

        book.setIssued(false);
        member.returnBook(bookId);
        double fine = daysLate * 2.0;
        logOperation("Book Returned: " + book.getTitle() + " by " + member.getName() + " | Fine: ₹" + fine);
        System.out.println("✅ Book returned successfully! Fine: ₹" + fine);
    }

    public void showInventory() {
        System.out.println("\n📚 Library Inventory:");
        for (Book book : inventory.values()) {
            System.out.println(book);
        }
    }

    public void logOperation(String message) {
        try (FileWriter writer = new FileWriter("logs/library_log.txt", true)) {
            writer.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            System.out.println("⚠️ Logging failed: " + e.getMessage());
        }
    }
}
