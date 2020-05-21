package com.red.util;

import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

/**
 * Class helper for getting random value.
 *
 * @author Alexander Sokolov
 * @since 2020-05-17
 */
public class RandomUtil {

    private static final Random RANDOM = new Random();

    /**
     * Gets a random list item.
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getRandomItem(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("list must be not null or empty");
        }
        /**
         *  Возвращает OptionalInt
         */
        OptionalInt optionalInt = RANDOM.ints(0, list.size()).findFirst();
        /**
         *  Возвращает значание или бросает исключение
         */
        int index = optionalInt.orElseThrow(IllegalArgumentException::new);
        return list.get(index);
    }

    /**
     * Gets a random list item from min(inclusive) to max(exclusive) index.
     *
     * @param min
     * @param max
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getRandomItem(int min, int max, List<T> list) {

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("list must be not null or empty");
        }
        if (min < 0 || min >= max) {
            throw new IllegalArgumentException("max must be greater than min and min must be greater or equal to zero");
        }
        if (max > list.size()) {
            throw new IllegalArgumentException("max must be less then list size");
        }

        /**
         *  Возвращает OptionalInt
         */
        OptionalInt optionalInt = RANDOM.ints(min, max).findFirst();
        /**
         *  Возвращает значание или бросает исключение
         */
        int index = optionalInt.orElseThrow(IllegalArgumentException::new);
        return list.get(index);
    }

    /**
     * Generates a random positive integer from min(inclusive) to max(exclusive).
     * Compatible with Java 7.
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandomPositive(int min, int max) {

        if (min < 0 || min >= max) {
            throw new IllegalArgumentException("max must be greater than min and min must be greater or equal to zero");
        }
        return RANDOM.nextInt((max - min)) + min;
    }

}

