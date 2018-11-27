package com.videoaulaneri.model.service;

import java.util.List;

import model.ProfessorModel;

public interface ProfessorServiceInterface {
	
	ProfessorModel salvarProfessor(ProfessorModel professorModel);
	
	void alterarProfessor(ProfessorModel professorModel);
	void excluirProfessor(ProfessorModel professorModel);
	
	List<ProfessorModel> getProfessores();


}
