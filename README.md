1.Food Online Order Processing System

2. The Food Ordering and Preparation Queue System is a console-based Java application designed to help manage customer orders in a food business. It addresses the problem of organizing food orders, tracking order details, and managing the order of food preparation. The system allows users to add orders, view records, search for customers, sort order information, and manage the preparation queue. By using data structures and sorting algorithms, the application helps make order management more organized and efficient.


3. Objectives
- Record and display customer food orders.
- Organize order information using Java ArrayList.
- Manage food preparation using a FIFO queue.
- Implement sorting algorithms manually rather than relying on
  built-in sorting methods.
- Apply basic input validation.
- Demonstrate how data structures help organize and process
  information.

4. Use Cases and Features

The system provides the following functions:

- Add New Order – Allows the user to enter customer information, food items, quantities, and prices.
- View Order Items – Displays the recorded food orders and their details.
- Sort Menu Records – Organizes order records using the implemented sorting algorithms.
- Search by Customer Name – Allows the user to find orders using a customer's name.
- Add Order to Queue – Places an order ID into the food preparation queue.
- View Preparation Queue – Displays the order IDs waiting to be prepared.
- Peek at Next Order – Shows the next order to be prepared without removing it from the queue.
- Prepare Next Order – Processes the next order in the queue and displays its receipt.
- Exit – Closes the application.

5. The system uses multiple ArrayLists to store order IDs, customer names, food items, quantities, and total amounts. These lists work together through matching indexes, allowing the system to access and manage related order information. When records are sorted, the corresponding information is also swapped to keep each record organized correctly.

The system uses a Queue implemented with Java's LinkedList. It manages the order IDs waiting for food preparation and follows the FIFO (First In, First Out) principle. This means the first order added to the queue is the first order to be processed.

6.Sorting Algorithm 

The application implements two sorting algorithms to organize order records. Bubble Sort compares neighboring records and swaps them when they are in the wrong order. The process repeats until the records are sorted. In this application, Bubble Sort is used to arrange order records based on their total amounts from highest to lowest, making it easier to identify orders with larger total prices.
Selection Sort repeatedly finds the smallest value in the unsorted portion of a list and places it in the correct position. In this application, Selection Sort is used to arrange order records based on quantity from lowest to highest, making it easier to compare order quantities.

Both algorithms are implemented manually to demonstrate how sorting works without relying on Java's built-in sorting methods. When records are swapped, the corresponding information in the parallel ArrayLists is also swapped to maintain data accuracy. These sorting algorithms demonstrate how data can be organized according to different requirements, while the queue continues to manage the order of food preparation independently.

7. How to Run a Program
   
8. Make sure you have Java installed on your Computer

9. Open Terminal

10. Compile the Program: javac Main.java

11. Run the Program: java Main

12. Screenshots of the System

Main Menu & Adding an Order Main Menu

<img width="457" height="277" alt="Screenshot 2026-10-25 143812" src="https://github.com/user-attachments/assets/c149df60-bbf1-45d2-9719-e1bce45039d6" />

Adding an Order

<img width="360" height="303" alt="Screenshot 2026-10-25 143822" src="https://github.com/user-attachments/assets/b324cd83-41b0-4265-9b02-cec48ec62924" />

Viewing and Sorting Orders

Viewing an Order

<img width="830" height="150" alt="Screenshot 2026-10-25 143740" src="https://github.com/user-attachments/assets/52306f00-1c77-4dd0-9f81-0fdeef5dfd35" />

Sorting an Order Bubble Sort

<img width="852" height="442" alt="Screenshot 2026-10-25 144006" src="https://github.com/user-attachments/assets/9e5e1e71-9804-43be-809f-9f05f51d3b6e" />

Preparation Queue

<img width="528" height="82" alt="Screenshot 2026-10-25 144159" src="https://github.com/user-attachments/assets/bf46d85b-c9bb-44fd-8a85-b86d9ec873b9" />

<img width="596" height="105" alt="Screenshot 2026-10-25 144035" src="https://github.com/user-attachments/assets/0052e8bd-c274-4f3c-a6bf-42ea127db5fa" />











