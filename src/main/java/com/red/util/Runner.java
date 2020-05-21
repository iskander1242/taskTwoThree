package com.red.util;

import java.util.List;
import java.util.Scanner;

/**
 * Class runner for getting and print random value.
 *
 * @author Alexander Sokolov
 * @since 2020-05-20
 */
public class Runner {

    private final String DELIMITER = "\\s+";
    private final String WARNING = "Warning data input error: ";
    private final String RANDOM = "Random: ";

    public static void main(String[] args) {
        new Runner().input();
    }

    /**
     * Shows setup menu.
     */
    private void input() {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("1\t Gets a random list item");
            System.out.println("2\t Gets a random list item from min(inclusive) to max(exclusive) index");
            System.out.println("3\t Generates a random positive integer from min(inclusive) to max(exclusive), compatible with Java 7");

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

        System.out.println("Please enter string like string1 string2...");

        while (scanner.hasNextLine()) {
            try {

                System.out.println(RANDOM + RandomUtil.getRandomItem(readLine(scanner)));
            } catch (Exception e) {
                System.out.println(WARNING + e.getMessage());
            }
            System.out.println("Please enter string like string1 string2... or Ctrl+C for exit");
        }
    }

    private void printRandomListItemFromRange(Scanner scanner) {
        List<String> paramList;
        System.out.println("Please enter string like 1 10 string1 string2...");

        while (scanner.hasNextLine()) {
            try {
                paramList = readLine(scanner);

                String random = RandomUtil.getRandomItem(
                        Integer.parseInt(paramList.get(0)),
                        Integer.parseInt(paramList.get(1)),
                        paramList.subList(2, paramList.size()));

                System.out.println(RANDOM + random);
            } catch (Exception e) {
                System.out.println(WARNING + e.getMessage());
            }
            System.out.println("Please enter string like 1 10 string1 string2... or Ctrl+C for exit");
        }
    }

    private void printRandomIntFromRange(Scanner scanner) {

        List<String> paramList;
        System.out.println("Please enter string like 1 10");

        while (scanner.hasNextLine()) {
            try {
                paramList = readLine(scanner);

                System.out.println(RANDOM + RandomUtil.getRandomPositive(Integer.parseInt(paramList.get(0)),
                        Integer.parseInt(paramList.get(1))));
            } catch (Exception e) {
                System.out.println(WARNING + e.getMessage());
            }
            System.out.println("Please enter string like 1 10 or Ctrl+C for exit");
        }
    }

    private List<String> readLine(Scanner scanner) {

        final String line = scanner.nextLine();
        if (line.isEmpty()) {
            throw new IllegalArgumentException("String must not be empty");
        }
        return List.of(line.split(DELIMITER));
    }
}
