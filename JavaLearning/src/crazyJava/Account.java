package crazyJava;

import java.util.concurrent.locks.*;

public class Account {

	private String accountNo;
	private double balance;
	private final ReentrantLock lock=new ReentrantLock();
	private final Condition con=lock.newCondition();
	private boolean flag=false;
	
	
	public Account() {
		
	}
	
	public Account(String accountNo,double balance) {
		this.setAccountNo(accountNo);
		this.setBalance(balance);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public int hashCode() {
		return accountNo.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj!=null&&obj.getClass()==Account.class) {
			Account target=(Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
	
	//需要保证线程安全的方法
	/*
	public synchronized void draw(double drawAmount) {

		if(balance>=drawAmount) {
			System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票:"+drawAmount);			
			try {
				Thread.sleep(1);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			balance=balance-drawAmount;
			//this.setBalance(this.getBalance()-drawAmount);
			System.out.println("\t 余额为:"+balance);
			//System.out.println("\t 余额为:"+this.getBalance());
		}else {
			System.out.println(Thread.currentThread().getName()+"取钱失败！余额不足！");
		}
	}
	*/
	
	//ReentrantLock 来锁定方法
	/*
	public void draw(double drawAmount) {

        lock.lock();
		try {
			
			if(balance>=drawAmount) {
				System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票:"+drawAmount);
				
				try {
					Thread.sleep(1);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				balance=balance-drawAmount;
				//this.setBalance(this.getBalance()-drawAmount);
				System.out.println("\t 余额为:"+balance);
				//System.out.println("\t 余额为:"+this.getBalance());
			}else {
				System.out.println(Thread.currentThread().getName()+"取钱失败！余额不足！");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			lock.unlock();
		}		
	}
	*/
	
	public synchronized void draw(double drawAmount) {
		try {
			if(flag!=true) {
				wait();
			}else {
				System.out.println(Thread.currentThread().getName()+"取钱:"+drawAmount);
				balance=balance-drawAmount;
				System.out.println("余额为:"+balance);
				flag=false;
				notifyAll();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			
		}

	}
	
	public synchronized void deposit(double depositAmount) {
		try {
			if(flag) {
				wait();
			}else {				
				System.out.println(Thread.currentThread().getName()+"存钱:"+depositAmount);
				balance+=depositAmount;
				System.out.println("余额为:"+balance);
				flag=true;
				notifyAll();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			
		}
	}
}
