package crazyJava;
import java.util.Random;
import java.util.concurrent.*;

class CalTask extends RecursiveTask<Integer>{

	private static final int THRESHOLD=20;
	private int arr[];
	private int start;
	private int end;
	
	public CalTask(int[] arr,int start,int end) {
	
		this.setArr(arr);
		this.setStart(start);
		this.setEnd(end);
	}
	
	public int[] getArr() {
		return arr;
	}

	public void setArr(int arr[]) {
		this.arr = arr;
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
	protected Integer compute() {
		// TODO 自动生成的方法存根
		int sum=0;
		if(end-start<THRESHOLD) {
			for(int i=start;i<end;i++) {
				sum+=arr[i];
			}
			return sum;
		}
		else {
			int middle=(start+end)/2;
			CalTask left=new CalTask(arr,start,middle);
			CalTask right=new CalTask(arr,middle,end);
			left.fork();
			right.fork();
			return left.join()+right.join();
		}
	}
	
}

public class Sum {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO 自动生成的方法存根

		int arr[] =new int[100];
		Random rand=new Random();
		int total=0;
		for(int i=0,len=arr.length;i<len;i++) {
			int temp=rand.nextInt(20);
			total+=(arr[i]=temp);
		}
		System.out.println(total);
		ForkJoinPool pool=ForkJoinPool.commonPool();
		Future<Integer> future=pool.submit(new CalTask(arr,0,arr.length));
		System.out.println(future.get());
		pool.shutdown();
	}

}
