package com.vmware.CapstoneSearch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByZipIn(List<String> zip);
    List<Pet> findByZipInAndTypeContains(List<String> zip, String type);
    List<Pet> findByType(String type);
}
