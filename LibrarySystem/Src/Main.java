package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 📘 Library Management System ===");

        while (true) {
            System.out.println("\n1️⃣ Add Book");
            System.out.println("2️⃣ Add Member");
            System.out.println("3️⃣ Issue Book");
            System.out.println("4️⃣ Return Book");
            System.out.println("5️⃣ Show Inventory");
            System.out.println("6️⃣ Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(id, title, author));
                        System.out.println("✅ Book added!");
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        String memberId = sc.nextLine();
                        System.out.print("Enter Member Name: ");
                        String name = sc.nextLine();
                        library.addMember(new Member(memberId, name));
                        System.out.println("✅ Member added!");
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        String issueBookId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String issueMemberId = sc.nextLine();
                        library.issueBook(issueBookId, issueMemberId);
                        System.out.println("📖 Book issued!");
                        break;

                    case 4:
                        System.out.print("Enter Book ID: ");
                        String returnBookId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String returnMemberId = sc.nextLine();
                        System.out.print("Enter Days Late: ");
                        int daysLate = sc.nextInt();
                        library.returnBook(returnBookId, returnMemberId, daysLate);
                        break;

                    case 5:
                        library.showInventory();
                        break;

                    case 6:
                        System.out.println("👋 Exiting... Goodbye!");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("❌ Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }
}
