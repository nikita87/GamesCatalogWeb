package by.teachmeskills.rakhubovski.yasyuchenya.gamescataloguewebapp.entity;

public class Publisher {

    private Long id;
    private String name;
    private String country;

    public Publisher(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
