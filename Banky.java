import java.util.Scanner;
class BankInfo
{
    private String name;
    private String acc_no;
    private String acc_type;
    private long balance;
    Scanner sc = new Scanner(System.in);
    public void createAccount() 
    {
        System.out.println("Enter your Name: ");
        name = sc.nextLine();
        System.out.println("create your Account number: ");
        acc_no = sc.nextLine();
        System.out.println("create your Account Type: ");
        acc_type = sc.nextLine();
        System.out.println("Enter your Account Balance: ");
        balance = sc.nextLong();
    }

    public void displayAccount() 
    {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + acc_no);
        System.out.println("Account Type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    public void deposit() 
    {
        long rupee;
        System.out.println("Enter the amount to deposit: ");
        rupee = sc.nextLong();
        balance += rupee;
    }

    public void withdraw() 
    {
        long cash;
        System.out.println("Enter the amount to withdraw: ");
        cash = sc.nextLong();
        if (balance >= cash) {
            balance -= cash;
            System.out.println("Account Balance: " + balance);
        } else {
            System.out.println("Insufficient Funds!!!");
        }
    }

    public boolean search(String accNo) 
    {
        if (acc_no.equals(accNo)) {
            displayAccount();
            return true;
        }
        return false;
    }

    public void transfer(BankInfo[] accounts, String fromAccNo, String toAccNo, long amount) 
    {
        BankInfo fromAccount = null;
        BankInfo toAccount = null;
        for (BankInfo account : accounts) 
        {
            if (account.acc_no.equals(fromAccNo)) 
            {
                fromAccount = account;
            }
            if (account.acc_no.equals(toAccNo)) 
            {
                toAccount = account;
            }
        }
        if (fromAccount != null && toAccount != null)
        {
            if (fromAccount.balance >= amount) 
            {
                fromAccount.balance -= amount;
                toAccount.balance += amount;
                System.out.println("Transfer successful.");
            } 
            else 
            {
                System.out.println("Insufficient funds in the source account.");
            }
        } 
        else 
        {
            System.out.println("One or both accounts not found.");
        }
    }
}
public class Banky {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of customers:");
        int n = sc.nextInt();
        int choice;
        BankInfo b[] = new BankInfo[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = new BankInfo();
            b[i].createAccount();
        }
        do {
            System.out.println();
            System.out.println("BANKY");
            System.out.println(" 1. Display Account Details\n 2. Deposit Amount\n 3. Withdraw Amount\n 4. Transfer Funds\n 5. Search Account\n 6. Close");
            System.out.println("Enter an option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < b.length; i++) {
                        b[i].displayAccount();
                    }
                    break;
                case 2:
                    System.out.println("Enter Account number: ");
                    String accNo = sc.nextLine();
                    accNo = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < b.length; i++) {
                        found = b[i].search(accNo);
                        if (found) {
                            b[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No Matches Found");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account number: ");
                    accNo = sc.nextLine();
                    accNo = sc.nextLine();
                    found = false;
                    for (int i = 0; i < b.length; i++) {
                        found = b[i].search(accNo);
                        if (found) {
                            b[i].withdraw();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No Matches Found");
                    }
                    break;
                case 4:
                    System.out.println("Enter source Account number: ");
                    String fromAccNo = sc.nextLine();
                    fromAccNo = sc.nextLine();
                    System.out.println("Enter destination Account number: ");
                    String toAccNo = sc.nextLine();
                    System.out.println("Enter amount to transfer: ");
                    long amount = sc.nextLong();
                    b[0].transfer(b, fromAccNo, toAccNo, amount); 
                    break;
                case 5:
                    System.out.println("Enter Account number: ");
                    accNo = sc.nextLine();
                    accNo = sc.nextLine();
                    found = false;
                    for (int i = 0; i < b.length; i++) {
                        found = b[i].search(accNo);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No Matches Found");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for Banking with us");
                    break;
            }
        } while (choice != 6);
    }
}
