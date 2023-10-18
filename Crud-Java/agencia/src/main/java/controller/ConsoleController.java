package controller;

import dao.DestinoDAO;
import dao.UsuarioDAO;
import model.Destino;
import model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleController {


    DestinoDAO destinoDAO = new DestinoDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void escolhaOpcao() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" \n Deseja manipular a tabela Usuario[1] ou Destino[2] \n");
        int opcao;
        do {
            System.out.print("Digite 1 ou 2 para prosseguir: ");
            opcao = scan.nextInt();
        } while (opcao != 1 && opcao != 2);
        if (opcao == 1) {
            do {
                System.out.println(
                        "\n" +  "[1] Cadastrar novo usuário" + "\n" +
                                "[2] Atualizar dados do usuário" + "\n" +
                                "[3] Excluir registro do usuário" + "\n" +
                                "[4] Ver todos os usuários" + "\n" +
                                "[5] Buscar usuário por ID" + "\n"
                );
                System.out.print("# ");
                opcao = scan.nextInt();
                System.out.println();
                System.out.println();
            } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5);
            if (opcao == 1) {
                Usuario usuario = new Usuario();
                scan.nextLine();
                System.out.print("Nome: ");
                usuario.setNome(scan.nextLine());
                System.out.print("Sobrenome: ");
                usuario.setSobrenome(scan.nextLine());
                System.out.print("email: ");
                usuario.setEmail(scan.nextLine());
                System.out.print("senha: ");
                usuario.setSenha(scan.nextLine());
                System.out.print("Telefone: ");
                usuario.setCelular(scan.nextLine());
                System.out.print("Genero: ");
                usuario.setGenero(scan.nextLine());
                System.out.print("CPF: ");
                usuario.setcpf(scan.nextLine());

                usuarioDAO.save(usuario);
            }
            else if (opcao == 2) {
                System.out.print("Digite o ID do usuário que deseja atualizar: ");
                Optional<Usuario> usuarioOptional = usuarioDAO.findById(scan.nextInt());
                Usuario usuario = usuarioOptional.get();
                System.out.print("Nome: ");
                scan.nextLine();
                usuario.setSobrenome(scan.nextLine());
                System.out.print("Sobrenome: ");
                usuario.setEmail(scan.nextLine());
                System.out.print("email: ");
                usuario.setSenha(scan.nextLine());
                System.out.print("senha: ");
                usuario.setCelular(scan.nextLine());
                System.out.print("Telefone: ");
                usuario.setGenero(scan.nextLine());
                System.out.print("Genero: ");
                usuario.setcpf(scan.nextLine());
                System.out.print("CPF: ");
                usuarioDAO.update(usuario);
            }
            else if (opcao == 3) {
                System.out.print("Digite o ID do usuário que deseja excluir: ");
                usuarioDAO.delete(scan.nextInt());
            }
            else if (opcao == 4) {
                List<Usuario> usuarios = usuarioDAO.findAll();
                for (Usuario usuario : usuarios) {
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Sobrenome: " + usuario.getSobrenome());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("senha: " + usuario.getSenha());
                    System.out.println("Tefefone: " + usuario.getCelular());
                    System.out.println("Genero: " + usuario.getGenero());
                    System.out.println("CPF: " + usuario.getCpf());
                    System.out.println();
                }
            }
            else {
                System.out.print("Digite o ID: ");
                Optional<Usuario> usuario = usuarioDAO.findById(scan.nextInt());
                usuario.ifPresent(idUsuario -> {
                    System.out.println(idUsuario.getId());
                    System.out.println(idUsuario.getNome());
                    System.out.println(idUsuario.getSobrenome());
                    System.out.println(idUsuario.getEmail());
                    System.out.println(idUsuario.getSenha());
                    System.out.println(idUsuario.getCelular());
                    System.out.println(idUsuario.getGenero());
                    System.out.println(idUsuario.getCpf());
                });
            }
        } else {
            do {
                System.out.println(
                        "\n" +  "[1] Cadastrar novo destino" + "\n" +
                                "[2] Atualizar dados do destino" + "\n" +
                                "[3] Excluir registro do destino" + "\n" +
                                "[4] Ver todos os destinos" + "\n" +
                                "[5] Buscar destino por ID" + "\n"
                );
                System.out.print(" # ");
                opcao = scan.nextInt();
            } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5);
            if (opcao == 1) {
                Destino destino = new Destino();
                scan.nextLine();
                System.out.print("nomeDestino: ");
                destino.setNomeDestino(scan.nextLine());
                System.out.print("valorPadrao: ");
                destino.setValorPadrao(scan.nextLine());
                System.out.print("valorPromocional: ");
                destino.setValorPromocional(scan.nextLine());


                destinoDAO.save(destino);
            }
            else if (opcao == 2) {
                System.out.print("Digite o ID do destino que deseja atualizar: ");
                Optional<Destino> destinoOptional = destinoDAO.findById(scan.nextLong());
                Destino destino = destinoOptional.get();
                destino.setNomeDestino(scan.nextLine());
                System.out.print("NomeDestino: ");
                destino.setNomeDestino(scan.nextLine());
                System.out.print("valorPadrao: ");
                destino.setValorPadrao(scan.nextLine());
                System.out.print("valorPromocional: ");
                destino.setValorPromocional(scan.nextLine());
                scan.nextLine();

                destinoDAO.update(destino);
            }
            else if (opcao == 3) {
                System.out.print("Digite o ID do destino que deseja excluir: ");
                destinoDAO.delete(scan.nextLong());
            }
            else if (opcao == 4) {
                List<Destino> destinos = destinoDAO.findAll();
                for (Destino destino: destinos) {
                    System.out.println("ID: " + destino.getId());
                    System.out.println("NomeDestino: " + destino.getNomeDestino());
                    System.out.println("valorPadrao: " + destino.getValorPadrao());
                    System.out.println("valorPromocional: " + destino.getvalorPromocional());
                    System.out.println();
                }

            }
            else {
                System.out.print("Digite o ID: ");
                Optional<Destino> destinoOptional = destinoDAO.findById(scan.nextLong());
                destinoOptional.ifPresent(destino -> {
                    System.out.println("ID: " + destino.getId());
                    System.out.println("NomeDestino: " + destino.getNomeDestino());
                    System.out.println("valorPadrao: " + destino.getValorPadrao());
                    System.out.println("valorPromocional: " + destino.getvalorPromocional());
                });
            }
        }

    }
}


