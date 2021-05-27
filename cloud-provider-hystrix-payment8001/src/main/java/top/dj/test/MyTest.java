package top.dj.test;

/**
 * @Author DengJia
 * @Date 2021/5/24
 * @Description:
 */

public class MyTest {
    public static void main(String[] args) {
        sayHello();
    }

    static void sayHello() {
        System.out.println(Thread.currentThread().getName());
    }
}
