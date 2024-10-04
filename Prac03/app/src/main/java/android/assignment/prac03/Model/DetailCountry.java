package android.assignment.prac03.Model;


public class DetailCountry {
    private int image;
    private String nation;
    private String capital;

    public DetailCountry(String capital, int image, String nation) {
        this.capital = capital;
        this.image = image;
        this.nation = nation;
    }

    public DetailCountry() {
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
