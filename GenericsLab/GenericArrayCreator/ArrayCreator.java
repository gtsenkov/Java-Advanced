package GenericsLab.GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {


    public static <T> T[] create(int length, T element) {

        T[] array = (T[]) new Object[length];
        for (int i = 0; i < array.length; i++) {

            array[i] = element;

        }
        return array;

    }

    public static <T> T[] create(
            Class<T> cl, int length, T item) {
        T[] array = (T[]) Array.newInstance(cl, length);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }

    // ОТ ЛЕКЦИЯТА - МИНАВА САМО 0 ТЕСТ

//        Object arr = Array.newInstance(element.getClass(), length);
//
//        return (T[]) arr;
//    }

//    public static <T> T[] create(Class<T> clazz, int length, T item) {
//        return (T[])Array.newInstance(clazz, length);

}

