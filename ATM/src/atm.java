import java.util.Scanner;

public class atm
{
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);

        int pin = 123;
        double balance = 10000;

        int enteredPin = 0;
        int choice = 0;

        System.out.println("Welcome to the ATM");


        try {
            System.out.print("Enter your PIN: ");
            enteredPin = sc.nextInt();
        } catch (Exception e)
        {
            System.out.println("Invalid input. PIN must be numbers only.");
            sc.close();
            return;
        }

        if (enteredPin == pin)
        {
            System.out.println("Invalid PIN. Access denied.");
            sc.close();
            return;
        }

        System.out.println("PIN verified successfully.");

        do
        {
            System.out.println("\nATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            switch (choice)
            {

                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    try
                    {
                        double withdraw = sc.nextDouble();

                        if (withdraw <= 0) {
                            System.out.println("Enter a valid amount.");
                        } else if (withdraw > balance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            balance = balance - withdraw;
                            System.out.println("Please collect your cash.");
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid amount entered.");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    try {
                        double deposit = sc.nextDouble();

                        if (deposit <= 0)
                        {
                            System.out.println("Enter a valid amount.");
                        } else {
                            balance = balance + deposit;
                            System.out.println("Amount deposited successfully.");
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println("Invalid amount entered.");
                        sc.next();
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        }
        while (choice != 4);

        sc.close();
    }
}
