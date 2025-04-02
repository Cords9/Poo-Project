package monitoramento;

import java.io.*;
import java.util.Scanner;

public class Log {

    String path = "L0gEstacionamento.txt";
    File file = new File(path);


    public Log() throws IOException {
    }

    public void registrarLog(String logs) throws IOException {
        FileWriter fw = new FileWriter(path,true);
        fw.write(logs+"\n");
        fw.close();
    }

    public void visualizarLog() throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader leitura = new BufferedReader(fr);

        String linhas;

        while ((linhas = leitura.readLine()) != null){
            System.out.println(linhas);

        }


    }

}
