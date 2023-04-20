package com.gov.iti.sakila;



import com.gov.iti.sakila.Services.PaymentServices;



public class Main {
    public static void main(String[] args) {

        PaymentServices paymentServices = new PaymentServices();
        System.out.println(paymentServices.getPaymentById(1));
    }
}
