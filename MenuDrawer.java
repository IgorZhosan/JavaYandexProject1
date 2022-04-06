import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDrawer {

    void start() {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter(stepTracker);
        printMenu();

        while (true) {


                String command = scanner.next();


                if (command.contains("1")) {
                    System.out.println("Введите месяц");
                    String monthName = scanner.next();
                    System.out.println("За какой день будем добавлять количество шагов?");
                    byte day = scanner.nextByte();
                    System.out.println("Введите количество шагов");
                    int step = scanner.nextInt();

                    stepTracker.saveStep(monthName, day, step);

                } else if (command.contains("2")) {
                    System.out.println("Введите месяц");
                    String monthName = scanner.next();
                    stepTracker.printStep(monthName);
                    System.out.println("Общее количество шагов за месяц " + monthName.toLowerCase() + " " + stepTracker.countStep(monthName));
                    System.out.println("Максимальное пройденное количество шагов в месяце " + monthName.toLowerCase() + " " + stepTracker.maxMonthStep(monthName));
                    System.out.println("Среднее количество шагов за месяц " + monthName.toLowerCase() + " " + stepTracker.averageSteps(monthName));
                    System.out.println("Пройденная дистанция за месяц " + monthName.toLowerCase() + " " + converter.converterSteps(monthName));
                    System.out.println("Сожженных ккал за месяц " + monthName.toLowerCase() + " " + converter.converterCalories(monthName));
                    System.out.println("Лучшая серия подряд идущих дней месяца " + monthName.toLowerCase() + ", шаги которого были выше целевого: " + stepTracker.bestSeries(monthName));
                } else if (command.contains("3")) {
                    System.out.println("Какое значение станет целевым за месяц?");
                    double step = scanner.nextDouble();
                    stepTracker.setStepMonth(step);
                    System.out.println("Целевое значение изменилось на: " + stepTracker.getStepMonth());
                } else if (command.contains("4")) {
                    break;
                } else
                    System.out.println("Неверная команда, введите число от 1 до 4");

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


