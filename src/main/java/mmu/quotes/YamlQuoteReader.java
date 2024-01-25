package mmu.quotes;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class YamlQuoteReader {
    private String filePath;

    public YamlQuoteReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Map<String, Object>> readQuotes() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        return yaml.load(fileInputStream);
    }
}
