package kodlama.io.Kodlama.io.Devs.Bussiness.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) throws Exception;
	public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception;
	public void delete(int id) throws Exception;
	public ProgrammingLanguage getById(int id) throws Exception;
}
