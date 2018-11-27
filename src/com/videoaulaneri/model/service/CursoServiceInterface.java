package com.videoaulaneri.model.service;

import java.util.List;

import model.CursoModel;

public interface CursoServiceInterface {
	CursoModel salvarCurso(CursoModel cursoModel);

	void alterarCurso(CursoModel cursoModel);

	void excluirCurso(CursoModel cursoModel);

	List<CursoModel> getCursos();

}
