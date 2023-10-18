package model;

public class Usuario {
private int id;
private String nome,telefone,cpf,endereco;
public Usuario(int id, String nome, String telefone, String cpf, String endereco) {
	super();
	this.id = id;
	this.nome = nome;
	this.telefone = telefone;
	this.cpf = cpf;
	this.endereco = endereco;
}
public Usuario(String nome, String telefone, String cpf, String endereco) {
	super();
	this.nome = nome;
	this.telefone = telefone;
	this.cpf = cpf;
	this.endereco = endereco;
}
public Usuario() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
@Override
public String toString() {
	return "Usuario [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + ", endereco=" + endereco
			+ "]";
}

}
