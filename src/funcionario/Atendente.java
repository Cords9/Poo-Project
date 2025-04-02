package funcionario;

import estacionamento.Patio;
import exceptions.IdTwinException;
import exceptions.InvalidPortasException;
import exceptions.VagasIndisponiveisException;
import monitoramento.Log;
import vaga.Vagacarro;
import vaga.Vagamoto;
import vaga.Vagas;
import veiculos.Carro;
import veiculos.Moto;
import veiculos.Veiculo;

import java.io.IOException;
import java.util.Scanner;

public class Atendente extends Funcionario {

    Log registros = new Log();

    Scanner input = new Scanner(System.in);

    public Atendente(int id, String nome, String cpf) throws IOException {
        super(id, nome, cpf);
    }

    public Atendente() throws IOException {
    }


    public void reservarVaga(Patio patio) throws InvalidPortasException, VagasIndisponiveisException, IOException {
        Veiculo veiculo = null;
        Vagas vaga = null;


        System.out.println("Qual tipo de veiculo sera estatacionado ? ");
        System.out.println("1 - Carro | 2 - Moto ");
        int tipo = input.nextInt();
        input.nextLine();

        while (tipo != 1 && tipo != 2) {
            System.out.println("Opção inválida! Escolha uma opção válida!");
            System.out.println("Qual tipo de veículo será estacionado?");
            System.out.println("1 - Carro | 2 - Moto ");
            tipo = input.nextInt();
            input.nextLine();
        }


        if (tipo == 1) {

            System.out.println("Insira a marca do carro : ");
            String marca = input.nextLine();
            System.out.println("Insira o modelo do carro: ");
            String modelo = input.nextLine();
            System.out.println("Insira a cor do carro: ");
            String cor = input.nextLine();
            System.out.println("Insira a placa do carro: ");
            String placa = input.nextLine();

            try {
                System.out.println("Insira o número de portas do carro:");
                int numportas = input.nextInt();
                input.nextLine();
                if (numportas != 2 && numportas != 4) {
                    throw new InvalidPortasException("A quantidade de portas do carro está incorreta !!!");
                }
                veiculo = new Carro(marca, modelo, cor, placa, numportas);
                vaga = new Vagacarro();
                registros.registrarLog("Um Carro entrou no estacionamento- "+veiculo);
                System.out.println("Cadastro do veiculo concluido !!");
            } catch (InvalidPortasException e) {
                System.out.println("Erro: " + e.getMessage() + "\n Realize o cadastro novamente !");
                return;
            }

        }
        if (tipo == 2) {
            System.out.println("Insira a marca da moto  : ");
            String marca = input.nextLine();
            System.out.println("Insira o modelo da moto : ");
            String modelo = input.nextLine();
            System.out.println("Insira a cor da moto : ");
            String cor = input.nextLine();
            System.out.println("Insira a placa da moto : ");
            String placa = input.nextLine();
            System.out.println("Cadastro do veiculo concluido !!");
            veiculo = new Moto(marca, modelo, cor, placa);
            vaga = new Vagamoto();
            registros.registrarLog("Uma moto entrou no sistema- "+veiculo);

        }


        try {
            System.out.println("Insira o Id da vaga onde o veiculo sera estacionado :");
            int idVaga = input.nextInt();
            input.nextLine();

            while (idVaga >10|| idVaga <=0){
                System.out.println("Id "+idVaga+" Não disponivel.Por favor Selecione um Id Valido !" );
                idVaga = input.nextInt();
                input.nextLine();
            }

            for (Vagas v : patio.getVagas()) {
                if (v.getIdVaga() == idVaga && (v.ocupada == true)) {
                    throw new IdTwinException("O id da vaga selecionada ja esta preenchido !!");
                }
            }
            vaga.idVaga = idVaga;
            vaga.veiculo = veiculo;
            vaga.ocupada = true;
            System.out.println("Veiculo estacionado com sucesso.");

            if (patio.getVagasDisponiveis() <= 0) {
                throw new VagasIndisponiveisException(" Vagas indisponiveis ! O Patio esta Cheio !!");
            }
            patio.getVagas().add(vaga);
            patio.setVagasDisponiveis(patio.getVagasDisponiveis() - 1);
        } catch (VagasIndisponiveisException e) {
            System.out.println(e.getMessage());
        } catch (IdTwinException e) {
            System.out.println(e.getMessage());
            ;
        }


    }


    public void liberarVaga(Patio patio) throws IOException {

        boolean verificaVaga=false;

        for (Vagas vaga : patio.getVagas()){
            if (vaga.ocupada==true){
                verificaVaga=true;
            }
        }

        if (verificaVaga==false){
            System.out.println("Atualmente não há veiculos estacionados neste patio.");
            return;
        }



        System.out.println("Veiculos no patio:");
        for (Vagas vaga : patio.getVagas()) {
            Veiculo veiculo = vaga.getVeiculo();
            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                System.out.println("|| Id da vaga: " + vaga.idVaga + "|| Tipo de veiculo: Carro||" + " Marca: " + carro.marca + "|| Modelo: " + carro.modelo + " || Numero de portas: " + carro.getNumPortas() + " || Cor do carro: " + carro.cor + " || Placa- " + carro.placa + " ||");


            } else {
                Moto moto = (Moto) veiculo;
                System.out.println("|| Id da vaga: " + vaga.idVaga + " || Tipo de veiculo: Moto" + " || Marca: " + moto.marca + " || Modelo: " + moto.modelo + " || Cor: " + moto.cor + " || Placa: " + moto.placa + " ||");
            }
        }

            System.out.println("Insira o id da vaga que deseja liberar: ");
            int removeVaga = input.nextInt();
            input.nextLine();

            while (removeVaga>10 || removeVaga<=0){
                System.out.println("ID invalido. Por favor, selecione um ID válido.");
                removeVaga=input.nextInt();
                input.nextLine();
            }

            Vagas vagaRemovida = null;

            for (Vagas v : patio.getVagas()){
                if (v.idVaga == removeVaga && (v.ocupada==true)){
                    vagaRemovida=v;

                }
            }

            if (vagaRemovida != null){
                registros.registrarLog("Uma vaga foi liberada - "+vagaRemovida);
                patio.getVagas().remove(vagaRemovida);
                patio.setVagasDisponiveis(patio.getVagasDisponiveis()+1);
                System.out.println("Veiculo liberado.");
                System.out.println("A vaga de ID "+ removeVaga+" agora esta disponivel !");
            }else {
                System.out.println("Não existe nenhum veiculo cadastrado nessa vaga !");
            }








    }

    @Override
    public String toString() {
        return "||Atendente- " +nome+
                "||ID- " + id +
                "||CPF- " + cpf +
                "||";
    }
}