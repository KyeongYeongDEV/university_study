#include<iostream>
using namespace std;

struct Stack{
    int top;
    int size;
    int *arr;
};

Stack create(int size){
    Stack s;
    s.arr = (int*)malloc(sizeof(int) * size);
    s.size = size;
    s.top=0;
    return s;
}

bool is_full(Stack *s){
    if(s->top == s->size) {return true;}
    else{return false;}
}

bool is_empty(Stack *s){
    if(s->top == 0){return true;}
    else{return false;}
}

void push(Stack *s, int item){
    if(::is_full(s)){
        cout<< "ERROR_STACKFULL\n";
    }
    else{
        s->arr[s->top++] = item;    
    }    
}

int pop(Stack *s){
    if(::is_empty(s)){
        cout<< "ERROR_STACKEMPTY\n";
    }
    else{
        s->top--;
        int tmp = s->arr[s->top];
        

        return tmp;
    }
}

int peek(Stack s){
    if(::is_empty(&s)){
        cout<< "ERROR_STACKEMPTY\n";
        return 0;
    }
    else{
        return s.arr[s.top-1];
    }
}

int main(){
    Stack s = create(2);

    cout <<pop(&s) <<endl;

    push(&s,6);
    push(&s,5);
    push(&s,4);
    
    cout <<peek(s) <<endl;
    
    cout <<pop(&s) <<endl;
    cout <<pop(&s) <<endl;
}