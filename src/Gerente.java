import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Funcionario implements MostrarInfos,Gerenciar{


    private ArrayList<Atendente> atendentesContratados = new ArrayList<>();

    public ArrayList<Atendente> getAtendentesContratados() {
        return atendentesContratados;
    }

    public void setAtendentesContratados(ArrayList<Atendente> atendentesContratados) {
        this.atendentesContratados = atendentesContratados;
    }

    Scanner input = new Scanner(System.in);
    public Gerente(int id, String nome, String cpf) {
        super(id, nome, cpf);
    }

    public void registrarFuncionario(Atendente atendente){

        System.out.println("Digite o nome do atendente : ");
        atendente.nome=input.nextLine();
        System.out.println("Digite o cpf do atendente : ");
        atendente.cpf=input.nextLine();
        System.out.println("Qual o id do atendente ? ");
        atendente.id = input.nextInt();

        input.nextLine();


    }

    @Override
    public String toString() {
        return "Atendentes cadastrados :" + atendentesContratados;
    }

    @Override
    public void exibirInfos() {
        System.out.println("Atualmente "+ atendentesContratados.size()+ " Atendente(s) trabalham no estacionamento");


    }


    @Override
    public void relatorio(Estacionamento estacionamento) {
        System.out.println("Atualmente "+ atendentesContratados.size()+ " Atendente(s) trabalham no estacionamento:");
        for (Atendente x: atendentesContratados){
            System.out.println(x.nome);

        }
        System.out.println("\nO estacionamento possui "+ estacionamento.getPatios().size()+" Patios\n");
        for (int i =0;i< estacionamento.getPatios().size();i++) {
            Patio patio = estacionamento.getPatios().get(i);
            System.out.println("O patio "+ (i+1) +" atualmente possui "+patio.getVagasDisponiveis()+" Vagas disponiveis.");


        }
    }
}
