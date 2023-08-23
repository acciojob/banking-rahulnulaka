package com.driver;

public class BankAccount {

	private String name;
	private double balance;
	private double minBalance;
	private String accountNumber;

	public BankAccount(String name, double balance, double minBalance) {
		this.name = name;
		this.balance = balance;
		this.minBalance = minBalance;
		this.accountNumber = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String generateAccountNumber(int digits, int sum) throws Exception {
		// Each digit of an account number can lie between 0 and 9 (both
		// inclusive)
		// Generate account number having given number of 'digits' such that the
		// sum of digits is equal to 'sum'
		// If it is not possible, throw "Account Number can not be generated"
		// exception
		if (digits * 9 < sum) {
			throw new Exception("Account Number can not be generated");
		}
		this.accountNumber = createAccountNumber(digits, sum);
		return this.accountNumber;
	}

	private String createAccountNumber(int digits, int sum) {
		// TODO Auto-generated method stub
		int remainingSum = sum;
		String accNo = "";
		while (digits > 0 && remainingSum > 0) {
			if (remainingSum > 9) {
				remainingSum -= 9;
				accNo += "9";
			} else {
				accNo += Integer.toString(remainingSum);
				remainingSum = 0;
			}
		}
		while (digits > 0) {
			accNo += "0";
			digits--;
		}
		return accNo;
	}

	public void deposit(double amount) {
		// add amount to balance
		this.balance += amount;
	}

	public void withdraw(double amount) throws Exception {
		// Remember to throw "Insufficient Balance" exception, if the remaining
		// amount would be less than minimum balance
		if (this.balance - amount >= minBalance) {
			this.balance -= amount;
		} else {
			throw new Exception("Insufficient Balance");
		}
	}

}