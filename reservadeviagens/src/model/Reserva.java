package model;

public class Reserva {
private int id;
private Usuario usuario;
private Destino destino;
private float valor;
private String data;
public Reserva(int id, Usuario usuario, Destino destino, float valor, String data) {
	super();
	this.id = id;
	this.usuario = usuario;
	this.destino = destino;
	this.valor = valor;
	this.data = data;
}
public Reserva(Usuario usuario, Destino destino, float valor, String data) {
	super();
	this.usuario = usuario;
	this.destino = destino;
	this.valor = valor;
	this.data = data;
}
public Reserva() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public Destino getDestino() {
	return destino;
}
public void setDestino(Destino destino) {
	this.destino = destino;
}
public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
@Override
public String toString() {
	return "Reserva [id=" + id + ", usuario=" + usuario + ", destino=" + destino + ", valor=" + valor + ", data=" + data
			+ "]";
}

}
