package com.gov.iti.sakila.webService;

import com.gov.iti.sakila.Services.PaymentServices;
import com.gov.iti.sakila.dto.PaymentDto;
import com.gov.iti.sakila.persistence.entities.Payment;
import com.gov.iti.sakila.utils.PaymentList;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.Optional;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class PaymentWebService {

    private PaymentServices paymentService = new PaymentServices();

    @WebMethod(operationName = "getPaymentById")
    public PaymentDto getPaymentById(@WebParam(name = "id") int id) {
        Optional<PaymentDto> optionalPaymentDto = paymentService.getPaymentById(id);
        return optionalPaymentDto.orElse(null); // Return the PaymentDto or null if it doesn't exist
    }

    @WebMethod(operationName = "savePayment")
    public boolean savePayment(@WebParam(name = "payment") Payment payment) {
        if (payment == null)
            return false;
        paymentService.savePayment(payment);
        return true;
    }

    @WebMethod(operationName = "updatePayment")
    public void updatePayment(@WebParam(name = "payment") PaymentDto payment) {
        paymentService.updatePayment(payment);
    }

    @WebMethod(operationName = "deletePayment")
    public void deletePayment(@WebParam(name = "payment") PaymentDto payment) {
        paymentService.deletePayment(payment);
    }

    @WebMethod(operationName = "getAllPayments")
    public PaymentList getAllPayments() {
        return new PaymentList((ArrayList<PaymentDto>) paymentService.getAllPayments());
    }

    @WebMethod(operationName = "getAllPaymentsByLimit")
    public PaymentList getAllPaymentsByLimit(@WebParam(name = "start") int start, @WebParam(name = "limit") int limit) {
        return new PaymentList((ArrayList<PaymentDto>) paymentService.getAllPaymentsByLimit(start, limit));
    }

    @WebMethod(operationName = "deletePaymentById")
    public boolean deletePaymentById(@WebParam(name = "id") int id) {
        Optional<PaymentDto> paymentDto = paymentService.getPaymentById(id);
        if (paymentDto.isPresent()) {
            paymentService.deletePayment(paymentDto.orElse(null));
            return true;
        }
        return false;
    }
}
