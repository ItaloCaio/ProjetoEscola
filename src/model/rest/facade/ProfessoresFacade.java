package model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.videoaulaneri.model.dao.ProfessorDaoImplem;
import com.videoaulaneri.model.service.ProfessorServiceInterface;

import model.ProfessorModel;



@Path ("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessoresFacade {

//	@Inject
//	private ProfessorDaoImplem professorDaoImplem;
//	
//	@GET
//	public List<ProfessorModel> getProfessores(){
//		
//		return professorDaoImplem.gerProfessores();
//	}
	
	@Inject 
	private ProfessorServiceInterface professorServiceInterface;
	 
	@GET
	public List<ProfessorModel> getProfessor(){
		
		return professorServiceInterface.getProfessores();
	}
	
	@POST
	public ProfessorModel salvarProfessor(ProfessorModel professorModel){
		return professorServiceInterface.salvarProfessor(professorModel);
	}

	@PUT
	public void atualizar(ProfessorModel professorModel){
		professorServiceInterface.alterarProfessor(professorModel);
	}
	
	@DELETE
	@Path("/{codigoProfessor}") //Excluir atraves do codigo
	public void excluir(@PathParam("codigoProfessor") Integer codigoProfessor){
		ProfessorModel professorModel = new ProfessorModel();
		professorModel.setCodigo(codigoProfessor);
		
		professorServiceInterface.excluirProfessor(professorModel);
	}
}
