public abstract class Veiculo {

    protected String marca;
    protected String modelo;
    protected String placa;
    protected String cor;


    public Veiculo(String marca, String modelo, String placa, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }


    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "||Veiculo - " +
                "marca - " + marca + '\'' +
                "|| modelo- '" + modelo + '\'' +
                "|| placa- " + placa + '\'' +
                "|| cor - " + cor + '\'' +
                "||";
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
