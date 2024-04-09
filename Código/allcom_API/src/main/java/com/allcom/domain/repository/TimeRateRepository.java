package com.allcom.domain.repository;

import com.allcom.domain.TimeRate;

import java.util.List;
import java.util.Optional;

public interface TimeRateRepository {
    Optional<List<TimeRate>> getByUser(String userNameId);
}
