import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class BankAccount {
 private double balance;
 private Lock lock;
 public BankAccount() {
 balance = 0.0;
 lock = new ReentrantLock();
 }
 public void deposit(double amount) {
 lock.lock();
 try {
 balance += amount;
 System.out.println("Deposit: " + amount);
 System.out.println("Balance after deposit: " + balance);
 } finally {
 lock.unlock();
 }
 }
 public void withdraw(double amount) {
 lock.lock();
 try {
 if (balance >= amount) {
 balance -= amount;
 System.out.println("Withdrawal: " + amount);
 System.out.println("Balance after withdrawal: " + balance);
 } else {
 System.out.println("Try to Withdraw: " + amount);
 System.out.println("Insufficient funds. Withdrawal cancelled.");
 }
 } finally {
 lock.unlock();
 }
 }
 public static void main(String[] args) {
 BankAccount account = new BankAccount();
Scanner scanner = new Scanner(System.in);
 while (true) {
 System.out.println("Choose an operation: ");
 System.out.println("1. Deposit");
 System.out.println("2. Withdraw");
 System.out.println("3. Exit");
 System.out.print("Enter your choice: ");
 int choice = scanner.nextInt();
 if (choice == 1) {
 System.out.print("Enter the deposit amount: ");
 double depositAmount = scanner.nextDouble();
 account.deposit(depositAmount);
 } else if (choice == 2) {
 System.out.print("Enter the withdrawal amount: ");
 double withdrawalAmount = scanner.nextDouble();
 account.withdraw(withdrawalAmount);
 } else if (choice == 3) {
 break;
 } else {
 System.out.println("Invalid choice. Please choose a valid option.");
 }
 }
 scanner.close();
 }
}