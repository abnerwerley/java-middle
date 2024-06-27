package com.token.services.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    public ArrayList<Object> returArrayReordered(ArrayList<Object> request) {
        ArrayList<Object> listReordered = new ArrayList<>();
        for (int i = 1; i <= request.size(); i++) {
            listReordered.add(request.get(request.size() - i));
        }
        return listReordered;
    }

    public ArrayList<Object> returnSameArrayReordered(ArrayList<Object> request) {
        for (int i = 0; i < request.size() / 2; i++) {
            Object temporary = request.get(i);
            request.set(i, request.get(request.size() - 1 - i));
            request.set(request.size() - 1 - i, temporary);
        }
        return request;
    }

    public List<Object> returnSameListReordered(List<Object> request) {
        for (int i = 0; i < request.size() / 2; i++) {
            Object temporary = request.get(i);
            request.set(i, request.get(request.size() - 1 - i));
            request.set(request.size() - 1 - i, temporary);
        }
        return request;
    }
}
