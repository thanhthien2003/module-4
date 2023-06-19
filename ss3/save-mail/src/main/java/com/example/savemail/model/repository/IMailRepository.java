package com.example.savemail.model.repository;

import com.example.savemail.model.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<Mail> display();

    boolean add(Mail mail);

    boolean edit(Mail mail);
}
