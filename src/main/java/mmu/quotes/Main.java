package mmu.quotes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static final void main(String args[]) {
        try {
            YamlQuoteReader reader = new YamlQuoteReader("src/main/resources/quotes.yaml");
            Component initialComponent = QuotesComponent.createFromQuoteMaps(reader.readQuotes());
            renderToFile(initialComponent);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void renderToFile(Component component) throws IOException {
        new File("dist").mkdirs();
        FileWriter fileWriter = new FileWriter("dist/index.html");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Add styling
        String style = new String(Files.readAllBytes(Paths.get("src/main/resources/style.css")));
        bufferedWriter.write("<style>\n" + style + "\n</style>\n");

        // Render main component
        bufferedWriter.write(component.render());
        bufferedWriter.close();
    }
}