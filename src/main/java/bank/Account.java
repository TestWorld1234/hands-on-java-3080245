package bank;

import bank.exceptions.AmountExceptions;

public class Account {
  private int id;
  private String type;
  private double balance;

  public Account(int id, String type, double balance){
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountExceptions{
    if(amount < 1){
      throw new AmountExceptions("The minimum deposit is 1.00");
    }else{
      double newBalance = balance + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalange(id, newBalance);
    }
    
  }

  public void withdraw(double amount)throws AmountExceptions{
    if(amount < 0){
      throw new AmountExceptions(("The withdrawl amount must be greater than 0."));
    }
    else if (amount > getBalance()){
      throw new AmountExceptions("You do not have sufficient funds for this withdrawl");
    }
    else{
      double newBalance = balance - amount;
      setBalance(newBalance);
      DataSource.updateAccountBalange(id, newBalance);
    }
  }
}
