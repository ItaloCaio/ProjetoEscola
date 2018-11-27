package com.videoaulaneri.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.ProfessorModel;

public class ProfessorDaoImplem implements ProfessorDaoInterface{

	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit") //adicionar uma unidade de persistência no EntityManager
	//unitName que podemos utilizar para informar qual o nome da unidade de persistência 
	private EntityManager entityManager; //Gerenciar banco
	
	/*   O EntityManager é um serviço responsável por gerenciar as entidades, através dele é possível gerenciar o ciclo de vida
	 *  das entidades, operação de sincronização com a base de dados (inserir, atualizar ou remover), consultar entidades e outros.*/
	
	
	@Override
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		
		entityManager.persist(professorModel);
		
		return professorModel;
	}

	@Override
	public void alterarProfessor(ProfessorModel professorModel) {
		ProfessorModel professorModelMerge = entityManager.merge(professorModel); //Junta o estado da Entity com o estado persistido.
		//Utilizamos o método merge da EntityManager para atualizar a Entity Professor no BD
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
		/* A interface Query é responsável por:

		    Fazer as consultas.
		    Executar updates.
		    Passar parâmetros para consulta.
		    Pegar um simples resultado.
		    Pegar uma lista de resultados.
		 */
		
		Query query = entityManager.createQuery("from ProfessorModel");
		return query.getResultList();
	}

}
