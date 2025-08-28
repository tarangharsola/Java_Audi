// class A {
//     int v1;
//     String name;
//     A(){
//         this("No name");
//     }
//     A(String n){
//         name = n;
//     }
//     A(String n, int num){
//         name = n;
//         v1 = num;
//     }
// }
class A {

    int x = 5;

    static int mm = 10;

    static void show() {

        System.out.println(x);   // line 1

        System.out.println(mm);

    }

    public static void main(String[] args) {

        show();

    }

}

