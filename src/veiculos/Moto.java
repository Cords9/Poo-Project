package veiculos;

public class Moto extends Veiculo{


    public Moto(String marca, String modelo, String placa, String cor) {
        super(marca, modelo, cor, placa);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return " Moto" +
                "|| Marca - " + marca +
                "|| Modelo- " + modelo +
                "|| Placa- " + placa +
                "|| Cor- " + cor + "||";
    }
}
