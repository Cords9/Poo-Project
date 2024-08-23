import java.io.IOException;

public interface Reserva {
    public void reservarVaga(Patio patio) throws InvalidPortasException, VagasIndisponiveisException, IOException;
    public void liberarVaga(Patio patio) throws IOException;
}

