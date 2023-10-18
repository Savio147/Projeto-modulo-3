package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionMySQL;
import model.Reserva;
import model.Usuario;

public class ReservaDAO {
	UsuarioDAO udao=new UsuarioDAO();
	DestinoDAO ddao=new DestinoDAO();
	public void create(Reserva reserva) {

		String sql = "insert into Reserva (id_usuario,id_destino,data_viagem,valor ) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getUsuario().getId());
			pstm.setInt(2, reserva.getDestino().getId());
			pstm.setString(3, reserva.getData());
			pstm.setFloat(4, reserva.getValor());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Reserva> read() {
		List<Reserva> reservas = new ArrayList<>();
		String sql = "select * from Reserva";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reserva = new Reserva();

				reserva.setId(rset.getInt("id"));
				reserva.setUsuario(udao.readById(rset.getInt("id_usuario")));
				reserva.setDestino(ddao.readById(rset.getInt("id_destino")));
				reserva.setValor(rset.getFloat("valor"));
				reserva.setData(rset.getString("data_viagem"));
			
				reservas.add(reserva);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return reservas;
	}

	// update
	public void update(Reserva reserva) {
		String sql = "UPDATE Reserva SET id_usuario=?,id_destino=?,data_viagem=?,valor=?  WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, reserva.getUsuario().getId());
			pstm.setInt(2, reserva.getDestino().getId());
			pstm.setString(3, reserva.getData());
			pstm.setFloat(4, reserva.getValor());
			pstm.setInt(5, reserva.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM reserva WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Reserva readById(int id) {
		Reserva reserva = new Reserva();
		String sql = "select * from Reserva WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			reserva.setId(rset.getInt("id"));
			reserva.setUsuario(udao.readById(rset.getInt("id_usuario")));
			reserva.setDestino(ddao.readById(rset.getInt("id_destino")));
			reserva.setValor(rset.getFloat("valor"));
			reserva.setData(rset.getString("data_viagem"));
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reserva;
	}

}
