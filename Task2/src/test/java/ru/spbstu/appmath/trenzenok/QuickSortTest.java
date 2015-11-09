package ru.spbstu.appmath.trenzenok;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

@RunWith(Parameterized.class)

public class QuickSortTest<T> {

    private static  final Comparator<Car> CAR_ENGINEPOWER_COMPARATOR = new CarEnginePowerComparator();
    private static  final Comparator<Car> CAR_MODEL_COMPARATOR = new CarModelComparator();
    private static  final Comparator<Car> CAR_BIRTHYEAR_COMPARATOR = new CarBirthYearComparator();

    private static final Comparator<Double> DOUBLE_COMPARATOR = new Comparator<Double>() {
        public int compare(final Double o1, final Double o2) {
            return o1.compareTo(o2);
        }
    };
    private static final QuickSort QUICK_SORT = new QuickSort();

    private static Object[][] TEST_DATA = {
            {QUICK_SORT, CAR_ENGINEPOWER_COMPARATOR, new Car[]{}},
            {QUICK_SORT, CAR_MODEL_COMPARATOR, new Car[]{new Car("mercedes", 2010, 220.8), new Car("audi", 2009, 450.5), new Car("bmw", 2011, 245)}},
            {QUICK_SORT, CAR_BIRTHYEAR_COMPARATOR, new Car[]{new Car("toyota", 2015, 150.7), new Car("nissan", 2014, 300)}},
            {QUICK_SORT, CAR_ENGINEPOWER_COMPARATOR, new Car[]{new Car("honda", 2003, 100), new Car("mazda", 2007, 98.7), new Car("ferrari", 2003, 480)}},
            {QUICK_SORT, DOUBLE_COMPARATOR,doubleDataInit()}
    };

    private static Double[] doubleDataInit() {
        Double[] array = new Double[4];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.floor(random.nextDouble() * 200.0) / 30.0 - 5.0;
        }
        return array;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
          return Arrays.asList(TEST_DATA);
    }

    private Sort<T> sort;
    private T[] input;
    private Comparator<T> comparator;

    public QuickSortTest(Sort<T> sort, Comparator<T> comparator, T[] input) {
        this.sort = sort;
        this.comparator = comparator;
        this.input = input;
    }

    @Test
    public void test() {

        T[] result = sort.sort(input, comparator);

        Assert.assertTrue("The array isn't sorted", testAscendingOrder(result, comparator));
        Assert.assertEquals("Result array length should be equal to original", input.length, result.length);
        Assert.assertTrue(hasEachElementOf(input, result, comparator));
        Assert.assertTrue("Input array differs from Result array", hasSameNumberOfEachElement(input, result, comparator));
    }

    private boolean testAscendingOrder(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i],array[i+1]) > 0)
                return false;
        }
        return true;
    }

    private boolean hasEachElementOf(T[] input, T[] result, Comparator<T> comparator) {
        for (T element : input) {
            for (int j = 0; j < result.length; j++) {
                if (comparator.compare(result[j],element) == 0)
                    break;
                if (j == result.length - 1)
                    return false;
            }
        }
        return true;
    }

    private boolean hasSameNumberOfEachElement(T[] input, T[] result, Comparator<T> comparator) {
        for(T element : input){
            int numOfElementInInput = 0;
            int numOfElementInResult = 0;
            for(int j = 0; j < input.length; ++j){
                if(comparator.compare(element,input[j]) == 0)
                    numOfElementInInput++;
            }
            for(int i = 0; i < result.length; ++i){
                if(comparator.compare(element,result[i]) == 0)
                    numOfElementInResult++;
            }
            if(numOfElementInInput != numOfElementInResult)
                return false;
        }
        return true;
    }
}
