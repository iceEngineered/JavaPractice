import java.util.ArrayList;
class BankAccount {
long accountID;
String ownerName;
double balance;
boolean withdrawal(double amount) {
  if (balance>amount) {
  balance=balance-amount;
  return true;
} else {
  return false;
}
}
boolean deposit(double amount) {
  balance=balance+amount;
  return true;
}

void printTransactionHistory() {

}

BankAccount(long accountID, String ownerName, long balance) {
  this.accountID=accountID;
  this.ownerName=ownerName;
  this.balance=balance;
}
}//BankAccount

class Bank {
ArrayList<BankAccount> accounts = new ArrayList<>();
  boolean transfer(BankAccount fromAccount, long amount,BankAccount toAccount) {
    if (fromAccount.withdrawal(amount)) {
      toAccount.deposit(amount);
      return true;
    } else {
      return false;
    }
  }
  void printBalances() {
    for (BankAccount account: accounts) {
      System.out.println(account.ownerName+" : "+account.accountID);
      System.out.println(account.balance);
      System.out.println("---------------------------");
    }
  }
    void addMonthlyInterest() {
      for (BankAccount account: accounts) {
        account.balance = account.balance+(account.balance*0.06);
      }
    }
  
public static void main(String[] args) {
Bank bank = new Bank();
BankAccount bankAccount0 = new BankAccount(1, "James Dean", 4834);
bank.accounts.add(bankAccount0);
BankAccount bankAccount1 = new BankAccount(2, "Jimmy Buffet", 74000);
bank.accounts.add(bankAccount1);
BankAccount bankAccount2 = new BankAccount(3, "Jason Buleria", 245);
bank.accounts.add(bankAccount2);
bank.printBalances();
bank.accounts.get(0).withdrawal(834);
bank.transfer(bank.accounts.get(1), 4000, bank.accounts.get(2));
bank.printBalances();
bank.addMonthlyInterest();
bank.printBalances();
}//void main
}
