package com.github.jbence1994.genealogy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Person {

    @Id
    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String placeOfBirth;

    private LocalDate dateOfBirth;

    private String placeOfDeath;

    private LocalDate dateOfDeath;

    private String photoFileName;

    @OneToMany(mappedBy = "child", fetch = FetchType.EAGER)
    private Set<PersonParent> parents = new HashSet<>();

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private Set<PersonParent> children = new HashSet<>();

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private Set<PersonSibling> siblings = new HashSet<>();
}
