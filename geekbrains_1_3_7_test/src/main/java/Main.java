public class Main {

    public static void main (String [] args){

        int lines = 4;
        int columns = 4;
        int s = 1;
        int[][] array = new int[lines][columns];


        for (int x = 0; x < columns; x++) {
            array[0][x] = s;
            s++;
        }
        for (int y = 1; y < lines; y++) {
            array[y][columns - 1] = s;
            s++;
        }
        for (int x = columns - 2; x >= 0; x--) {
            array[lines - 1][x] = s;
            s++;
        }
        for (int y = lines - 2; y > 0; y--) {
            array[y][0] = s;
            s++;
        }

        int y1 = 1;
        int x1 = 1;

        while (s < lines * columns) {
            while (array[y1][x1 + 1] == 0) {
                array[y1][x1] = s;
                s++;
                x1++;
            }
            while (array[y1 + 1][x1] == 0) {
                array[y1][x1] = s;
                s++;
                y1++;
            }
            while (array[y1][x1 - 1] == 0) {
                array[y1][x1] = s;
                s++;
                x1--;
            }
            while (array[y1- 1][x1] == 0) {
                array[y1][x1] = s;
                s++;
                y1--;
            }
        }
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < columns; x++) {
                if (array[y][x] == 0) {
                    array[y][x] = s;
                }
            }
        }



        

        for (int x = 0; x < lines; x++) {
            for (int y = 0; y < columns; y++) {
             System.out.print(array[x][y] + "\t");

            }
            System.out.println();
        }
    }
}



