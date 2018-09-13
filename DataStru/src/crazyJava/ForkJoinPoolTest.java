package crazyJava;

import java.util.concurrent.*;

class PrintTask extends RecursiveAction{

	private static final int THRESHOLD=50;
	private int start;
	private int end;
	
	public PrintTask(int start,int end) {
		this.setStart(start);
		this.setEnd(end);
	}

	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	protected void compute() {
		// TODO 自动生成的方法存根
		if(end-start<THRESHOLD) {
			for(int i=start;i<end;i++) {
				System.out.println(Thread.currentThread().getName()+"的i值:"+i);
			}
		}else {
			int middle=(start+end)/2;
			PrintTask left=new PrintTask(start,middle);
			PrintTask right=new PrintTask(middle,end);
			left.fork();
			right.fork();			
		}
	}
	
}

public class ForkJoinPoolTest {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根

		ForkJoinPool pool=new ForkJoinPool();
		pool.submit(new PrintTask(0,300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		pool.shutdown();
	}

}
