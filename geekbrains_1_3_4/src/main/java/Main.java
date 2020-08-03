public class Main {

   static int marker = 3;



    public static void main(String[] args){


        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {

                    for (int i = 0; i < 5; i++) {
                        while (marker != 3) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        System.out.print("A");
                        marker = 1;
                        lock.notifyAll();
                    }
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        while (marker != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        System.out.print("B");
                        marker = 2;
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {

                        while (marker != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        System.out.print("C");
                        marker = 3;
                        lock.notifyAll();
                    }

                }
            }
        });

        t1.start();
        t2.start();
        t3.start();












    }

    public synchronized static void printA(){
        for (int i = 0; i < 5; i ++){

            System.out.print("A");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    public synchronized static void printB(){
        for (int i = 0; i < 5; i ++){
            System.out.print("B");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public synchronized static void printC(){
        for (int i = 0; i < 5; i ++){
            System.out.print("C");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
