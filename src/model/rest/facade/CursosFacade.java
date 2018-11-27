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

import com.videoaulaneri.model.service.CursoServiceInterface;

import model.CursoModel;
import model.ProfessorModel;

@Path ("/cursos")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class CursosFacade {
	
	@Inject
	private CursoServiceInterface cursoServiceInterface;
	
	@GET
	public List<CursoModel>getCursos(){
		
		return cursoServiceInterface.getCursos();
	}
	
	@POST
	public void salvarCurso(CursoModel cursoModel){
		
		cursoServiceInterface.salvarCurso(cursoModel);
	}
	
	@PUT
	public void alterarCurso(CursoModel cursoModel){
		
		cursoServiceInterface.alterarCurso(cursoModel);
	}
	
	@DELETE
	@Path("/{codigoCurso}") //Excluir atraves do codigo
	public void excluirCurso(@PathParam("codigoCurso") Integer codigoCurso){
		CursoModel cursoModel = new CursoModel();
		cursoModel.setCodigo(codigoCurso);
		
		cursoServiceInterface.excluirCurso(cursoModel);
	}

}
