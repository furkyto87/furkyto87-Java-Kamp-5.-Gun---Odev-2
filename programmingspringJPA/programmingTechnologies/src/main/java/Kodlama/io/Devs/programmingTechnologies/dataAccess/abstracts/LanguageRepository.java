package Kodlama.io.Devs.programmingTechnologies.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.programmingTechnologies.entities.concretes.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
	
	
}
