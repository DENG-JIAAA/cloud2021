package top.dj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.dj.entity.Payment;

@Mapper
public interface PaymentMapper {
    int addOnePayment(Payment payment);

    Payment getOnePayment(@Param("id") Integer id);
}
