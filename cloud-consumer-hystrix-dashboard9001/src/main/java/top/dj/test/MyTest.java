package top.dj.test;

import java.util.ArrayList;

/**
 * @Author DengJia
 * @Date 2021/5/25
 * @Description:
 */

public class MyTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.forEach((String list) -> System.out.println("list = " + list));
        arrayList.forEach(System.out::println);

        System.out.println("arrayList = " + arrayList);
    }
}
