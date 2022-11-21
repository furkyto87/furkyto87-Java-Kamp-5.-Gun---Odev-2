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

import Kodlama.io.Devs.programmingTechnologies.business.abstracts.TechnologyService;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.requests.TechnologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingTechnologies.business.responses.TechnologyResponses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.programmingTechnologies.business.responses.TechnologyResponses.GetByIdTechnologiesResponse;
	
	@RestController
	@RequestMapping("/api/technologies")
	public class TechnologiesController {
		private TechnologyService technologyService;

		@Autowired
		public TechnologiesController(TechnologyService technologyService) {
			this.technologyService = technologyService;
		}

		@PostMapping("/add")
		public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
			this.technologyService.add(createTechnologyRequest);
		}
		
		@DeleteMapping("/delete")
		public void delete(@RequestBody() DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
			this.technologyService.delete(deleteTechnologyRequest);
		}
		
		@PutMapping ("/update")
		public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
			this.technologyService.update(updateTechnologyRequest);
		}

		@GetMapping("/getall")
		public List<GetAllTechnologiesResponse> getAll() {
			return this.technologyService.getAll();
		}
		
		@GetMapping("/getbyid")
		public GetByIdTechnologiesResponse getById(@RequestParam int technology_id) throws Exception {
			return this.technologyService.getById(technology_id);
		}
	}
