package android.assignment.prac03.Model;

public class ConuntryInfo {
    private int image;
    private String countryName;
    private String description;

    public ConuntryInfo(String countryName, String description, int image) {
        this.countryName = countryName;
        this.description = description;
        this.image = image;
    }

    public ConuntryInfo() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
