package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity;

public class PcGame {

    private Long id;
    private String title;
    private Genre genre;
    private String year;
    private Publisher publisher;
    private String description;
    private Price price = new Price();

    public static class Price {
        private Double value;
        private String currency;

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public PcGame(String title, Genre genre, String year, Publisher publisher, String description, Price price) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.publisher = publisher;
        this.description = description;
        this.price = price;
    }

    public PcGame() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Object price) {
        this.price = (Price) price;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PcGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", year='" + year + '\'' +
                ", publisher=" + publisher +
                ", description='" + description + '\'' +
                ", price=" + price.getValue() + " " + price.getCurrency() +
                '}';
    }
}
