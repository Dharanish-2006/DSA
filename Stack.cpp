#include <iostream>
#include <stack>

using namespace std;

int main(){

    stack<int> myst;
    
    myst.push(1);
    myst.push(2);
    myst.push(3);
    myst.push(4);
    myst.push(5);

    cout<< "first element : " << myst.top()<<"\n";
    cout<<"size : "<< myst.size()<<"\n";
    cout<<"printing all Elements\n";

    while(!myst.empty()){
        cout << "Element : " << myst.top()<<"\n";
        myst.pop();
    }
    
    return 0;
}