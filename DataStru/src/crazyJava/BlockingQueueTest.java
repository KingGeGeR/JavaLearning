package crazyJava;

import java.util.concurrent.*;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO �Զ����ɵķ������

		BlockingQueue<String> bq=new ArrayBlockingQueue<>(2);
		bq.put("Java");
		bq.put("java");
		bq.put("JAVA");
	}

}
