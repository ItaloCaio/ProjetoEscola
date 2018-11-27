package com.videoaulaneri.model.dao;

import java.util.List;

import model.CursoModel;

public interface CursoDaoInterface {
	
	CursoModel salvarCurso(CursoModel cursoModel);
	
	void alterarCurso(CursoModel cursoModel);
	void excluirCurso(CursoModel cursoModel);
	
	List<CursoModel> getCursos();
	
	

}
