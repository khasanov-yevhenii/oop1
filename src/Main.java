import java.util.Scanner;

public class Main {
    public static double calculateExp(double a) {
        return Math.exp(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            System.out.print("Введіть початкове значення аргументу (Aнач): ");
            double start = scanner.nextDouble();

            if (start < -5 || start > 5) {
                System.out.println("Помилка: (Aнач) має бути у діапазоні від -5 до 5.");
                System.exit(1);
            }

            System.out.print("Введіть кінцеве значення аргументу (Акон): ");
            double end = scanner.nextDouble();

            if (end < -5 || end > 5) {
                System.out.println("Помилка: (Акон) має бути у діапазоні від -5 до 5.");
                System.exit(1);
            } else if (end < start) {
                System.out.println("Помилка: (Акон) має бути більше або дорівнювати (Aнач).");
                System.exit(1);
            }

            System.out.print("Введіть крок зміни аргументу (Δа): ");
            double step = scanner.nextDouble();

            System.out.print("Введіть кількість знаків після коми для форматування результатів: ");
            int decimalPlaces = scanner.nextInt();

            String format = "+-------------+-------------------+";
            String headerFormat = "| %-11s | %-17s|\n";
            String rowFormat = "| %-11." + decimalPlaces + "f | %-17." + decimalPlaces + "f |\n";

            System.out.println(format);
            System.out.printf(headerFormat, "Аргумент (a)", "Значення exp(a)");
            System.out.println(format);

            for (double a = start; a <= end; a += step) {
                double expValue = calculateExp(a);
                System.out.printf(rowFormat, a, expValue);
            }

            System.out.println(format);

            do {
                System.out.println("\nЩоб продовжити, введіть 'continue'. Для завершення програми введіть 'exit'.");
                userInput = scanner.next();

                if (!userInput.equalsIgnoreCase("continue") && !userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Невідома команда! Введіть 'continue' для продовження або 'exit' для завершення.");
                }

            } while (!userInput.equalsIgnoreCase("continue") && !userInput.equalsIgnoreCase("exit"));

        } while (userInput.equalsIgnoreCase("continue"));

        System.out.println("Програму завершено.");
        scanner.close();
    }
}
