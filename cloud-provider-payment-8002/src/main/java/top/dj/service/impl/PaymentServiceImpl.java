package top.dj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dj.entity.Payment;
import top.dj.mapper.PaymentMapper;
import top.dj.service.PaymentService;

/**
 * @Author DengJia
 * @Date 2021/5/17
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int addOnePayment(Payment payment) {
        return paymentMapper.addOnePayment(payment);
    }

    @Override
    public Payment getOnePayment(Integer id) {
        return paymentMapper.getOnePayment(id);
    }
}
