import java.util.HashSet;

// Определение узла списка
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// Убираем public - теперь класс имеет доступ по умолчанию
class LinkedListDuplicates {
    
    // Метод для проверки наличия дубликатов (с использованием HashSet)
    public static boolean hasDuplicates(ListNode head) {
        if (head == null) {
            return false;
        }
        
        HashSet<Integer> seen = new HashSet<>();
        ListNode current = head;
        
        while (current != null) {
            if (!seen.add(current.val)) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    // Метод для проверки наличия дубликатов (без дополнительной памяти - O(n²))
    public static boolean hasDuplicatesNoExtraMemory(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode current = head;
        
        while (current != null) {
            ListNode runner = current.next;
            while (runner != null) {
                if (current.val == runner.val) {
                    return true;
                }
                runner = runner.next;
            }
            current = current.next;
        }
        
        return false;
    }
    
    // Вспомогательный метод для создания списка из массива
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    // Вспомогательный метод для печати списка
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
    
    // Пример использования
    public static void main(String[] args) {
        System.out.println("=== Тестирование поиска дубликатов в односвязном списке ===\n");
        
        // Тест 1: Список без дубликатов
        int[] values1 = {1, 2, 3, 4, 5};
        ListNode list1 = createList(values1);
        
        System.out.println("Тест 1 - Список без дубликатов:");
        printList(list1);
        System.out.println("Метод с HashSet: " + hasDuplicates(list1));
        System.out.println("Метод без доп. памяти: " + hasDuplicatesNoExtraMemory(list1));
        System.out.println();
        
        // Тест 2: Список с дубликатами
        int[] values2 = {1, 2, 3, 2, 5};
        ListNode list2 = createList(values2);
        
        System.out.println("Тест 2 - Список с дубликатами:");
        printList(list2);
        System.out.println("Метод с HashSet: " + hasDuplicates(list2));
        System.out.println("Метод без доп. памяти: " + hasDuplicatesNoExtraMemory(list2));
        System.out.println();
        
        // Тест 3: Пустой список
        ListNode list3 = null;
        
        System.out.println("Тест 3 - Пустой список:");
        printList(list3);
        System.out.println("Метод с HashSet: " + hasDuplicates(list3));
        System.out.println("Метод без доп. памяти: " + hasDuplicatesNoExtraMemory(list3));
        System.out.println();
        
        // Тест 4: Список из одного элемента
        int[] values4 = {1};
        ListNode list4 = createList(values4);
        
        System.out.println("Тест 4 - Список из одного элемента:");
        printList(list4);
        System.out.println("Метод с HashSet: " + hasDuplicates(list4));
        System.out.println("Метод без доп. памяти: " + hasDuplicatesNoExtraMemory(list4));
        System.out.println();
        
        // Тест 5: Список с несколькими дубликатами
        int[] values5 = {1, 1, 2, 3, 3, 4};
        ListNode list5 = createList(values5);
        
        System.out.println("Тест 5 - Список с несколькими дубликатами:");
        printList(list5);
        System.out.println("Метод с HashSet: " + hasDuplicates(list5));
        System.out.println("Метод без доп. памяти: " + hasDuplicatesNoExtraMemory(list5));
    }
}
