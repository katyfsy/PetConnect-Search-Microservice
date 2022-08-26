package com.vmware.CapstoneSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CapstoneSearchApplication {
	@Autowired
	PetsRepository petsRepository;
	List<Pet> pets;

	public static void setup(){
		this.pets = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			this.pets.add(new Pet("dog", "lucky"+i));
		}
		for (int i = 0; i < 5; i++) {
			this.pets.add(new Pet("cat", "jingles"+i));
		}
		petsRepository.saveAll(this.pets);
	}

	public static void main(String[] args) {

		SpringApplication.run(CapstoneSearchApplication.class, args);
		setup();
	}


}
