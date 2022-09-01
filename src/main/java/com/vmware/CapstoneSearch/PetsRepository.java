package com.vmware.CapstoneSearch;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByZipIn(List<String> zip);
    List<Pet> findByBreed(String breed);

//    @Query("SELECT c FROM pets c WHERE (:zip is null or c.zip = :zip) and (:type is null or c.type = :type)")
    List<Pet> findByZipInAndTypeContains(List<String> zip, String type);
    List<Pet> findByType(String type);
}
