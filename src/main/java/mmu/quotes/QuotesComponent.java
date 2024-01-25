package mmu.quotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuotesComponent implements Component {
    private List<QuoteComponent> quotes;

    public QuotesComponent(List<QuoteComponent> quotes) {
        this.quotes = quotes;
    }

    
    public static QuotesComponent createFromQuoteMaps(List<Map<String, Object>> quoteMaps) {
        List<QuoteComponent> quotes = new ArrayList<>();

        for (Map<String, Object> quoteMap : quoteMaps) {
            String author = (String) quoteMap.get("author");
            String quoteText = (String) quoteMap.get("quote");
            QuoteComponent quote = new QuoteComponent(quoteText, author);
            quotes.add(quote);
        }

        return new QuotesComponent(quotes);
    }

    public String render() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>Famous Quotes</h1>\n<div class='quotes'>\n");
        for (QuoteComponent quote : quotes) {
            stringBuilder.append(quote.render() + "\n");
        }
        stringBuilder.append("</div>\n");
        return stringBuilder.toString();
    }
}
