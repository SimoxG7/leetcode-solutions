class Bank {

  private final long[] accountBalances; 
  private final int n;

  public Bank(long[] balance) {
    n = balance.length;
    accountBalances = balance;
  }

  public boolean transfer(int account1, int account2, long money) {
    if (!isValidAccount(account1) || !isValidAccount(account2)) return false;
    if (accountBalances[account1 - 1] < money) return false;
    accountBalances[account2 - 1] += money;
    accountBalances[account1 - 1] -= money;
    return true;
  }

  public boolean deposit(int account, long money) {
    if (!isValidAccount(account)) return false;
    accountBalances[account - 1] += money;
    return true;
  }

  public boolean withdraw(int account, long money) {
    if (!isValidAccount(account)) return false;
    if (accountBalances[account - 1] < money) return false;
    accountBalances[account - 1] -= money;
    return true;
  }

  private boolean isValidAccount(int account) {
    return account >= 1 && account <= n;
  }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */