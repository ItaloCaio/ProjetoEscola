package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@Entity //Para dizer que é uma entidade
@Table(name="curso") //Criar uma tabela no bando de dados com nome professor
public class CursoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id // indica chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Gera codigos automaticamente
	@Column(name="cur_codigo")
	private Integer codigo;
	@Column(name="cur_nome", length=50, nullable=false) //Indica o nome, o tamanho e se pode ser nulo, no caso nao, false.
	private String nome;
	@Column(name="cur_diashorarios", length=50, nullable=false) //Indica o nome, o tamanho e se pode ser nulo, no caso nao, false.
	private String diashorarios;
	@ManyToOne //Muitos para um
	@JoinColumn(name="cur_codprof", referencedColumnName="prof_codigo") //associar com o professor, chave estrangeira
	private ProfessorModel professorModel;
	
	
	
	public CursoModel(Integer codigo, String nome, String diashorarios, ProfessorModel professorModel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.diashorarios = diashorarios;
		this.professorModel = professorModel;
	}
	
	
	public CursoModel() {
	
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
		CursoModel other = (CursoModel) obj;
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
	public String getDiashorarios() {
		return diashorarios;
	}
	public void setDiashorarios(String diashorarios) {
		this.diashorarios = diashorarios;
	}
	public ProfessorModel getProfessorModel() {
		return professorModel;
	}
	public void setProfessorModel(ProfessorModel professorModel) {
		this.professorModel = professorModel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	

}
