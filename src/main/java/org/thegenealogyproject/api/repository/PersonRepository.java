package org.thegenealogyproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thegenealogyproject.api.model.Person;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
