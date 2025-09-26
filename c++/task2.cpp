#include <iostream>
#include <unordered_set>

// Определение узла списка
struct ListNode {
    int val;
    ListNode* next;
    
    ListNode(int val) : val(val), next(nullptr) {}
};

class LinkedListDuplicates {
public:
    // Метод для проверки наличия дубликатов (с использованием unordered_set)
    static bool hasDuplicates(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return false;
        }
        
        std::unordered_set<int> seen;
        ListNode* current = head;
        
        while (current != nullptr) {
            if (seen.find(current->val) != seen.end()) {
                return true; // Найден дубликат
            }
            seen.insert(current->val);
            current = current->next;
        }
        
        return false; // Дубликатов нет
    }
    
    // Метод для проверки наличия дубликатов (без дополнительной памяти - O(n²))
    static bool hasDuplicatesNoExtraMemory(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return false;
        }
        
        ListNode* current = head;
        
        while (current != nullptr) {
            ListNode* runner = current->next;
            while (runner != nullptr) {
                if (current->val == runner->val) {
                    return true; // Найден дубликат
                }
                runner = runner->next;
            }
            current = current->next;
        }
        
        return false; // Дубликатов нет
    }
    
    // Вспомогательный метод для создания списка из массива
    static ListNode* createList(int values[], int size) {
        if (size == 0) return nullptr;
        
        ListNode* head = new ListNode(values[0]);
        ListNode* current = head;
        
        for (int i = 1; i < size; i++) {
            current->next = new ListNode(values[i]);
            current = current->next;
        }
        
        return head;
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
    // Тест 1: Список без дубликатов
    int values1[] = {1, 2, 3, 4, 5};
    ListNode* list1 = LinkedListDuplicates::createList(values1, 5);
    
    std::cout << "Список 1:" << std::endl;
    LinkedListDuplicates::printList(list1);
    std::cout << "Есть дубликаты (unordered_set): " << 
        (LinkedListDuplicates::hasDuplicates(list1) ? "true" : "false") << std::endl;
    std::cout << "Есть дубликаты (без доп. памяти): " << 
        (LinkedListDuplicates::hasDuplicatesNoExtraMemory(list1) ? "true" : "false") << std::endl;
    std::cout << std::endl;
    
    // Тест 2: Список с дубликатами
    int values2[] = {1, 2, 3, 2, 5};
    ListNode* list2 = LinkedListDuplicates::createList(values2, 5);
    
    std::cout << "Список 2:" << std::endl;
    LinkedListDuplicates::printList(list2);
    std::cout << "Есть дубликаты (unordered_set): " << 
        (LinkedListDuplicates::hasDuplicates(list2) ? "true" : "false") << std::endl;
    std::cout << "Есть дубликаты (без доп. памяти): " << 
        (LinkedListDuplicates::hasDuplicatesNoExtraMemory(list2) ? "true" : "false") << std::endl;
    std::cout << std::endl;
    
    // Тест 3: Пустой список
    ListNode* list3 = nullptr;
    
    std::cout << "Список 3: пустой" << std::endl;
    std::cout << "Есть дубликаты (unordered_set): " << 
        (LinkedListDuplicates::hasDuplicates(list3) ? "true" : "false") << std::endl;
    std::cout << "Есть дубликаты (без доп. памяти): " << 
        (LinkedListDuplicates::hasDuplicatesNoExtraMemory(list3) ? "true" : "false") << std::endl;
    std::cout << std::endl;
    
    // Тест 4: Список из одного элемента
    int values4[] = {1};
    ListNode* list4 = LinkedListDuplicates::createList(values4, 1);
    
    std::cout << "Список 4:" << std::endl;
    LinkedListDuplicates::printList(list4);
    std::cout << "Есть дубликаты (unordered_set): " << 
        (LinkedListDuplicates::hasDuplicates(list4) ? "true" : "false") << std::endl;
    std::cout << "Есть дубликаты (без доп. памяти): " << 
        (LinkedListDuplicates::hasDuplicatesNoExtraMemory(list4) ? "true" : "false") << std::endl;
    std::cout << std::endl;
    
    // Тест 5: Список с несколькими дубликатами
    int values5[] = {1, 1, 2, 3, 3, 4};
    ListNode* list5 = LinkedListDuplicates::createList(values5, 6);
    
    std::cout << "Список 5:" << std::endl;
    LinkedListDuplicates::printList(list5);
    std::cout << "Есть дубликаты (unordered_set): " << 
        (LinkedListDuplicates::hasDuplicates(list5) ? "true" : "false") << std::endl;
    std::cout << "Есть дубликаты (без доп. памяти): " << 
        (LinkedListDuplicates::hasDuplicatesNoExtraMemory(list5) ? "true" : "false") << std::endl;
    
    // Очищаем память
    LinkedListDuplicates::deleteList(list1);
    LinkedListDuplicates::deleteList(list2);
    LinkedListDuplicates::deleteList(list4);
    LinkedListDuplicates::deleteList(list5);
    
    return 0;
}
