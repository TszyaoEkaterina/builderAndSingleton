package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int N;//размер списка
    static int M;//верхняя граница значений элементов в списке

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка: ");
        N = scanner.nextInt();
        System.out.println("Введите верхнюю границу для значений: ");
        M = scanner.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> source = new ArrayList<>();
        System.out.print("Вот случайный список:");
        for (int i = 0; i < N; i++) {
            source.add(random.nextInt(M));
            System.out.print(" " + source.get(i));
        }
        System.out.println();
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        int f = scanner.nextInt();
        Filter filter = new Filter(f);
        logger.log("Запускаем фильтрацию");
        List<Integer> newList = filter.filterOut(source);
        logger.log(String.format("Прошло фильтр %d элемента из %d", newList.size(), source.size()));
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список:");
        for (int i = 0; i < newList.size(); i++) {
            System.out.print(" " + newList.get(i));
        }
        System.out.println();
        logger.log("Завершаем программу");
    }
}
