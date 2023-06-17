package com.example.demo4.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CondimentService implements ICondimentService {
    @Override
    public String saveCondiment(String[] arr) {
        String result = "";
        if (arr == null) {
            result = "vui long chon da vi!";
        } else {
            result = "danh sach gia vi da chon: " + Arrays.toString(arr);
        }
        return result;
    }
}
