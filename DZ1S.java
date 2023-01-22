//    1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2


import java.util.Random;
import java.util.Arrays;

public class DZ1S {
    private static int getRandom() {
        int rnd = new Random().nextInt(2001);
        return rnd;
    }

    private static int getHeadBit(int tmp) {
        int bit = Integer.toBinaryString(tmp).length();
        return bit;
    }

    private static void getArray1(int a, int b) {
        int[] arr1 = new int[0];
        for (int i = a; i < Short.MAX_VALUE; i++) {
            if (i % b == 0) {
                int[] tmp = Arrays.copyOf(arr1, arr1.length + 1);
                tmp[arr1.length] = i;
                arr1 = tmp;
                arr1[arr1.length - 1] = i;
            }
        }
        System.out.println(Arrays.toString(arr1));
    }

    private static void getArray2(int a, int b) {
        int[] arr2 = new int[0];
        for (int i = Short.MIN_VALUE; i < a; i++) {
            if (i % b != 0) {
                int[] tmp = Arrays.copyOf(arr2, arr2.length + 1);
                tmp[arr2.length] = i;
                arr2 = tmp;
                arr2[arr2.length - 1] = i;
            }
        }
        System.out.println(Arrays.toString(arr2));
    }


    public static void main(String[] args) {
        int i = getRandom();
        int n = getHeadBit(i);

        System.out.println("Случайное целое число = " + i);
        System.out.println("Номер старшего значащего бита выпавшего числа = " + n);
        System.out.println("Все кратные n числа в диапазоне от i до Short.MAX_VALUE: ");
        getArray1(i, n);
        System.out.println("Все некратные n числа в диапазоне от Short.MIN_VALUE до i: ");
        getArray2(i, n);


    }

}