package Semestrovka1;

import java.util.Scanner;

public class OrderBookDemo {
    public static void main(String[] args) {
        /* суть программы — хранить набор цен и уметь быстро с ними работать:
        добавлять новые, искать, удалять и выводить в отсортированном виде.

        программа моделирует упрощённый биржевой стакан — это список заявок по разным ценам, который показывает
        текущую ситуацию на рынке.Пользователь может управлять этими заявками через меню, а также узнавать
        минимальную цену и общее количество заявок.

        для хранения данных используется AA-дерево, так как оно всегда поддерживает элементы в отсортированном виде
        и автоматически балансируется. Благодаря этому все операции выполняются быстро и остаются эффективными
        даже при увеличении количества данных.
        */
        AATree orderBook = new AATree();
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        System.out.println("=== БИРЖЕВОЙ ТЕРМИНАЛ ===");

        while (true) {
            System.out.println("выберите действие:");
            System.out.println("1. добавить заявку");
            System.out.println("2. найти заявку");
            System.out.println("3. удалить заявку");
            System.out.println("4. показать стакан");
            System.out.println("5. лучшая цена (минимальная)");
            System.out.println("6. количество заявок в системе");
            System.out.println("0. выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("введите цену в долларах: ");
                    int price = scanner.nextInt();
                    if (orderBook.find(price)) {
                        System.out.println("такая цена уже есть");
                    } else {
                        orderBook.insert(price);
                        size++;
                        System.out.println("заявка добавлена");
                    }
                    break;

                case 2:
                    System.out.print("введите цену для поиска: ");
                    int findPrice = scanner.nextInt();
                    if (orderBook.find(findPrice)) {
                        System.out.println("заявка найдена");
                    } else {
                        System.out.println("заявка не найдена");
                    }
                    break;

                case 3:
                    System.out.print("введите цену для удаления: ");
                    int deletePrice = scanner.nextInt();

                    if (orderBook.find(deletePrice)) {
                        orderBook.delete(deletePrice);
                        size--;
                        System.out.println("заявка удалена");
                    } else {
                        System.out.println("заявка не найдена");
                    }
                    break;

                case 4:
                    System.out.print("текущий стакан: ");
                    orderBook.printInOrder();
                    break;

                case 5:
                    try {
                        System.out.println("лучшая цена: " + orderBook.findMin() + "$");
                    } catch (Exception e) {
                        System.out.println("стакан пуст");
                    }
                    break;

                case 6:
                    System.out.println("всего активных заявок: " + size);
                    break;

                case 0:
                    System.out.println("пока-пока");
                    return;

                default:
                    System.out.println("неизвестная команда");
            }
        }
    }
}