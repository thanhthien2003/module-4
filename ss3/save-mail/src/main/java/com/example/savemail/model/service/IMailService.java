package com.example.savemail.model.service;

import com.example.savemail.model.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> display();
    boolean add(Mail mail);
    boolean edit(int id);
}
