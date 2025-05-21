package com.github.jbence1994.genealogy.repository;

import com.github.jbence1994.genealogy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeopleRepository extends JpaRepository<Person, UUID> {
}
