package vaga;

import veiculos.Veiculo;

import java.util.ArrayList;

public class Vagamoto extends Vagas {

    public Vagamoto(int idVaga, boolean ocupada, Veiculo veiculo) {
        super(idVaga, ocupada, veiculo);
    }

    public Vagamoto() {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
                "\nID da vaga : " + idVaga +
                "\nTipo de veiculo:" + veiculo;
    }

}
