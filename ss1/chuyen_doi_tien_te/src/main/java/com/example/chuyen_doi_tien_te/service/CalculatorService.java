package com.example.chuyen_doi_tien_te.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public Double calculate(double money,double exchange) {
        return money*exchange;
    }
}
