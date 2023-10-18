package aplicacao;

import java.util.Scanner;

import dao.DestinoDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import model.Destino;
import model.Reserva;
import model.Usuario;

public class MainReserva {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		
		int id_usuario,id_destino, opcao = 0, id = 0; 
		float valor;
		String data ;
		
		
		do {
			
			System.out.println("\n============================== RESERVA =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o id_usuario:");
				id_usuario = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id_destino:");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
					Usuario usuario=usuarioDAO.readById(id_usuario);		
					Destino destino=destinoDAO.readById(id_destino);
				
				reservaDAO.create(new Reserva(usuario,destino,valor,data));
				break;
			case 2:
				
				for (Reserva u : reservaDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id_usuario:");
				id_usuario = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id_destino:");
				id_destino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
					Usuario usuario1=usuarioDAO.readById(id_usuario);		
					Destino destino1=destinoDAO.readById(id_destino);
				
				reservaDAO.update(new Reserva(id,usuario1,destino1,valor,data));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				reservaDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Reserva reserva3 = reservaDAO.readById(id);
				
				System.out.println(reserva3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}
}
