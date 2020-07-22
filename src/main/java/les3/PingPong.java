package les3;

public class PingPong {

    public static void main(String[] args) {
        Object mutex = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mutex) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Ping");
                        try {
                            mutex.notify();
                            Thread.sleep(500);
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mutex.notify();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mutex) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Pong");
                        try {
                            mutex.notify();
                            Thread.sleep(500);
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mutex.notify();
                }
            }
        }).start();
    }
}
