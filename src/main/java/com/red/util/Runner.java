package com.red.util;

import com.red.util.exception.RandomWrapperException;

import java.util.List;
import java.util.Scanner;

import static com.red.util.Messages.DATA_INPUT_ERROR;
import static com.red.util.Messages.ENTER_STRING_LIKE_1_10;
import static com.red.util.Messages.ENTER_STRING_LIKE_1_10_OR_CTRL_C_FOR_EXIT;
import static com.red.util.Messages.ENTER_STRING_LIKE_1_10_STRING_1_STRING_2;
import static com.red.util.Messages.ENTER_STRING_LIKE_1_10_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT;
import static com.red.util.Messages.ENTER_STRING_LIKE_STRING_1_STRING_2;
import static com.red.util.Messages.ENTER_STRING_LIKE_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT;
import static com.red.util.Messages.RANDOM_LIST_ITEM;
import static com.red.util.Messages.RANDOM_LIST_ITEM_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_INDEX;
import static com.red.util.Messages.RANDOM_POSITIVE_INTEGER_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_COMPATIBLE_WITH_JAVA_7;

/**
 * Class runner for getting and print random value.
 *
 * @author Alexander Sokolov
 * @since 2020-05-20
 */
public class Runner {

    public static final String DELIMITER = "\\s+";
    public static final String RANDOM = "Random: ";

    public static void main(String[] args) {
        new Runner().input();
    }

    /**
     * Shows setup menu.
     */
    private void input() {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println(RANDOM_LIST_ITEM);
            System.out.println(RANDOM_LIST_ITEM_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_INDEX);
            System.out.println(RANDOM_POSITIVE_INTEGER_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_COMPATIBLE_WITH_JAVA_7);

            System.out.println("Please enter your choice:...");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printRandomListItem(scanner);
                    break;
                case 2:
                    printRandomListItemFromRange(scanner);
                    break;
                case 3:
                    printRandomIntFromRange(scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } finally {
            System.out.println("System fail. Rerun your app");
        }
    }

    private void printRandomListItem(Scanner scanner) {

        System.out.println(ENTER_STRING_LIKE_STRING_1_STRING_2);

        while (scanner.hasNextLine()) {
            try {

                System.out.println(RANDOM + RandomUtil.getRandomItem(readLine(scanner)));
            } catch (Exception e) {
                System.out.println(DATA_INPUT_ERROR + e.getMessage());
            }
            System.out.println(ENTER_STRING_LIKE_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT);
        }
    }

    private void printRandomListItemFromRange(Scanner scanner) {
        List<String> paramList;
        System.out.println(ENTER_STRING_LIKE_1_10_STRING_1_STRING_2);

        while (scanner.hasNextLine()) {
            try {
                paramList = readLine(scanner);

                String random = RandomUtil.getRandomItem(
                        Integer.parseInt(paramList.get(0)),
                        Integer.parseInt(paramList.get(1)),
                        paramList.subList(2, paramList.size()));

                System.out.println(RANDOM + random);
            } catch (Exception e) {
                System.out.println(DATA_INPUT_ERROR + e.getMessage());
            }
            System.out.println(ENTER_STRING_LIKE_1_10_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT);
        }
    }

    private void printRandomIntFromRange(Scanner scanner) {

        List<String> paramList;
        System.out.println(ENTER_STRING_LIKE_1_10);

        while (scanner.hasNextLine()) {
            try {
                paramList = readLine(scanner);

                System.out.println(RANDOM + RandomUtil.getRandomPositive(Integer.parseInt(paramList.get(0)),
                        Integer.parseInt(paramList.get(1))));
            } catch (Exception e) {
                System.out.println(DATA_INPUT_ERROR + e.getMessage());
            }
            System.out.println(ENTER_STRING_LIKE_1_10_OR_CTRL_C_FOR_EXIT);
        }
    }

    private List<String> readLine(Scanner scanner) {

        final String line = scanner.nextLine();
        if (line.isEmpty()) {
            throw new RandomWrapperException(Messages.STRING_MUST_NOT_BE_EMPTY);
        }
        return List.of(line.split(DELIMITER));
    }
}
