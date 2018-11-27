package com.videoaulaneri.model.dao;

import java.util.List;

import model.ProfessorModel;

public interface ProfessorDaoInterface {
	
	ProfessorModel salvarProfessor(ProfessorModel professorModel);
	
	void alterarProfessor(ProfessorModel professorModel);
	void excluirProfessor(ProfessorModel professorModel);
	
	List<ProfessorModel> getProfessores();

}
