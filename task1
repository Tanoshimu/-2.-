#include <iostream>

// Определение узла списка
struct ListNode {
    int val;
    ListNode* next;
    
    ListNode(int val) : val(val), next(nullptr) {}
};

class LinkedListReverse {
public:
    // Метод для разворота односвязного списка (итеративный подход)
    static ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* current = head;
        
        while (current != nullptr) {
            ListNode* nextTemp = current->next; // Сохраняем следующий узел
            current->next = prev;               // Разворачиваем указатель
            prev = current;                     // Перемещаем prev на текущий
            current = nextTemp;                 // Перемещаем current на следующий
        }
        
        return prev; // Новый головной узел
    }
    
    // Метод для разворота односвязного списка (рекурсивный подход)
    static ListNode* reverseListRecursive(ListNode* head) {
        // Базовый случай: пустой список или один элемент
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        
        // Рекурсивно разворачиваем остальную часть списка
        ListNode* newHead = reverseListRecursive(head->next);
        
        // Разворачиваем текущий указатель
        head->next->next = head;
        head->next = nullptr;
        
        return newHead;
    }
    
    // Вспомогательный метод для печати списка
    static void printList(ListNode* head) {
        ListNode* current = head;
        while (current != nullptr) {
            std::cout << current->val << " -> ";
            current = current->next;
        }
        std::cout << "null" << std::endl;
    }
    
    // Вспомогательный метод для очистки памяти
    static void deleteList(ListNode* head) {
        while (head != nullptr) {
            ListNode* temp = head;
            head = head->next;
            delete temp;
        }
    }
};

// Пример использования
int main() {
    // Создаем список: 1 -> 2 -> 3 -> 4 -> 5
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);
    
    std::cout << "Исходный список:" << std::endl;
    LinkedListReverse::printList(head);
    
    // Разворачиваем список итеративно
    ListNode* reversedHead = LinkedListReverse::reverseList(head);
    std::cout << "Развернутый список (итеративно):" << std::endl;
    LinkedListReverse::printList(reversedHead);
    
    // Разворачиваем обратно рекурсивно
    ListNode* originalHead = LinkedListReverse::reverseListRecursive(reversedHead);
    std::cout << "Восстановленный список (рекурсивно):" << std::endl;
    LinkedListReverse::printList(originalHead);
    
    // Очищаем память
    LinkedListReverse::deleteList(originalHead);
    
    return 0;
}
