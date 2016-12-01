package model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public abstract class Usuario {
	@Id
	@GeneratedValue
	protected int id_usuario;
	
	@OneToOne
	@JoinColumn(name="id_endereco")
	protected Endereco endereco;
	@Column
	protected String nome_completo;
	@Column
	protected String codigo_pessoa;
	@Column
	protected String telefone;
	@Column
	protected String telefone_opcional;
	@Column
	protected String email;
	@Column(unique=true)
	protected String nome_do_usuario;
	@Column
	protected String senha_para_acesso;
	@Column
	protected String foto_perfil;
	
	public Usuario(){
		
	}
	
	public Usuario(Map<String,Object> userData){
		this.endereco =(Endereco) userData.get("endereco") ;
		this.nome_completo =(String) userData.get("nome_completo") ;
		this.codigo_pessoa =(String) userData.get("codigo_pessoa") ;
		this.telefone =(String) userData.get("telefone") ;
		this.telefone_opcional =(String) userData.get("telefone_opcional") ;
		this.email =(String) userData.get("email") ;
		this.nome_do_usuario =(String) userData.get("nome_do_usuario") ;
		this.senha_para_acesso =(String) userData.get("senha_para_acesso") ;
		this.foto_perfil =(String) userData.get("foto_perfil") ;
	}
	
	public int getId_usuario(){
		return id_usuario;
	}
	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	public String getCodigo_pessoa() {
		return codigo_pessoa;
	}
	public void setCodigo_pessoa(String codigo_pessoa) {
		this.codigo_pessoa = codigo_pessoa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefone_opcional() {
		return telefone_opcional;
	}
	public void setTelefone_opcional(String telefone_opcional) {
		this.telefone_opcional = telefone_opcional;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome_do_usuario() {
		return nome_do_usuario;
	}
	public void setNome_do_usuario(String nome_do_usuario) {
		this.nome_do_usuario = nome_do_usuario;
	}
	public String getSenha_para_acesso() {
		return senha_para_acesso;
	}
	public void setSenha_para_acesso(String senha_para_acesso) {
		this.senha_para_acesso = senha_para_acesso;
	}
	public String getFoto_perfil() {
		return foto_perfil;
	}
	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}
	
	
}
