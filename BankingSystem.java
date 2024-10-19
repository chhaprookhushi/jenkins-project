//Java Banking System Simulation

import java.util.Scanner;

class InsufficientFundsException extends Exception{
	InsufficientFundsException(){
		super("Insufficient Amount to withdraw, Please Try Again!!");
	}
}



class BankAccount{
	int accountNumber;
	double balance;
	
	BankAccount(){
		accountNumber = 123;
		balance = 0;
	}
	
	public void deposit(double amount){
		this.balance += amount;
	}
	
	public void withdraw(double amount){
		if(this.balance >= amount){
			this.balance = this.balance - amount;
			System.out.println("Amount Withdrawal Successful!!");
		}
		else{
			try{
				throw new InsufficientFundsException();
			}
			catch(InsufficientFundsException e){
				System.out.println(e);
			}
		}
	}
	
	public void getBalance(){
		System.out.println("Your Current Balance is: "+ this.balance);
	}
}

class BankingSystem{
	public static void main(String[] args){
		double amt;
		Scanner sc = new Scanner(System.in);
		BankAccount b1 = new BankAccount();
		System.out.println("Enter initial balance to deposit, to open your new account: ");
		amt = sc.nextInt();
		b1.deposit(amt);
		
		System.out.println("Enter amount to withdraw: ");
		amt = sc.nextInt();
		b1.withdraw(amt);
		
		b1.getBalance();
	}
}