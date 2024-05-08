package test.algorithm;

public class Test_recursive {
    public static void main(String[] args) {
        print(1);
    }
    public static void print(int i){
        if(i>100) return;
        System.out.println(i);
        print(++i);
    }
}
