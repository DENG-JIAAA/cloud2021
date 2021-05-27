package top.dj.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author DengJia
 * @Date 2021/5/18
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> {
    private Integer SUC;
    private String MSG;
    private T DATA;

    public ResultBean(Integer SUC, String MSG) {
        this(SUC, MSG, null);
    }
}
