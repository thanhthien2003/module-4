package com.example.savemail.model.service;

import com.example.savemail.model.model.Mail;
import com.example.savemail.model.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService {
    @Autowired
    IMailRepository mailRepository;

    @Override
    public List<Mail> display() {
        return mailRepository.display();
    }

    @Override
    public boolean add(Mail mail) {
        return false;
    }

    @Override
    public boolean edit(Mail mail) {
        return mailRepository.edit(mail);
    }
}
