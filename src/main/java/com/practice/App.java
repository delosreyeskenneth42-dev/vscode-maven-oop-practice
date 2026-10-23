
package com.practice;

import com.practice.repository.ItemRepository;
import com.practice.service.ItemService;

import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("""
                    1. Register Item
                    2. View All Items
                    0. Exit
                """);
    }

    public static int menuChoices() {
        System.out.print("Choose: ");

        try {
            int val = Integer.parseInt(input.nextLine());
            return val;
        } catch (NumberFormatException e) {
            System.out.println("Only input Integers!");
            return -1;
        }
    }

    public static void main(String[] args) {

        ItemRepository repository = new ItemRepository();
        ItemService service = new ItemService(repository);

        int choice;
        do {
            System.out.println("=== Campus Lost-and-Found ===");
            printMenu();
            choice = menuChoices();

            switch (choice) {
                case 1:
                    System.out.print("Enter item ID: ");
                    int id = Integer.parseInt(input.nextLine());

                    System.out.print("Enter item name: ");
                    String name = input.nextLine();

                    System.out.print("Enter item description: ");
                    String description = input.nextLine();

                    Item item = new Item(id, name, description);

                    try {
                        service.registerItem(item);

                        System.out.println("\nItem registered successfully!");
                        System.out.println("ID: " + item.getId());
                        System.out.println("Name: " + item.getName());
                        System.out.println("Description: " + item.getDescription());

                    } catch (IllegalArgumentException exception) {
                        System.out.println(
                                "Could not register item: " + exception.getMessage());
                    }
                    break;
                case 2:
                    List<Item> items = service.getAllItems();

                    for (Item i : items) {
                        System.out.println("ID: " + i.getId());
                        System.out.println("Name: " + i.getName());
                        System.out.println("Description: " + i.getDescription());
                        System.out.println("-------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye! See you again!");
                    break;
                default:
                    System.out.println("Wrong input!");
            }

        } while (choice != 0);

        input.close();
    }
}
