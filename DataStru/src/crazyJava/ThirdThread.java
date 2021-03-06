package crazyJava;

import java.util.concurrent.*;

public class ThirdThread {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ThirdThread rt=new ThirdThread();
		
		FutureTask<Integer> task=new FutureTask<Integer>((Callable<Integer>)()->{
			int i=0;
			for(;i<100;i++) {
				System.out.println(Thread.currentThread().getName()+" "+" 的循环变量i的值："+i);
			}
			return i;
		});
		
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+" 的循环变量i的值："+i);
			if(i==20) {
				new Thread(task,"有返回值的线程").start();
			}
		}
		
		try {
			System.out.println("子线程的返回值："+task.get());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
