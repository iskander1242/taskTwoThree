package com.red.util;

import com.red.util.exception.RandomWrapperException;

import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

import static com.red.util.Messages.LIST_RESTRICTION;
import static com.red.util.Messages.MAX_BOUND;
import static com.red.util.Messages.MAX_MUST_BE_GREATER_OR_EQUAL_TO_ZERO;

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
            throw new RandomWrapperException(LIST_RESTRICTION);
        }
        /**
         *  Возвращает OptionalInt
         */
        OptionalInt optionalInt = RANDOM.ints(0, list.size()).findFirst();
        /**
         *  Возвращает значание или бросает исключение
         */
        int index = optionalInt.orElseThrow(RandomWrapperException::new);
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
            throw new RandomWrapperException(LIST_RESTRICTION);
        }
        if (min < 0 || min >= max) {
            throw new RandomWrapperException(MAX_MUST_BE_GREATER_OR_EQUAL_TO_ZERO);
        }
        if (max > list.size()) {
            throw new RandomWrapperException(MAX_BOUND);
        }

        /**
         *  Возвращает OptionalInt
         */
        OptionalInt optionalInt = RANDOM.ints(min, max).findFirst();
        /**
         *  Возвращает значание или бросает исключение
         */
        int index = optionalInt.orElseThrow(RandomWrapperException::new);
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
            throw new RandomWrapperException(MAX_MUST_BE_GREATER_OR_EQUAL_TO_ZERO);
        }
        return RANDOM.nextInt((max - min)) + min;
    }

}

