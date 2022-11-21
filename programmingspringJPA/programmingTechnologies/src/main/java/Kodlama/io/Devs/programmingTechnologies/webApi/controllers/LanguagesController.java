package Kodlama.io.Devs.programmingTechnologies.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.programmingTechnologies.business.abstracts.LanguageService;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.DeleteLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.LanguageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses.GetAllLanguagesResponse;
import Kodlama.io.Devs.programmingTechnologies.business.responses.LanguageResponses.GetByIdLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		this.languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody() DeleteLanguageRequest deleteLanguageRequest) throws Exception{
		this.languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping ("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
		this.languageService.update(updateLanguageRequest);
	}

	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return this.languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public GetByIdLanguagesResponse getById(@RequestParam int language_id) throws Exception {
		return this.languageService.getById(language_id);
	}

}
	

