package com.example.savemail.model.repository;

import com.example.savemail.model.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements  IMailRepository{
    static List<Mail> mailList = new ArrayList<>();
    static {

    }
    @Override
    public List<Mail> display() {
        return mailList;
    }

    @Override
    public boolean add(Mail mail) {
        return false;
    }

    @Override
    public boolean edit(int id) {
        return false;
    }
}
