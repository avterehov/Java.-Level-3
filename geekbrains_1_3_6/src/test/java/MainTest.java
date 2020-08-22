import org.junit.Test;
import org.junit.Assert;


public class MainTest{

    @Test
    public void test11 () {
        int array[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int expectedArray [] = new int []{ 5, 6, 7};
        Main main = new Main();
        int actualresult[] =  main.returnArray(array);
        Assert.assertArrayEquals(expectedArray, actualresult);
    }

    @Test (expected = RuntimeException.class)
    public void test12 () {

        int array[] = new int[]{1, 2, 3, 3, 5, 6, 7};
        int expectedArray [] = new int []{ 5, 6, 7};
        Main main = new Main();
        int actualresult[] =  main.returnArray(array);
    }

    @Test
    public void test13 () {
        int array[] = new int[]{1, 4, 3, 3, 5, 6, 7};
        int expectedArray [] = new int []{ 3, 3, 5, 6, 7};
        Main main = new Main();
        int actualresult[] =  main.returnArray(array);
        Assert.assertArrayEquals(expectedArray, actualresult);
    }



    @Test
    public void test21 () {
        int array[] = new int[]{1, 1, 1, 1, 1, 1, 4};
        boolean expectedResult  = true;
        Main main = new Main();
        boolean actualresult =  main.checkArray(array);
        Assert.assertEquals(expectedResult, actualresult);
    }


    @Test
    public void test22 () {
        int array[] = new int[]{1, 1, 1, 1, 1, 1, 1};
        boolean expectedResult  = true;
        Main main = new Main();
        boolean actualresult =  main.checkArray(array);
        Assert.assertEquals(expectedResult, actualresult);
    }
    @Test
    public void test23 () {
        int array[] = new int[]{1, 1, 4, 1, 2, 1, 4};
        boolean expectedResult  = true;
        Main main = new Main();
        boolean actualresult =  main.checkArray(array);
        Assert.assertEquals(expectedResult, actualresult);
    }
    }












