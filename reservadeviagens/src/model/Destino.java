package model;

public class Destino {
private int id;
private String nome,estado;
public Destino(int id, String nome, String estado) {
	super();
	this.id = id;
	this.nome = nome;
	this.estado = estado;
}
public Destino(String nome, String estado) {
	super();
	this.nome = nome;
	this.estado = estado;
}
public Destino() {
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
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
@Override
public String toString() {
	return "Destino [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
}

}
