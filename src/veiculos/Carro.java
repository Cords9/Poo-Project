package veiculos;

public class Carro extends Veiculo{
    private int numPortas;


    public Carro(String marca, String modelo, String placa, String cor,int numPortas) {
        super(marca, modelo, cor, placa);
        this.numPortas= numPortas;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Carro " +
                "|| marca : " + marca +
                "|| modelo : " + modelo +
                "|| placa : " + placa +
                "|| Cor : " + cor + "|| Número de portas : " + numPortas+" ||";
    }
}
