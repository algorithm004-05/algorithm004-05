#include <iostream>
#include <fstream>

using namespace std;

class Test{
    private:int x,y;
    
    public:
     static const int z;
    Test(int a ,int b):x(a),y(b){}
    Test(){}
    void show(){
        cout << "x="<< x <<"  y="<<y<<endl;
    }
    void setX(int a){
        x=a;
    }
    void show(Test t){
        cout << "t.x="<< t.x <<"  t.y="<<t.y<<endl;
    }
};
const int Test::z=1;
int main(){
char c='c';
int a=4;
float f=3.14;
double d=1.212;
cout << c+a/(int)d +f <<endl;
cout<< a/(int)d +f <<endl;
cout << 12+2.1 <<endl;

char * text="welcome to file";

char itext[200];
ifstream ffff("test");
ffff>>itext;
ffff.close();


ofstream of("test.backup");
of<<itext;
of.close();
char aaaaaaa=' b';
// cout <<"itext:"<<itext<< endl;

    
    // z=&a;

}