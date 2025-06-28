#include <iostream>
using namespace std;

class list{
    public:
    int value;
    list *next;
    public:
    list(){}    
    list(int newvalue){
        value = newvalue;
        next = NULL;
    }

    void printlist(list *head){
        cout << "Printing all the Elements : \n";
        list *temp = head;
        int i = 0;
        while(temp!=NULL){
            cout << "Element " << i++ << " : " << temp->value << "\n";
            temp = temp->next;
        }
    }

    list* InsertAtFront(list *head,int newvalue){
        list *newlist = new list(newvalue);
        newlist->next = head;
        return newlist;
    }

    list* insertAfter(list *head,int value,int newvalue){
        list* temp = head;
        while (temp->next!=NULL){
            if(temp->value==value){
                break;
            }
            temp = temp->next;
        }
        if(temp == NULL){
            cout<<"given value is not in list";
            return head;
        }

        list *newlist = new list(newvalue);
        newlist->next = temp->next;
        temp->next = newlist;
        
        return head;
    }

    list* insertBefore(list* head, int value,int newvalue){
        if (head == NULL){
            return NULL;
        }
        if (head->value == value){
            list* newlist = new list(newvalue);
            newlist->next = head;
            return newlist;
        }
        head->next = insertBefore(head->next,value,newvalue);
        return head;
    }

    list* insertAtEnd(list* head,int newvalue){
        list* newlist = new list(newvalue);
        if(head==NULL){
            return NULL;
        }
        list *temp = head;
        while(temp->next!= NULL){
            temp = temp->next;
        }
        temp->next = newlist;

        return head;
    } 

    list* insertAtPosition(list* head, int position,int newvalue){
        
        if(position==0){
            return head;
        }
        if(position==1){
            list* newlist = new list(newvalue);
            newlist->next = head;
            return newlist;
        }
        list* temp = head;
        for (int i = 1; i < position-1 && temp->next!=NULL; i++){
            temp = temp->next;
        }
        if(temp==NULL){
            return head;
        }
        list* newlist = new list(newvalue);
        newlist->next = temp->next;
        temp->next= newlist;

        return head;
    }

};

int main(){
    cout << "\t Linked List \t\n";

    list *one = new list(30);
    list *two = new list(50);
    
    one->next = two;
    two->next = NULL;

    list *head = one;
    list temp;

    head = head->InsertAtFront(head,10);
    head = head->insertAfter(head,10,20);
    head = head->insertBefore(head,50,40);
    head = head->insertAtEnd(head,60);
    head = head->insertAtPosition(head,2,100); 
    temp.printlist(head);

    return 0;
}