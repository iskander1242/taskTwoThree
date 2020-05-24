package com.red.util;

import com.red.util.exception.RandomWrapperException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private static final Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        new Runner().input();
    }

    /**
     * Shows setup menu.
     */
    private void input() {

        try (Scanner scanner = new Scanner(System.in)) {

            logger.info(RANDOM_LIST_ITEM);
            logger.info(RANDOM_LIST_ITEM_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_INDEX);
            logger.info(RANDOM_POSITIVE_INTEGER_FROM_MIN_INCLUSIVE_TO_MAX_EXCLUSIVE_COMPATIBLE_WITH_JAVA_7);

            logger.info("Please enter your choice:...");

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
                    logger.info("Invalid choice");
            }
        } finally {
            logger.info("System fail. Rerun your app");
        }
    }

    private void printRandomListItem(Scanner scanner) {

        logger.info(ENTER_STRING_LIKE_STRING_1_STRING_2);

        while (scanner.hasNextLine()) {
            try {

                logger.info(RANDOM + RandomUtil.getRandomItem(readLine(scanner)));
            } catch (Exception e) {
                logger.info(DATA_INPUT_ERROR + e.getMessage());
            }
            logger.info(ENTER_STRING_LIKE_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT);
        }
    }

    private void printRandomListItemFromRange(Scanner scanner) {
        List<String> paramList;
        logger.info(ENTER_STRING_LIKE_1_10_STRING_1_STRING_2);

        while (scanner.hasNextLine()) {
            try {
                paramList = readLine(scanner);

                String random = RandomUtil.getRandomItem(
                        Integer.parseInt(paramList.get(0)),
                        Integer.parseInt(paramList.get(1)),
                        paramList.subList(2, paramList.size()));

                logger.info(RANDOM + random);
            } catch (Exception e) {
                logger.info(DATA_INPUT_ERROR + e.getMessage());
            }
            logger.info(ENTER_STRING_LIKE_1_10_STRING_1_STRING_2_OR_CTRL_C_FOR_EXIT);
        }
    }

    private void printRandomIntFromRange(Scanner scanner) {

        List<String> paramList;
        logger.info(ENTER_STRING_LIKE_1_10);

        while (scanner.hasNextLine()) {
            try {
                paramList = readLine(scanner);

                logger.info(RANDOM + RandomUtil.getRandomPositive(Integer.parseInt(paramList.get(0)),
                        Integer.parseInt(paramList.get(1))));
            } catch (Exception e) {
                logger.info(DATA_INPUT_ERROR + e.getMessage());
            }
            logger.info(ENTER_STRING_LIKE_1_10_OR_CTRL_C_FOR_EXIT);
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
