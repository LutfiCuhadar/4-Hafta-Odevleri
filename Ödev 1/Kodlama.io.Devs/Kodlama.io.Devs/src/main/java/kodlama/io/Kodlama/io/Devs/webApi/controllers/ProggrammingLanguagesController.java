package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.Bussiness.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController //annotation(Bilgilendirme)
@RequestMapping("/api/languages")
public class ProggrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired //Ne demek: paremetrelere bak(Service) uygulamayı tara kim servisi implemente ediyor.(Programming
			   //LanguageManager) new'lenmiş halini ver.
	public ProggrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall") 
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll(); 
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable(name = "id") int id) throws Exception {
		return this.programmingLanguageService.getById(id);
	}
	
	@PostMapping
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		this.programmingLanguageService.add(programmingLanguage);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable(name = "id") int id) throws Exception {
		programmingLanguageService.delete(id);
		return "Programlama dili başarıyla silindi";
	}
	
	@PutMapping("/{id}")
	public void updateById(@PathVariable int id, @RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(programmingLanguage, id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
