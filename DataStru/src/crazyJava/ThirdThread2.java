package crazyJava;

import java.util.concurrent.*;

public class ThirdThread2 implements Callable{

	private int i;
	
	@Override
	public Object call() throws Exception {
		// TODO 自动生成的方法存根
		for(;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"的内循环变量i: "+i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ThirdThread2 rt=new ThirdThread2();
		FutureTask<Integer> task=new FutureTask<Integer>(rt);
		//ThirdThread2 rt2=new ThirdThread2();
		FutureTask<Integer> task2=new FutureTask<Integer>(rt);
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"的内循环变量i: "+i);
			if(i==20) {
				new Thread(task,"带有返回值的线程1").start();
				new Thread(task2,"带有返回值的线程2").start();
			}
		}
		try {
			System.out.println("两个线程的返回结果的和"+(task.get()+task2.get()));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
