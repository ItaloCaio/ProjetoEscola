package com.videoaulaneri.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.videoaulaneri.model.dao.ProfessorDaoInterface;

import model.ProfessorModel;

public class ProfessorServiceImplem implements ProfessorServiceInterface {
	
	@Inject
	private ProfessorDaoInterface professorDaoInterface; //Injetando de uma interface para que a partir dela Inject da classe automaticamente
	
	@Override
	@Transactional // A anota��o @Transactional demarca transa��es 
					//(voc� pode iniciar transa��es aninhadas, propagar transa��es para outras camadas, etc). 
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		
		return professorDaoInterface.salvarProfessor(professorModel);
	}

	@Override
	@Transactional
	public void alterarProfessor(ProfessorModel professorModel) {
	
		professorDaoInterface.alterarProfessor(professorModel);
	}

	@Override
	@Transactional
	public void excluirProfessor(ProfessorModel professorModel) {
		
		professorDaoInterface.excluirProfessor(professorModel);
		
	}

	@Override
	public List<ProfessorModel> getProfessores() {
		
		return professorDaoInterface.getProfessores();
	}

}
