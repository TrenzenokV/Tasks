
public class Task1 {
    static void myQuicksort(double[] array, int left, int right) {
        int i = left;
        int j = right;
        double temp, comp;
        comp = array[(left + right) / 2];
        do {
            while ((array[i] < comp) && (i < right))
                i++;
            while ((array[j] > comp) && (j > left))
                j--;
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j)
            myQuicksort(array, left, j);
        if (right > i)
            myQuicksort(array, i, right);
    }
    static void QuickSort(double[] array, int n) {
        if (n != 0)
            myQuicksort(array, 0, n - 1);
    }
    public static void main(String[] args) {
        double array[] = new double[args.length];
        for (int i = 0; i < args.length; ++i) {
            array[i] = Double.parseDouble(args[i]);
        }
        QuickSort(array, args.length);
        for (int i = 0; i < args.length; ++i) {
            System.out.print(array[i]);
            System.out.print("\n");
        }
        return;
    }
}
