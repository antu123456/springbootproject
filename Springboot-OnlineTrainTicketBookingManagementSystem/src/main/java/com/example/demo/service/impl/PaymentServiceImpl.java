package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Payment;
import com.example.demo.Repository.PaymentRepository;
import com.example.demo.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(int id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id).get();
	}

	@Override
	public String deletePayment(int id) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(id);
		return null;
	}

	@Override
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		Payment payment1=paymentRepository.findById(payment.getPaymentId()).get();
		payment1.setPaymentId(payment.getPaymentId());
		payment1.setBooking(payment.getBooking());
		payment1.setPaymentDate(payment.getPaymentDate());
		payment1.setPaymentAmount(payment.getPaymentAmount());
		payment1.setPaymentStatus(payment.getPaymentStatus());
		return paymentRepository.save(payment1);
	}

}
