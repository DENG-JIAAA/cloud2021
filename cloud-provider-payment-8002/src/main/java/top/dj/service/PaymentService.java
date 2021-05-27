package top.dj.service;

import top.dj.entity.Payment;

public interface PaymentService {
    int addOnePayment(Payment payment);

    Payment getOnePayment(Integer id);

}
