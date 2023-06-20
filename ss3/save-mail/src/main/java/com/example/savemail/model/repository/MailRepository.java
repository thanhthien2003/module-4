package com.example.savemail.model.repository;

import com.example.savemail.model.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository {
   private static List<Mail> mailList = new ArrayList<>();

    static {
        mailList.add(new Mail(1, "Vietnamese", 25, true, "awdiooawid"));
        mailList.add(new Mail(2, "Japanese", 5, true, "adadad"));
        mailList.add(new Mail(3, "Chinese", 10, false, "a2adaoawid"));
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
    public boolean edit(Mail mail) {
        for (int i = 0; i < mailList.size(); i++) {
            if (mailList.get(i).getId() == mail.getId()) {
                mailList.set(i, mail);
                return true;
            }
        }
        return false;
    }
}
