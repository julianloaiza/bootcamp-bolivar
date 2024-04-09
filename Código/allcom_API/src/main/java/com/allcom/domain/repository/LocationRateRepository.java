package com.allcom.domain.repository;

import com.allcom.domain.LocationRate;

import java.util.List;
import java.util.Optional;

public interface LocationRateRepository {
    Optional<List<LocationRate>> getByUser(String userNameId);
}
