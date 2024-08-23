public abstract class Vagas {
    protected int idVaga;
    protected boolean ocupada;
    protected Veiculo veiculo;

    public Vagas(int idVaga, boolean ocupada, Veiculo veiculo) {
        this.idVaga = idVaga;
        this.ocupada = false;
        this.veiculo = veiculo;
    }

    public Vagas(int idVaga,Veiculo veiculo,boolean ocupada) {
        this.idVaga = idVaga;
        this.ocupada= false;
        this.veiculo=null;
    }

    public Vagas() {

    }


    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }


    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Vagas{" +
                "idVaga=" + idVaga +
                ", ocupada=" + ocupada +
                ", veiculo=" + veiculo +
                '}';
    }
}
