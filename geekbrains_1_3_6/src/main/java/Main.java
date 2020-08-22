public class Main {

    // 1. Написать метод, которому в качестве аргумента передается
    // не пустой одномерный целочисленный массив. Метод должен вернуть новый массив,
    // который получен путем вытаскивания из исходного массива элементов,
    // идущих после последней четверки.
    // Входной массив должен содержать хотя бы одну четверку,
    // иначе в методе необходимо выбросить RuntimeException.
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    // Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].


    public static void main(String[] args) {
    }
    public int[] returnArray(int array[]) throws RuntimeException {
        int initArraySize = array.length;
        int position = -1;
        int newArraySize = 0;
        int newArray[];

        for (int i = initArraySize - 1; i >= 0; i--) {
            if (array[i] == 4) {
                position = i;
                newArraySize = initArraySize - position - 1;
            }
        }

        newArray = new int[newArraySize];

        if (position != -1) {
            for (int j = 0; j < newArraySize; j++) {
                newArray[j] = array[j + position + 1];
            }
        } else {
            throw new RuntimeException("В заданном массиве нет цифры 4");
        }
        return newArray;
    }


    //2. Написать метод, который проверяет состав массива из чисел 1 и 4.
    // Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    public boolean checkArray(int array[]) {

        int one = 0;
        int four = 0;
        for (int o : array) {
            if (o == 1) {
                one++;
            }
            else if (o == 4) {
                four++;
            } else {
                return false;
            }
        }
        if (one != 0 && four != 0) {
            return true;
        }
        return false;
    }
}
