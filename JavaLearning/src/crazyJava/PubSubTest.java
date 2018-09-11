package crazyJava;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class PubSubTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		SubmissionPublisher<String> publisher=new SubmissionPublisher<>();
		MySubscriber<String> subscribeer=new MySubscriber<>();
		publisher.subscribe(subscribeer);
		System.out.println("开发发布数据...");
		List.of("Java","Kotlin","Go","Erlang","Swift","Lua").forEach(im->{
			publisher.submit(im);
			try {
				Thread.sleep(500);
			}catch(Exception ex) {
				
			}
		});
		publisher.close();
		synchronized("fkjava") {
			try {
				"fkjava".wait();
			}catch(Exception ex) {
				
			}
		}		
	}

}

class MySubscriber<T> implements Subscriber<T>{

	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO 自动生成的方法存根
		this.subscription=subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		// TODO 自动生成的方法存根
		System.out.println("获取到数据:"+item);
	    subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO 自动生成的方法存根
		throwable.printStackTrace();
		synchronized("fkjava"){
			"fkjava".notifyAll();
		}
	}

	@Override
	public void onComplete() {
		// TODO 自动生成的方法存根
		System.out.println("订阅结束");
		synchronized("fkjava") {
			"fkjava".notifyAll();
		}
	}
	
}