package com.github.perscholas.repositories;

import com.github.perscholas.models.Guests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface GuestRepository extends CrudRepository<Guests,Long> {
}
