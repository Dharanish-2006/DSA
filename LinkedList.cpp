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
        int i = 1;
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
        while (temp!=NULL){
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
            return new list(newvalue);;
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

    list* DeleteHead(list* head){
        if(head==NULL){
            return NULL;
        }
        list *temp = head;
        head = head->next;
        delete temp;
        return head;
    }

    list* pop(list* head){
        if(head==NULL){
            return NULL;
        }
        if(head->next==NULL){
            delete head;
            return NULL;
        }
        list* temp = head;
        while(temp->next->next!=NULL){
            temp = temp->next;
        }
        delete temp->next;
        temp->next = NULL;

        return head;
    }
    
    list* DeleteAtPosition(list* head,int position){
        list *original;
        list *temp = head;
        if(temp == NULL){
            return NULL;
        }
        if(position==1){
            return DeleteHead(head);
        }
        for (int i = 1;i < position && temp != NULL; i++){
            original = temp;
            temp = temp->next;
        }
        if(temp!=NULL){
            original->next = temp->next;
            delete temp;
        }else{
            cout << "Data Not in List";
        }
        return head;
    }

};

class Dlist{

    public:
        int data;
        Dlist* priv;
        Dlist* next;
    Dlist(){}
    Dlist(int value){
        this->data = value;
        this->next = nullptr;
        this->priv = nullptr;
    }


};

int main(){
    // cout << "\t Singly Linked List \t\n";

    // list *one = new list(30);
    // list *two = new list(50);
    
    // one->next = two;
    // two->next = NULL;

    // list *head = one;
    // list temp;

    // head = head->InsertAtFront(head,10);
    // head = head->insertAfter(head,10,20);
    // head = head->insertBefore(head,50,40);
    // head = head->insertAtEnd(head,60);
    // head = head->insertAtEnd(head,70);
    // head = head->insertAtPosition(head,2,100); 
    // head = head->InsertAtFront(head,500);
    // head = head->DeleteHead(head);
    // head = head->pop(head);
    // head = head->DeleteAtPosition(head,3);
    // temp.printlist(head);
    // delete head;

    cout << "\t Doubly Linked List \t\n";
    Dlist *one = new Dlist(1);
    Dlist *two = new Dlist(2);
    Dlist *three = new Dlist(3);
    
    one->next = two;
    two->priv = one;
    two->next = three;
    three->priv = two;

    Dlist *head = one;
    Dlist temp;

    while (head!=nullptr){
        cout<<"Element : "<<head->data<<"\n";
        head = head->next;
    }
    

    return 0;
}