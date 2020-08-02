import javafx.scene.control.RadioMenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    public static void main (String arg[]) throws IOException {

           //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        System.out.println ("Задание 1");
        try (FileInputStream fin = new FileInputStream("notes.txt")){
            byte[] buffer = new byte [fin.available()];

            fin.read(buffer, 0, fin.available());

            System.out.println("File data:");
            System.out.println();

            for ( int i = 0; i< buffer.length; i ++ ){
                System.out.print((char) buffer[i]);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



/*        Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться
        следующая конструкция:
        ArrayList<InputStream> al = new ArrayList<>();
        ... Enumeration<InputStream> e = Collections.enumeration(al);*/
        System.out.println ("Задание 2");

        ArrayList<FileInputStream> al = new ArrayList<>();
        al.add(new FileInputStream("1.txt"));
        al.add(new FileInputStream("2.txt"));
        al.add(new FileInputStream("3.txt"));
        al.add(new FileInputStream("4.txt"));
        al.add(new FileInputStream("5.txt"));

        SequenceInputStream in = new SequenceInputStream (Collections.enumeration(al));
        int x;

        while ((x = in.read()) != -1){
            System.out.print((char) x);

        }
        in.close();

        /*    Написать консольное приложение, которое умеет постранично читать текстовые
 файлы (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов),
  программа выводит ее в консоль. Контролируем время выполнения: программа не должна
  загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.*/

        System.out.println ("Задание 3");
        File file3 = new File("task3.txt");
        FileInputStream fis2 = new FileInputStream(file3);
        byte[] byteArray = new byte[(int)file3.length()];
       fis2.read(byteArray);
        String data = new String(byteArray);
        System.out.println("Количество символов в файле: "+data.length());
        int quantityOfPages =data.length() / 1800;
        System.out.println("Количество полных страниц: " + quantityOfPages);

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите номер страницы в диапазоне от 1 до " + quantityOfPages);
        int page  = sc.nextInt()-1;
        try (RandomAccessFile raf = new RandomAccessFile("task3.txt", "r")){

            for (int i = page * 1800; i < page * 1800+1800; i ++){
                raf.seek(i);
                System.out.print((char)raf.read());
            }


        }

}
}




















