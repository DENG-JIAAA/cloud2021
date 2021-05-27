import java.time.ZonedDateTime;

/**
 * @Author DengJia
 * @Date 2021/5/26
 * @Description:
 */

public class MyTest {
    public static void main(String[] args) {
        ZonedDateTime nowTime = ZonedDateTime.now(); // 默认时区
        System.out.println("nowTime = " + nowTime);
    }
}
