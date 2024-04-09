package com.allcom.domain.repository;

import com.allcom.domain.HourlyRate;

import java.util.List;
import java.util.Optional;

public interface HourlyRateRepository {
    Optional<List<HourlyRate>> getByUser(String userNameId);
}
