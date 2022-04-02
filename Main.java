import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        printMenu();

        while (true) {

            byte command = scanner.nextByte();
            if (command == 1) {
                System.out.println("Введите месяц");
                String monthName = scanner.next();
                System.out.println("За какой день будем добавлять количество шагов?");
                byte day = scanner.nextByte();
                System.out.println("Введите количество шагов");
                int step = scanner.nextInt();

                stepTracker.saveStep(monthName, day, step);

            } else if (command == 2) {
                System.out.println("Введите месяц");
                String monthName = scanner.next();
                stepTracker.printStep(monthName);
                System.out.println("Общее количество шагов за месяц " + monthName.toLowerCase() + " " + stepTracker.countStep(monthName));
                System.out.println("Максимальное пройденное количество шагов в месяце " + monthName.toLowerCase() + " " + stepTracker.maxMonthStep(monthName));
                System.out.println("Среднее количество шагов за месяц " + monthName.toLowerCase() + " " + stepTracker.averageSteps(monthName));
                System.out.println("Пройденная дистанция за месяц " + monthName.toLowerCase() + " " + converter.converterSteps(monthName));
                System.out.println("Сожженных ккал за месяц " + monthName.toLowerCase() + " " + converter.converterCalories(monthName));
            } else if (command == 3) {

            } else if (command == 4) {
                break;
            } else
                System.out.println("Неверная команда");
            printMenu();

        }
    }

    public static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения.");
    }
}
