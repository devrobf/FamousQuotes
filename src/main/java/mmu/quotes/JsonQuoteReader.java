package mmu.quotes;
import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonQuoteReader implements QuoteReader {
    private String filePath;

    public JsonQuoteReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Map<String, Object>> readQuotes() throws FileNotFoundException
    {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(filePath);
        return gson.fromJson(fileReader,
        new TypeToken<List<Map<String, Object>>>() {}.getType());
    }
}