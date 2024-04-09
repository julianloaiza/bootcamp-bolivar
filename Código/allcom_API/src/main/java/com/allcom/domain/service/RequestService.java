package com.allcom.domain.service;

import com.allcom.domain.Request;
import com.allcom.domain.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAll(){
        return requestRepository.getAll();
    }

    public Optional<List<Request>> getByUser(String userId){
        return requestRepository.getByUser(userId);
    }

    public Request save(Request request){
        return requestRepository.save(request);
    }
}
