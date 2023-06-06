package Project1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Did you want to use an ArrayBag or LinkedObjectBag?");
        BagInterface<Item> bag = null;

        int j = 0;
        while (j == 0) {
            String bagType = keyboard.nextLine();

            if (bagType.equalsIgnoreCase("arraybag")) {
                bag = new BagArray<Item>();
                j++;
            } else if (bagType.equalsIgnoreCase("linkedobjectbag")) {
                bag = new BagLinkedObjects<Item>();
                j++;
            } else {
                System.out.println("Entered Bag Type is not valid. Please try again.");
            }
        }

        ShoppingCart cart = new ShoppingCart(bag);

        int i = 0;
        while (i == 0) {

            System.out.println("Welcome to your shopping cart, what do you want to do?");
            System.out.println("1 - Add Item");
            System.out.println("2 - Remove Random Item");
            System.out.println("3 - Remove Specific Item");
            System.out.println("4 - Get Number Of Items In Cart");
            System.out.println("5 - Abandon Cart");
            System.out.println("6 - Check Out");

            int option = keyboard.nextInt();

            if (option == 1) {
                System.out.print("Enter the item name: ");
                String name = keyboard.next();

                System.out.print("Enter the item price: ");
                double price = Double.parseDouble(keyboard.next());

                Item item = new Item(name, price);
                cart.addItem(item);

            } else if (option == 2) {
                System.out.println("The removed item was: " + cart.removeItem());

            } else if (option == 3) {
                System.out.println("Enter the item name of the item you would like to remove: ");
                String name = keyboard.nextLine();
                System.out.println("Enter the item price of the item you would like to remove: ");
                double price = Double.parseDouble(keyboard.nextLine());
                Item item = new Item(name, price);

                if (cart.removeItem(item)) {
                    System.out.println("Removed successfully");
                } else {
                    System.out.println("Could not find that item in the cart");
                }

            } else if (option == 4) {
                System.out.printf("You have %d items in your cart%n", cart.getNumberOfItems());

            } else if (option == 5) {
                cart.abandon();
                System.out.println("You have abandoned your cart");

            } else if (option == 6) {
                System.out.println(cart.receipt());
                i++;
            }
        }
    }
}