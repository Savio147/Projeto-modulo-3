package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionMySQL;
import model.Usuario;

public class UsuarioDAO {
	public void create(Usuario usuario) {

		String sql = "insert into Usuario (nome,cpf,endereço,telefone) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getEndereco());
			pstm.setString(4, usuario.getTelefone());

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
	public List<Usuario> read() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "select * from Usuario";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(rset.getInt("id"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEndereco(rset.getString("endereço"));
				usuario.setCpf(rset.getString("cpf"));
				usuario.setTelefone(rset.getString("telefone"));

				usuarios.add(usuario);
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

		return usuarios;
	}

	// update
	public void update(Usuario usuario) {
		String sql = "UPDATE Usuario SET nome=?,cpf=?,endereço=?,telefone=? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getEndereco());
			pstm.setString(4, usuario.getTelefone());

			pstm.setInt(5, usuario.getId());

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
		String sql = "DELETE FROM Usuario WHERE id = ?";

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
	public Usuario readById(int id) {
		Usuario usuario = new Usuario();
		String sql = "select * from Usuario WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			usuario.setId(rset.getInt("id"));
			usuario.setNome(rset.getString("nome"));
			usuario.setEndereco(rset.getString("endereço"));
			usuario.setCpf(rset.getString("cpf"));
			usuario.setTelefone(rset.getString("telefone"));

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
		return usuario;
	}

}

