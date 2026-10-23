
package com.practice;

import com.practice.repository.ItemRepository;
import com.practice.service.ItemService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ItemRepository repository = new ItemRepository();
        ItemService service = new ItemService(repository);

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Campus Lost-and-Found ===");

        System.out.print("Enter item ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item description: ");
        String description = scanner.nextLine();

        Item item = new Item(id, name, description);

        try {
            service.registerItem(item);

            System.out.println("\nItem registered successfully!");
            System.out.println("ID: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());

        } catch (IllegalArgumentException exception) {
            System.out.println(
                "Could not register item: " + exception.getMessage()
            );
        }

        scanner.close();
    }
}
