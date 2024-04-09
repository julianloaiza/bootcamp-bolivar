package com.allcom.domain.repository;

import com.allcom.domain.Request;

import java.util.List;
import java.util.Optional;

public interface RequestRepository {

    List<Request> getAll();
    Optional<List<Request>> getByUser( String userId);
    Request save(Request request);

}
