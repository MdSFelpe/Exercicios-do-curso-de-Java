public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;


    public Account(){

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.balance = balance;
        this.holder = holder;
        this.number = number;
        this.withdrawLimit = withdrawLimit;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        if(amount < 0){
            throw new WithdrawLimitException("Invalid deposit amount! Please enter a positive value.");
        }
        balance += amount;
    }

    public void withdraw(Double amount){
        if (amount > withdrawLimit) {
            throw new WithdrawLimitException("Withdrawal amount exceeds limit! Your limit is: " + withdrawLimit);
        }
        if (amount > balance) {
            throw new WithdrawLimitException("Insufficient balance.");
        }
        balance -= amount;
    }


    @Override
    public String toString() {
        return "New balance :  "
                + balance;

    }
}

