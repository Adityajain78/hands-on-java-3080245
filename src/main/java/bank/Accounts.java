package bank;

public class Accounts {
  private int id;
  private String accountType;
  private int balance;

  public Accounts(int id, String accountType, int balance) {
    setId(id);
    setAccountType(accountType);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAccountType() {
    return this.accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public int getBalance() {
    return this.balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
