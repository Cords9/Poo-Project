import javax.swing.*;
import java.util.ArrayList;

public class Patio implements MostrarInfos {
    private ArrayList<Vagas> vagas = new ArrayList<>(10);

    private int vagasDisponiveis = 10;

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Patio() {
        this.vagas = vagas;
    }

    public ArrayList<Vagas> getVagas() {
        return vagas;
    }

    public void setVagas(ArrayList<Vagas> vagas) {
        this.vagas = vagas;
    }




    public String toString() {
        return
                "Vagas Disponiveis - " + vagasDisponiveis +"\n" ;
    }

    @Override
    public void exibirInfos() {
        for (int i = 0; i < vagas.size(); i++) {
            System.out.println("Vaga " + vagas.get(i).idVaga + ": " + vagas.get(i).getVeiculo());
        }

    }
}
