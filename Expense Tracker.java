import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    
    static class Expense {
        String category;
        double amount;
        Expense(String c, double a) { category = c; amount = a; }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- Welcome User! ---");
        
        ArrayList<Expense> expenses = new ArrayList<>();
        double budget = 0;
        int choice;
        String name; 
        
        while (true) {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        
        if (name.matches("[a-zA-Z ]+")){
            break;
        } else {
            System.out.println("Invalid input! Only Letters and spaces are allowed.");
        }
    }
        
        while (true) {
            System.out.print("Enter Budget: ");
            budget = sc.nextDouble(); sc.nextLine();
            
            if (budget > 0) {
                break;
            } else {
                System.out.println("Budget cannot be zero or negative. Try again.");
            }
        }

        do {
            System.out.println("1.Add");
            System.out.println("2.View & Status");
            System.out.println("3.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt(); sc.nextLine();
            
            switch(choice) {
                case 1:
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    double amt;
                    while (true) {
                        System.out.print("Amount: ");
                        amt = sc.nextDouble(); sc.nextLine();
                        
                        if (amt > 0) {
                            break;
                        } else {
                            System.out.println("Amount cannot be zero or negative! Try again.");
                        }
                    }   
                    expenses.add(new Expense(cat, amt));
                    
                    double total = 0;
                    for(Expense e : expenses) total += e.amount;

                    if(total > budget) {
                        System.out.println("Added! But budget exceeded by " + (total - budget));
                    } else {
                        System.out.println("Added! Remaining: " + (budget - total));
                    }
                    break;
                    
                case 2: 
                    if(expenses.isEmpty()) {
                        System.out.println("No expenses.");
                        
                    } else {
                        double totalView = 0;
                        System.out.println("\n--- Expenses List ---");
                        for(int i = 0; i < expenses.size(); i++) {
                            System.out.println((i+1) + ". " + expenses.get(i).category +
                                " - " + expenses.get(i).amount);
                            totalView += expenses.get(i).amount;
                        }

                        double remain = budget - totalView;
                        System.out.println("\n--- Budget Status ---");
                        System.out.println("Budget: " + budget);
                        System.out.println("Spent: " + totalView);
                        System.out.println("Remaining: " + remain);
                        if(remain < 0) {
                            System.out.println("NEGATIVE: Over by " + remain);
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Bye!");
                    break;
                    
                default:
                    System.out.println("Invalid!");
            }
        } while(choice != 3);
        
        sc.close();
    }
}