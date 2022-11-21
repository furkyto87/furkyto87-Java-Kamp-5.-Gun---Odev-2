package Kodlama.io.Devs.programmingTechnologies.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.programmingTechnologies.entities.concretes.Technology;


public interface TechnologyRepository extends JpaRepository<Technology, Integer> {


}
