package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Payment;
import com.example.demo.service.PaymentService;
@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment payment)
	{
		return paymentService.addPayment(payment);
		
	}
	@GetMapping("/payments")
	public List<Payment> getAllPayment()
	{
		return paymentService.getAllPayment();
	}
	@GetMapping("/payments/{id}")
	public Payment getPaymentById(@PathVariable int id)
	{
		return paymentService.getPaymentById(id);
	}
	
	@DeleteMapping("/payments/{id}")
	public String deletePayment(@PathVariable int id)
	{
		return paymentService.deletePayment(id);
	}
	@PutMapping("/payments/{id}")
	public Payment updatePayment(@RequestBody Payment payment)
	{
		return paymentService.updatePayment(payment);
	}


}
