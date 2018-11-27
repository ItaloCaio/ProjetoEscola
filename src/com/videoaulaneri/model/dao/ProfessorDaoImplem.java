package com.videoaulaneri.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.ProfessorModel;

public class ProfessorDaoImplem implements ProfessorDaoInterface{

	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit") //adicionar uma unidade de persist�ncia no EntityManager
	//unitName que podemos utilizar para informar qual o nome da unidade de persist�ncia 
	private EntityManager entityManager; //Gerenciar banco
	
	/*   O EntityManager � um servi�o respons�vel por gerenciar as entidades, atrav�s dele � poss�vel gerenciar o ciclo de vida
	 *  das entidades, opera��o de sincroniza��o com a base de dados (inserir, atualizar ou remover), consultar entidades e outros.*/
	
	
	@Override
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		
		entityManager.persist(professorModel);
		
		return professorModel;
	}

	@Override
	public void alterarProfessor(ProfessorModel professorModel) {
		ProfessorModel professorModelMerge = entityManager.merge(professorModel); //Junta o estado da Entity com o estado persistido.
		//Utilizamos o m�todo merge da EntityManager para atualizar a Entity Professor no BD
		entityManager.persist(professorModelMerge);
	}

	@Override
	public void excluirProfessor(ProfessorModel professorModel) {
		
		ProfessorModel professorModelMerge = entityManager.merge(professorModel); //Junta o estado da Entity com o estado persistido.
		
		entityManager.remove(professorModelMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProfessorModel> getProfessores() {
		/* A interface Query � respons�vel por:

		    Fazer as consultas.
		    Executar updates.
		    Passar par�metros para consulta.
		    Pegar um simples resultado.
		    Pegar uma lista de resultados.
		 */
		
		Query query = entityManager.createQuery("from ProfessorModel");
		return query.getResultList();
	}

}
