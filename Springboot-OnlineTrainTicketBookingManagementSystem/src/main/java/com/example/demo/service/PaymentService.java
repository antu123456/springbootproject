package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Payment;

public interface PaymentService {
	public Payment addPayment(Payment payment);
	
	public List<Payment> getAllPayment();
	
	public Payment getPaymentById(int id);
	
	public String deletePayment(int id);
	
	public Payment updatePayment(Payment payment);


}
