import java.util.ArrayList;
import java.util.Scanner;

public class grocery {

    static Scanner input = new Scanner(System.in);
    static ArrayList<item> inventory = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Grocery Management System!");
            System.out.println("1. Add item to inventory");
            System.out.println("2. Remove item from inventory");
            System.out.println("3. View inventory");
            System.out.println("4. Exit");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    viewInventory();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addItem() {
        System.out.println("Enter item name:");
        String name = input.next();
        System.out.println("Enter item quantity:");
        int quantity = input.nextInt();
        System.out.println("Enter item price:");
        double price = input.nextDouble();

        item newItem = new item(name, quantity, price);
        inventory.add(newItem);

        System.out.println("Item added to inventory.");
    }

    static void removeItem() {
        System.out.println("Enter item name:");
        String name = input.next();

        for (item item : inventory) {
            if (item.getName().equals(name)) {
                inventory.remove(item);
                System.out.println("Item removed from inventory.");
                return;
            }
        }


        System.out.println("Item not found in inventory.");
    }

    static void viewInventory() {
        System.out.println("Inventory:");
        for (item item : inventory) {
            System.out.println(item.getName() + " (" + item.getQuantity() + ") - $" + item.getPrice());
        }
    }

}
