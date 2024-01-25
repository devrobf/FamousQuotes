package mmu.quotes;

public class QuoteComponent implements Component {
    private String quote;
    private String author;

    public QuoteComponent(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String render() {
        return "<div class='quote'><span class='quote-text'>" + quote + "</span><span class='quote-author'>- " + author + "</span></div>";
    }
}
