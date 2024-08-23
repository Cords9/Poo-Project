import java.util.ArrayList;

public class Estacionamento implements MostrarInfos {

    private ArrayList<Patio> patios = new ArrayList<>();

    public ArrayList<Patio> getPatios() {
        return patios;
    }

    public void setAndares(ArrayList<Patio> andares) {
        this.patios = andares;
    }

    @Override
    public String toString() {
        String conc ="";
        for (int i =0;i<patios.size();i++){
            conc += "Patio - " + (i+1) + "\n";
            conc += patios.get(i).toString();
        }
        return conc;
    }


    @Override
    public void exibirInfos() {
        System.out.println("Patios do Estacionamento:");
        for (int i = 0; i < patios.size(); i++) {
            System.out.println("Patio " + (i+1) + ": " + patios.get(i));
        }
    }

}
