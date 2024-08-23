import java.util.ArrayList;

public class Vagacarro extends Vagas {

    @java.lang.Override
    public java.lang.String toString() {
        return
                "\n Id da vaga :" + idVaga +
                        "\n Tipo de veiculo : " + veiculo + "\n";
    }

    public Vagacarro(int idVaga, boolean ocupada, Veiculo veiculo) {
        super(idVaga, ocupada, veiculo);
    }

    public Vagacarro() {
    }


}
