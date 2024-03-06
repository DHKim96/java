

/*
 * 쓰레드 생성 방법1. Runnable 의 추상 메소드 run을 구현하는 객체를 만든다.
 * 
 */

public class MyRunable implements Runnable{

	@Override
	public void run() {
		int n1 = 10;
		int n2 = 20;
		// currentThread() : 현재 실행하고 있는 쓰레드의 정보를 반환
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1 + n2 ) );
	}

}
