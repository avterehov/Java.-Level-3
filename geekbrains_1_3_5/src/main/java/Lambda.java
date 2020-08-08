import java.util.Scanner;

public class Lambda {

    public static  void main (String [] args){


        float a;
        float b;
        char operation;
        float result = 0;
        Scanner sc = new Scanner (System.in);

        Operationable add;
        add  =  (x, y ) -> x+y;
        Operationable subtraction;
        subtraction = (x, y ) -> x-y;
        Operationable multiply;
        multiply = (x,y) -> x*y;
        Operationable division;
        division = (x,y) -> x/y;

    System.out.println("Лямбда калькулятор");

    System.out.println("Введите первое число:");
    a = sc.nextFloat();


    System.out.println("Введите второе число:");
    b = sc.nextFloat();

    System.out.println("Введите операцию ( + , - , / , * ) ");
    operation = sc.next().charAt(0);;

        System.out.print("Результат: ");
      switch (operation){
          case '+': System.out.print (add.calculate(a,b));
          break;
          case '-': System.out.print (subtraction.calculate(a,b));
              break;
          case '*':System.out.print ( multiply.calculate(a,b));
              break;
          case '/':System.out.print ( division.calculate(a,b));
              break;

          default: System.out.println("Некорректно введены данные");

    }

    }

    interface Operationable {
        float calculate (float x, float y);
    }


}
