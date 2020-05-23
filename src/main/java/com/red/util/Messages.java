package com.red.util;

/**
 * Enum for messages
 *
 * @author Alexander Sokolov
 * @since 2020-05-23
 */
public enum Messages {
    /**
     * Suggestions
     */
    ENTER_STRING_LIKE_1_10_OR_CTRL_C_FOR_EXIT("Please enter string like 1 10 or Ctrl+C for exit"),
    ENTER_STRING_LIKE_1_10("Please enter string like 1 10"),
    ENTER_STRING_LIKE_1_10_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT("Please enter string like 1 10 string1 string2... or Ctrl+C for exit"),
    ENTER_STRING_LIKE_1_10_STRING_1_STRING_2("Please enter string like 1 10 string1 string2..."),
    ENTER_STRING_LIKE_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT("Please enter string like string1 string2... or Ctrl+C for exit"),
    ENTER_STRING_LIKE_STRING_1_STRING_2("Please enter string like string1 string2..."),
    /**
     * Runner warnings
     */
    DATA_INPUT_ERROR("Warning data input error: "),
    STRING_MUST_NOT_BE_EMPTY("String must not be empty"),
    /**
     * Menu
     */
    RANDOM_LIST_ITEM("1\t Gets a random list item"),
    RANDOM_LIST_ITEM_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_INDEX("2\t Gets a random list item from min(inclusive) to max(exclusive) index"),
    RANDOM_POSITIVE_INTEGER_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_COMPATIBLE_WITH_JAVA_7("3\t Generates a random positive integer from min(inclusive) to max(exclusive), compatible with Java 7"),
    /**
     * RandomUtil warnings
     */
    MAX_BOUND("max must be less then list size"),
    LIST_RESTRICTION("list must be not null or empty"),
    MAX_MUST_BE_GREATER_OR_EQUAL_TO_ZERO("max must be greater than min and min must be greater or equal to zero");


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
