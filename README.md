1.Food Online Order Processing System

2. The Food Ordering and Preparation Queue System is a console-based Java application for a small restaurant or cafeteria. It helps staff record food orders, view order information, search for orders, and manage food preparation using a queue. It also uses two manually implemented sorting algorithms to organize order records.

3. Objectives
- Record and display customer food orders.
- Organize order information using Java ArrayList.
- Manage food preparation using a FIFO queue.
- Implement sorting algorithms manually rather than relying on
  built-in sorting methods.
- Apply basic input validation.
- Demonstrate how data structures help organize and process
  information.

4. The system uses 'ArrayList' to store order IDs, customer names, food items, quantities, and total prices. It uses parallel lists to keep order details organized and together when sorting. The system also uses a 'Queue' implemented with `LinkedList' to manage food preparation. It follows FIFO (First In, First Out), meaning the first order added is the first to be prepared. These data structures help organize orders and make food preparation more efficient.

5. The program manually implements two sorting algorithms. Bubble Sort compares neighboring order numbers and swaps them when they
are in the wrong order. The process repeats until records are arranged
from lowest to highest order number. Selection Sort repeatedly finds the smallest total price in the unsorted
part of the records and places it in the next correct position. This
arranges records from lowest to highest total price. When records are sorted, their related information is swapped together
so customer names, food items, quantities, and totals remain associated
with the correct record.

6. How to Run the Program

7. Make sure you have Java installed on your Computer

8. Open Terminal

9. Compile the Program: javac Main.java

10. Run the Program: java Main

11. Screenshots of the System

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











