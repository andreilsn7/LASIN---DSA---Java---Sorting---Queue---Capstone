import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Food Ordering and Preparation Queue System
 * Procedural Java program: no custom classes and no OOP design.
 * Sorting algorithms are implemented manually.
 */
public class Main {
    static Scanner input = new Scanner(System.in);

    // Parallel ArrayLists: the same index refers to the same order.
    static ArrayList<Integer> orderNumbers = new ArrayList<Integer>();
    static ArrayList<String> customerNames = new ArrayList<String>();
    static ArrayList<String> foodItems = new ArrayList<String>();
    static ArrayList<Integer> quantities = new ArrayList<Integer>();
    static ArrayList<Double> unitPrices = new ArrayList<Double>();
    static ArrayList<Double> totalPrices = new ArrayList<Double>();
    static ArrayList<String> orderStatuses = new ArrayList<String>();

    // Queue stores order numbers, so sorting records does not change FIFO order.
    static Queue<Integer> preparationQueue = new LinkedList<Integer>();
    static int nextOrderNumber = 1001;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("==========================================");
        System.out.println(" FOOD ORDERING AND PREPARATION QUEUE");
        System.out.println("==========================================");

        while (running) {
            displayMenu();
            int choice = readInt("Choose an option: ", 1, 9);

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    displayAllOrders();
                    break;
                case 3:
                    searchOrder();
                    break;
                case 4:
                    displayQueue();
                    break;
                case 5:
                    peekNextOrder();
                    break;
                case 6:
                    processNextOrder();
                    break;
                case 7:
                    bubbleSortByOrderNumber();
                    break;
                case 8:
                    selectionSortByTotalPrice();
                    break;
                case 9:
                    running = false;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    // readInt limits the input to 1-9.
                    System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();

        }

    static void displayMenu() {
        System.out.println("\n--------------- MAIN MENU ---------------");
        System.out.println("1. Add a new food order");
        System.out.println("2. Display all order records");
        System.out.println("3. Search order by order number");
        System.out.println("4. Display preparation queue");
        System.out.println("5. Peek at the next order");
        System.out.println("6. Process the next order");
        System.out.println("7. Sort records by order number (Bubble Sort)");
        System.out.println("8. Sort records by total price (Selection Sort)");
        System.out.println("9. Exit");
        System.out.println("-----------------------------------------");
    }

    static void addOrder() {
        System.out.println("\n--- ADD NEW ORDER ---");
        String customer = readNonEmptyText("Customer name: ");
        String food = readNonEmptyText("Food item: ");
        int quantity = readInt("Quantity (1 or more): ", 1, 100000);
        double unitPrice = readDouble("Price per item (0.01 or more): ", 0.01, 1000000.0);
        double total = quantity * unitPrice;

        int orderNumber = nextOrderNumber;
        nextOrderNumber++;

        orderNumbers.add(orderNumber);
        customerNames.add(customer);
        foodItems.add(food);
        quantities.add(quantity);
        unitPrices.add(unitPrice);
        totalPrices.add(total);
        orderStatuses.add("Waiting");

        // New orders enter the back of the queue (FIFO).
        preparationQueue.offer(orderNumber);

        System.out.println("\nOrder added successfully!");
        System.out.println("Order number: " + orderNumber);
        System.out.println("Customer: " + customer);
        System.out.println("Food: " + food);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total price: %.2f%n", total);
        System.out.println("Status: Waiting for preparation");
    }

    static void displayAllOrders() {
        System.out.println("\n--- ALL ORDER RECORDS ---");
        if (orderNumbers.isEmpty()) {
            System.out.println("No order records have been added yet.");
            return;
        }

        System.out.printf("%-8s %-18s %-18s %-8s %-12s %-12s %-12s%n",
                "Order#", "Customer", "Food", "Qty", "Unit Price", "Total", "Status");
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < orderNumbers.size(); i++) {
            printOrderAtIndex(i);
        }
    }

    static void printOrderAtIndex(int i) {
        System.out.printf("%-8d %-18s %-18s %-8d %-12.2f %-12.2f %-12s%n",
                orderNumbers.get(i),
                shorten(customerNames.get(i), 17),
                shorten(foodItems.get(i), 17),
                quantities.get(i),
                unitPrices.get(i),
                totalPrices.get(i),
                orderStatuses.get(i));
    }

     static String shorten(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength - 3) + "...";
    }

    static void searchOrder() {
        System.out.println("\n--- SEARCH ORDER ---");
        if (orderNumbers.isEmpty()) {
            System.out.println("There are no orders to search.");
            return;
        }

        int target = readInt("Enter order number: ", 1, Integer.MAX_VALUE);
        int index = findOrderIndex(target);

        if (index == -1) {
            System.out.println("Order number " + target + " was not found.");
        } else {
            System.out.println("Order found:");
            System.out.printf("%-8s %-18s %-18s %-8s %-12s %-12s %-12s%n",
                    "Order#", "Customer", "Food", "Qty", "Unit Price", "Total", "Status");
            printOrderAtIndex(index);
        }
    }

    static int findOrderIndex(int targetOrderNumber) {
        for (int i = 0; i < orderNumbers.size(); i++) {
            if (orderNumbers.get(i) == targetOrderNumber) {
                return i;
            }
        }
        return -1;
    }

    static void displayQueue() {
        System.out.println("\n--- PREPARATION QUEUE (FRONT TO BACK) ---");
        if (preparationQueue.isEmpty()) {
            System.out.println("The preparation queue is empty.");
            return;
        }

        int position = 1;
        for (Integer orderNumber : preparationQueue) {
            int index = findOrderIndex(orderNumber);
            if (index != -1) {
                System.out.println(position + ". Order #" + orderNumbers.get(index)
                        + " | " + customerNames.get(index)
                        + " | " + foodItems.get(index)
                        + " | Total: " + String.format("%.2f", totalPrices.get(index)));
                position++;
            }
        }
    }

    static void peekNextOrder() {
        System.out.println("\n--- NEXT ORDER ---");
        Integer next = preparationQueue.peek();
        if (next == null) {
            System.out.println("The preparation queue is empty. There is no next order.");
            return;
        }

        int index = findOrderIndex(next);
        if (index == -1) {
            System.out.println("The next order could not be found in the records.");
        } else {
            System.out.println("Next order to prepare: #" + orderNumbers.get(index));
            System.out.println("Customer: " + customerNames.get(index));
            System.out.println("Food: " + foodItems.get(index));
            System.out.println("Quantity: " + quantities.get(index));
            System.out.printf("Total: %.2f%n", totalPrices.get(index));
            System.out.println("Peeking does not remove the order from the queue.");
        }
    }

    static void processNextOrder() {
        System.out.println("\n--- PROCESS NEXT ORDER ---");
        Integer next = preparationQueue.poll();

        if (next == null) {
            System.out.println("Cannot process an order because the queue is empty.");
            return;
        }

        int index = findOrderIndex(next);
        if (index == -1) {
            System.out.println("Order #" + next + " was removed from the queue, but no record was found.");
            return;
        }

        orderStatuses.set(index, "Completed");
        System.out.println("Order processed successfully!");
        System.out.println("Order #" + orderNumbers.get(index) + " for "
                + customerNames.get(index) + " (" + foodItems.get(index) + ") is completed.");
        System.out.println("This order was at the front of the queue, demonstrating FIFO.");
    }

    // Bubble Sort: manually sort all parallel lists by order number ascending.
    static void bubbleSortByOrderNumber() {
        System.out.println("\n--- BUBBLE SORT: ORDER NUMBER ---");
        if (orderNumbers.size() < 2) {
            System.out.println("Add at least two orders before sorting.");
            return;
        }

        System.out.println("Records before sorting:");
        displayAllOrders();

        int n = orderNumbers.size();
        for (int pass = 0; pass < n - 1; pass++) {
            for (int j = 0; j < n - pass - 1; j++) {
                if (orderNumbers.get(j) > orderNumbers.get(j + 1)) {
                    swapRecords(j, j + 1);
                }
            }
        }

        System.out.println("\nRecords after Bubble Sort (order number: low to high):");
        displayAllOrders();
        System.out.println("The preparation queue order has not been changed.");
    }
// Selection Sort: manually sort all parallel lists by total price ascending.
    static void selectionSortByTotalPrice() {
        System.out.println("\n--- SELECTION SORT: TOTAL PRICE ---");
        if (totalPrices.size() < 2) {
            System.out.println("Add at least two orders before sorting.");
            return;
        }

        System.out.println("Records before sorting:");
        displayAllOrders();

        int n = totalPrices.size();
        for (int i = 0; i < n - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (totalPrices.get(j) < totalPrices.get(minimumIndex)) {
                    minimumIndex = j;
                }
            }
            if (minimumIndex != i) {
                swapRecords(i, minimumIndex);
            }
        }

        System.out.println("\nRecords after Selection Sort (total price: low to high):");
        displayAllOrders();
        System.out.println("The preparation queue order has not been changed.");
    }

    // Swaps every field so the parallel ArrayLists stay synchronized.
    static void swapRecords(int first, int second) {
        swapIntegerList(orderNumbers, first, second);
        swapStringList(customerNames, first, second);
        swapStringList(foodItems, first, second);
        swapIntegerList(quantities, first, second);
        swapDoubleList(unitPrices, first, second);
        swapDoubleList(totalPrices, first, second);
        swapStringList(orderStatuses, first, second);
    }

    static void swapIntegerList(ArrayList<Integer> list, int first, int second) {
        Integer temporary = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temporary);
    }

    static void swapDoubleList(ArrayList<Double> list, int first, int second) {
        Double temporary = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temporary);
    }

    static void swapStringList(ArrayList<String> list, int first, int second) {
        String temporary = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temporary);
    }

    static String readNonEmptyText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    static int readInt(String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < minimum || value > maximum) {
                    System.out.println("Enter a whole number from " + minimum + " to " + maximum + ".");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    static double readDouble(String prompt, double minimum, double maximum) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (Double.isNaN(value) || Double.isInfinite(value)
                        || value < minimum || value > maximum) {
                    System.out.println("Enter a number from " + minimum + " to " + maximum + ".");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (example: 75.50).");
            }
        }
    }
}
