public class MFU {


    Object scanLock = new Object();
    Object scanPrint = new Object();

        public static void main(String[] agrs){

            final MFU mfu = new MFU();

            new Thread(new Runnable() {
                @Override
                public void run() {
                   mfu.print( " doc1", 5);

                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.copy ( " doc2", 10);

                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.scan ( " doc3", 6);

                }
            }).start();


    }

    public  void scan(String doc, int pages){
        synchronized (scanLock){
            System.out.println("Начало сканирования документа " + doc);
            for ( int i = 0; i< pages; i++ ){
                System.out.println("Сканирование страницы " + i + " (" + doc + ")");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Сканирование документа " + doc + " закончено");
        }


    }

    public void print(String doc, int pages){
            synchronized (scanPrint){
                System.out.println("Начало печати документа " + doc);
               for ( int i = 0; i< pages; i++ ){
                   System.out.println("Печать страницы " + i+ " (" + doc + ")");
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
               System.out.println("Печать документа " + doc + " закончена");
            }

    }

    public void copy(String doc, int pages){
            System.out.println("Начало копирования документа" + doc + " (" + doc + ")");
            scan(doc, pages);
            print(doc, pages);
             System.out.println("Копирование документа " + doc + " закончено");
    }

}
