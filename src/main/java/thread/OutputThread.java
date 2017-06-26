package thread;

/**
 * Created by Steven
 * Date:2017/6/22
 * Time:11:13
 */
public class OutputThread implements Runnable {

   private int num;
   private Object lock = new Object();

   public OutputThread(int num, Object lock) {
       super();
       this.num = num;
       this.lock = lock;
    }

    @Override
	public void run() {
        try {
            while(true){
                synchronized(lock){
					lock.notifyAll();
					lock.wait();
                    System.out.println(num);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        final Object lock = new Object();

        Thread thread1 = new Thread(new OutputThread(1,lock));
        Thread thread2 = new Thread(new OutputThread(2, lock));

        thread1.start();
        thread2.start();
    }

}
