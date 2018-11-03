package filesmanager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GeradorRelatorio {

    public static  void writeStream(String relatorio) throws IOException {
        Writer writer = new FileWriter("C:\\Users\\João Vinaud\\Desktop\\relatorioTeste.txt");

        try {
            writer.write(relatorio);
        } finally {
            writer.close();
        }
    }
}
