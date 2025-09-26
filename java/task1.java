// Определение узла списка
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListReverse {
    
    // Метод для разворота односвязного списка (итеративный подход)
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next; // Сохраняем следующий узел
            current.next = prev;              // Разворачиваем указатель
            prev = current;                   // Перемещаем prev на текущий
            current = nextTemp;               // Перемещаем current на следующий
        }
        
        return prev; // Новый головной узел
    }
    
    // Метод для разворота односвязного списка (рекурсивный подход)
    public static ListNode reverseListRecursive(ListNode head) {
        // Базовый случай: пустой список или один элемент
        if (head == null || head.next == null) {
            return head;
        }
        
        // Рекурсивно разворачиваем остальную часть списка
        ListNode newHead = reverseListRecursive(head.next);
        
        // Разворачиваем текущий указатель
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    // Вспомогательный метод для печати списка
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Пример использования
    public static void main(String[] args) {
        // Создаем список: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Исходный список:");
        printList(head);
        
        // Разворачиваем список итеративно
        ListNode reversedHead = reverseList(head);
        System.out.println("Развернутый список (итеративно):");
        printList(reversedHead);
        
        // Разворачиваем обратно рекурсивно
        ListNode originalHead = reverseListRecursive(reversedHead);
        System.out.println("Восстановленный список (рекурсивно):");
        printList(originalHead);
    }
}
