package crazyJava;
import java.util.concurrent.*;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ExecutorService pool=Executors.newFixedThreadPool(6);
		Runnable target=()->{
			for(int i=0;i<100;i++) {
				System.out.println(Thread.currentThread().getName()+"的i的值:"+i);
			}
		}; 
		pool.submit(target);
		pool.submit(target);
		pool.shutdown();
	}

}
