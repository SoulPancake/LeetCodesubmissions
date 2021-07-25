// https://leetcode.com/problems/design-linked-list

struct node {
        int val;
        struct node * next;
};

struct node * make_node(int val, struct node * next)
{
        struct node * rv = malloc(sizeof(*rv));  assert(rv);
        rv->val = val;  rv->next = next;
        return rv;
}

void free_list(struct node * head) {
        struct node * prev;
        while (head) {
                prev = head;
                head = head->next;
                free(prev);
        }
}

typedef struct {
        struct node * head;
        struct node * tail;
        int size;
} MyLinkedList;

/** Initialize your data structure here. */
MyLinkedList* myLinkedListCreate() {
        MyLinkedList * rv = calloc(1, sizeof(*rv));
        return rv;
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
int myLinkedListGet(MyLinkedList* obj, int index) {
        if (index >= obj->size)
                return -1;
        
        struct node * cur = obj->head;
        
        for (int i = 0; i < index; ++i) {
                cur = cur->next;
        }
        return cur->val;
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
void myLinkedListAddAtHead(MyLinkedList* obj, int val) {
        struct node * newnode = make_node(val, obj->head);
        obj->head = newnode;
        obj->size += 1;
        if (obj->size == 1)
                obj->tail = obj->head;
}

/** Append a node of value val to the last element of the linked list. */
void myLinkedListAddAtTail(MyLinkedList* obj, int val) {
        struct node * newnode = make_node(val, NULL);
        if (obj->tail) {
                obj->tail->next = newnode;
                obj->tail = newnode;
                obj->size += 1;
        }
        else
                myLinkedListAddAtHead(obj, val);
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
void myLinkedListAddAtIndex(MyLinkedList* obj, int index, int val) {
        if (index > obj->size) return;
        if (index == obj->size) {
                return myLinkedListAddAtTail(obj, val);
        }
        if (index == 0) {
                return myLinkedListAddAtHead(obj, val);
        }
        
        struct node * cur = obj->head;
        for (int i = 1; i < index; ++i) {
                cur = cur->next;
        }
        struct node * newnode = make_node(val, cur->next);
        cur->next = newnode;
        obj->size += 1;
}

/** Delete the index-th node in the linked list, if the index is valid. */
void myLinkedListDeleteAtIndex(MyLinkedList* obj, int index) {
        if (index >= obj->size) return;
        
        struct node * temp, * rm;
        if (index == 0) {
                temp = obj->head;
                obj->head = temp->next;
                free(temp);
                obj->size -= 1;
                return;
        }
        if (index == obj->size - 1) {
               temp = obj->head; 
                while (temp->next != obj->tail)
                        temp = temp->next;
                free(temp->next);
                obj->tail = temp;
                obj->size -= 1;
                return;
        }
        
        temp = obj->head;
        for (int i = 1; i < index; ++i) {
                temp = temp->next;
        }
        // Temp is now the node before the one we want to remove
        rm = temp->next;
        temp->next = rm->next;
        free(rm);
        obj->size -= 1;
}

void myLinkedListFree(MyLinkedList* obj) {
        free_list(obj->head);
        free(obj);
}