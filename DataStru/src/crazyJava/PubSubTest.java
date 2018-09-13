package crazyJava;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class PubSubTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		SubmissionPublisher<String> publisher=new SubmissionPublisher<>();
		MySubscriber<String> subscribeer=new MySubscriber<>();
		publisher.subscribe(subscribeer);
		System.out.println("������������...");
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
		// TODO �Զ����ɵķ������
		this.subscription=subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		// TODO �Զ����ɵķ������
		System.out.println("��ȡ������:"+item);
	    subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO �Զ����ɵķ������
		throwable.printStackTrace();
		synchronized("fkjava"){
			"fkjava".notifyAll();
		}
	}

	@Override
	public void onComplete() {
		// TODO �Զ����ɵķ������
		System.out.println("���Ľ���");
		synchronized("fkjava") {
			"fkjava".notifyAll();
		}
	}
	
}