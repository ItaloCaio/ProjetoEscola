package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity //Para dizer que é uma entidade
@Table(name="professor") //Criar uma tabela no bando de dados com nome professor
public class ProfessorModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id // indica chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Gera codigos automaticamente
	@Column(name="prof_codigo")
	Integer codigo;
	
	
	@Column(name="prof_nome", length=50, nullable=false) //Indica o nome, o tamanho e se pode ser nulo, no caso nao, false.
	String nome;
	@Column(name="prof_email", length=50, nullable=false)
	String email;
	@Column(name="prof_fone", length=15, nullable=false)
	String fone;
	
	@OneToMany(mappedBy="professorModel") //Pega os professores la de cursoModel Um para Muitos
	private List<CursoModel> cursoModel;
	
	@XmlTransient
	public List<CursoModel> getCursos(){
		
		return cursoModel;
	}
	
	public ProfessorModel() {
			
	}
	
	public ProfessorModel(Integer codigo, String nome, String email, String fone) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}

	
	
//NAO TER O GET
//	public List<CursoModel> getCursoModel() {
//		return cursoModel;
//	}

	public void setCursoModel(List<CursoModel> cursoModel) {
		this.cursoModel = cursoModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorModel other = (ProfessorModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}

}
