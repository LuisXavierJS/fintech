package model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PessoaFisica extends Usuario{
	@Column
	private String nome_da_mae;
	@Temporal(value=TemporalType.DATE)
	private Date data_de_nascimento;
	
	public String getNome_da_mae() {
		return nome_da_mae;
	}
	public void setNome_da_mae(String nome_da_mae) {
		this.nome_da_mae = nome_da_mae;
	}
	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}
	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}
	
	public PessoaFisica(){
		
	}
	
	public PessoaFisica(Map<String,Object> userData){
		super(userData);
		this.nome_da_mae = (String) userData.get("nome_da_mae");
		this.data_de_nascimento = (Date) userData.get("data_de_nascimento");
	}
}
