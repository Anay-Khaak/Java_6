// Задание 1. Поиск ноутбуков
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
// -Создать множество ноутбуков.
// -Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
// Например:
// Введите цифру, соответствующую необходимому критерию: 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет ...
// -Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Подсказка No 1
// Каждый ноутбук имеет определенные характеристики. Определите, какие поля вам нужны для хранения информации о ноутбуке. Например, вам могут понадобиться поля для объема оперативной памяти, жесткого диска, операционной системы и цвета.
// Подсказка No 2
// Создайте конструктор для инициализации полей и методы для получения значений этих полей. Это поможет вам создавать и управлять объектами класса Laptop.
// Подсказка No 3
// Используйте коллекцию Set для хранения множества ноутбуков. Это позволит вам хранить уникальные ноутбуки и легко манипулировать данными.
// Подсказка No 4
// Создайте меню, позволяющее пользователю выбирать критерии фильтрации. Используйте Scanner для ввода данных от пользователя.
// Подсказка No 5
// Используйте Map для хранения выбранных пользователем критериев фильтрации и их значений. Это облегчит работу с фильтрами при отборе ноутбуков.
// Подсказка No 6
// Создайте метод для фильтрации ноутбуков. В этом методе проверяйте, соответствуют ли ноутбуки критериям фильтрации, и выводите те, которые проходят отбор.
// Подсказка No 7
// После каждого выбора критерия спросите у пользователя, хочет ли он добавить еще один критерий. Используйте цикл while для продолжения запроса до тех пор, пока пользователь не закончит ввод.



import java.util.*;
public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(8, 512, "Windows 10", "Black"));
        laptops.add(new Laptop(16, 1024, "Windows 11", "Silver")); 
        laptops.add(new Laptop(8, 256, "Ubuntu", "Black")); 
        laptops.add(new Laptop(32, 1024, "macOS", "Gray")); 
        laptops.add(new Laptop(16, 512, "Windows 10", "White"));
        Map<Integer, String> criteria = new HashMap<>(); 
        criteria.put(1, "ОЗУ");
        criteria.put(2, "Объем ЖД");
        criteria.put(3, "Операционная система"); 
        criteria.put(4, "Цвет");
        Scanner scanner = new Scanner(System.in); 
        Map<String, Object> filters = new HashMap<>();
        boolean continueFiltering = true;
        while (continueFiltering) { 
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            int criterion = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера от символа новой строки
            switch (criterion) { 
            case 1:
                System.out.print("Введите минимальное значениЗУ (в ГБ): ");
                filters.put("ram", scanner.nextInt());
                scanner.nextLine(); // Очистка буфера от символа новой строки
                   break;
            case 2:
                System.out.print("Введите минимальное значение объема ЖД (в ГБ): ");
               filters.put("hdd", scanner.nextInt()); 
               scanner.nextLine(); // Очистка буфера от символа новой строки
               break;
            case 3:
                System.out.print("Введите операционную систему:");
                filters.put("os", scanner.nextLine());
                break;
            case 4:
            System.out.print("Введите цвет: "); 
            filters.put("color", scanner.nextLine()); 
            break;
        default:
            System.out.println("Некорректный критерий.");
    }
    System.out.print("Хотите добавить еще один критерий? (да/нет): ");
    String response = scanner.nextLine();
    continueFiltering = response.equalsIgnoreCase("да"); 
    }
    filterLaptops(laptops, filters); 
}
    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        for (Laptop laptop : laptops) { 
            boolean matches = true;
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                matches = false; 
            }
            if (filters.containsKey("hdd") && laptop.getHdd() < (int) filters.get("hdd")) {
                matches = false; 
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false; 
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String)
filters.get("color"))) 
            { 
                matches = false;
    }
    if (matches) { 
         System.out.println(laptop);
} }
} }