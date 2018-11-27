package com.videoaulaneri.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.videoaulaneri.model.dao.CursoDaoInterface;

import model.CursoModel;

public class CursoServiceImplem implements CursoServiceInterface{

	@Inject
	private CursoDaoInterface cursoDaoInterface;
	
	@Override
	@Transactional
	public CursoModel salvarCurso(CursoModel cursoModel) {
		
		cursoDaoInterface.salvarCurso(cursoModel);
		
		return cursoModel;
	}

	@Override
	@Transactional
	public void alterarCurso(CursoModel cursoModel) {

		cursoDaoInterface.alterarCurso(cursoModel);
		
	}

	@Override
	@Transactional
	public void excluirCurso(CursoModel cursoModel) {
		
		cursoDaoInterface.excluirCurso(cursoModel);
		
	}

	@Override
	public List<CursoModel> getCursos() {
		
		return cursoDaoInterface.getCursos();
	}

}
