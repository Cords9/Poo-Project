import estacionamento.Estacionamento;
import estacionamento.Patio;
import exceptions.AtendentesInsuficientesExceptions;
import exceptions.IdTwinException;
import exceptions.InvalidPortasException;
import exceptions.VagasIndisponiveisException;
import funcionario.Atendente;
import funcionario.Gerente;
import monitoramento.Log;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidPortasException, VagasIndisponiveisException, AtendentesInsuficientesExceptions, IdTwinException, IOException {



        Scanner input = new Scanner(System.in);


        Estacionamento estacionamento = new Estacionamento();

        Patio terreo = new Patio();
        Patio andar1 = new Patio();
        Patio andar2 = new Patio();

        estacionamento.getPatios().add(terreo);
        estacionamento.getPatios().add(andar1);
        estacionamento.getPatios().add(andar2);

        Log registros = new Log();

        Gerente gerente = new Gerente(1, "Marcos", "092-424-512-21");

        Atendente atendente = new Atendente();


        while (true) {
            System.out.println("Bem-vindo! Qual é o seu tipo de usuário?");
            System.out.println("1-Atendente 2-Gerente");

            int escolhaUsuario = input.nextInt();
            input.nextLine();
            while (escolhaUsuario <= 0 || escolhaUsuario > 2) {
                System.out.println("Escolha invalida. Insira uma opção valida!");
                escolhaUsuario = input.nextInt();
                input.nextLine();
            }

            try {

                if (escolhaUsuario == 1 && gerente.getAtendentesContratados().size() == 0) {
                    throw new AtendentesInsuficientesExceptions("Nenhum atendente contratado! Fale com o gerente para realizar seu cadastro.");
                } else if (escolhaUsuario == 1) {


                        System.out.println("Escolha o atendente:");
                        for (int i = 0; i < gerente.getAtendentesContratados().size(); i++) {
                            System.out.println((i + 1) + "||" + gerente.getAtendentesContratados().get(i).getNome());
                        }
                        int escolhaAtendente = input.nextInt();
                        input.nextLine();

                        Atendente oAtendente = gerente.getAtendentesContratados().get(escolhaAtendente - 1);

                        if (escolhaAtendente <= 0) {
                            System.out.println("Escolha invalida!!");
                        } else {

                            System.out.println("Bem-Vindo " + oAtendente.getNome() + "!!");
                            registros.registrarLog("O Atendente "+ oAtendente.getNome() + " entrou no sistema");
                        }
                    while (true) {
                        System.out.println("---------Menu do atendente---------");
                        System.out.println("1-Reservar vaga.");
                        System.out.println("2-Liberar vaga.");
                        System.out.println("3-Checar disponibilidade de Vagas.");
                        System.out.println("4-Checar Veiculos no patio.");
                        System.out.println("5-Sair.");
                        int escolhaMenuAt = input.nextInt();
                        input.nextLine();

                        if (escolhaMenuAt == 1) {
                            System.out.println("Em qual Patio o veiculo será estacionado ? ");
                            System.out.println("1- Patio 1 ||2- Patio 2 ||3- Patio 3");
                            int escolhaReserv = input.nextInt();
                            input.nextLine();


                            if (escolhaReserv == 1) {
                                atendente.reservarVaga(terreo);


                            }
                            if (escolhaReserv == 2) {
                                atendente.reservarVaga(andar1);
                            }
                            if (escolhaReserv == 3) {
                                atendente.reservarVaga(andar2);
                            }

                        }


                        if (escolhaMenuAt == 2) {
                            System.out.println("Em qual patio esta o veiculo a ser liberado ?-");
                            System.out.println("1- Patio 1 ||2- Patio 2 ||3- Patio 3");
                            int escolhaResevb = input.nextInt();
                            input.nextLine();

                            if (escolhaResevb == 1) {
                                atendente.liberarVaga(terreo);
                            }
                            if (escolhaResevb == 2) {
                                atendente.liberarVaga(andar1);
                            }
                            if (escolhaResevb == 3) {
                                atendente.liberarVaga(andar2);
                            }
                        }

                        if(escolhaMenuAt==3){
                            System.out.println("Informe o pátio para checar a disponibilidade de vagas:");
                            System.out.println("1- Patio 1 ||2- Patio 2 ||3- Patio 3");
                            int escolhaP = input.nextInt();
                            input.nextLine();
                            if (escolhaP ==1){
                                System.out.println(terreo);
                            }
                            if (escolhaP ==2){
                                System.out.println(andar1);
                            }
                            if (escolhaP ==3){
                                System.out.println(andar2);
                            }

                        }
                        if (escolhaMenuAt==4) {
                            System.out.println("Selecione o pátio para visualizar os veículos estacionados: ");
                            System.out.println("1- Patio 1 ||2- Patio 2 ||3- Patio 3");
                            int escolhaPaVe = input.nextInt();
                            input.nextLine();

                            if (escolhaPaVe == 1) {
                                if (terreo.getVagas().size()==0){
                                    System.out.println("O pátio está vazio no momento.");
                                }else {
                                    terreo.exibirInfos();
                                }

                            }
                            if (escolhaPaVe == 2) {
                                if (andar1.getVagas().size()==0){
                                    System.out.println("O pátio está vazio no momento.");
                                }else {
                                    andar1.exibirInfos();
                                }
                            }
                            if (escolhaPaVe == 3) {
                                if (andar2.getVagas().size()==0){
                                    System.out.println("O pátio está vazio no momento.");
                                }else {
                                    andar2.exibirInfos();
                                }
                            }
                        }
                        if (escolhaMenuAt==5){
                            registros.registrarLog("O atendente "+ oAtendente.getNome() +" saiu do sistema");
                            break;

                        }

                    }

                }


            } catch (AtendentesInsuficientesExceptions e) {
                System.out.println(e.getMessage());
            }




                if (escolhaUsuario == 2) {
                    System.out.println("Seja bem-vindo " + gerente.getNome() + " .");
                    registros.registrarLog("O gerente "+ gerente.getNome() +" entrou no sistema .");

                    while (true) {
                        System.out.println("----------Menu do gerente----------");
                        System.out.println("1- Cadastrar atendente.");
                        System.out.println("2- Ver atendentes na equipe.");
                        System.out.println("3- Ver tamanho da equipe.");
                        System.out.println("4- Gerar relatorio de disponibilidade.");
                        System.out.println("5- Checar logs do sistema.");
                        System.out.println("6- Sair.");
                        System.out.println("Esolha uma opção: ");
                        int escolhaGerente = input.nextInt();
                        input.nextLine();
                        while (escolhaGerente <= 0 || escolhaGerente > 6) {
                            System.out.println("Opção invalida!! Escolha uma opção valida.");
                            escolhaGerente = input.nextInt();
                            input.nextLine();
                        }

                        if (escolhaGerente == 1) {
                            Atendente novoatendente = new Atendente();

                            boolean jaContratado = false;
                            gerente.registrarFuncionario(novoatendente);


                            for (Atendente x : gerente.getAtendentesContratados()){
                                if (x.getId() == novoatendente.getId()){
                                    jaContratado=true;
                                    try {
                                        throw new IdTwinException("Não possivel realizar o cadastro. Ja existe um usuario com esse id!");
                                    }catch (IdTwinException e){
                                        System.out.println(e.getMessage());
                                    }



                                }
                            }

                            if (jaContratado==false){
                                gerente.getAtendentesContratados().add(novoatendente);
                                registros.registrarLog("Novo atendente registrado no sistema: "+ novoatendente);
                                registros.registrarLog("Atendentes registrados no estacionamento- "+gerente.getAtendentesContratados());
                                System.out.println("Cadastro concluido com sucesso!!!");
                            }





                        }
                        if (escolhaGerente == 2) {
                            System.out.println(gerente.getAtendentesContratados());

                        }
                        if (escolhaGerente == 3) {
                            gerente.exibirInfos();
                        }
                        if (escolhaGerente == 4) {
                            gerente.relatorio(estacionamento);
                        }
                        if (escolhaGerente==5){
                            registros.visualizarLog();
                        }
                        if (escolhaGerente == 6) {
                            registros.registrarLog("O gerente "+ gerente.getNome() +" saiu do sistema .");
                            break;
                        }
                    }
                }



        }
    }
}