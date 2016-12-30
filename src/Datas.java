import java.util.Objects;

/**
 * Created by molipate on 29/12/16.
 */
public class Datas {

    private int latitude;
    private int longitude;

    private int latitude_z;
    private int longitude_z;

    private String ref;
    private String region;
    private String commune;

    //INSEE

    private String categorie;
    private String designation;
    private String proprietaire;
    private String description;

    private int annee;

    public Datas(String line) {

        String[] tmp = line.split(",");

        if(Objects.equals(tmp[0], ""))
            tmp[0] = "0";
        if(Objects.equals(tmp[1], ""))
            tmp[1] = "0";
        if(Objects.equals(tmp[2], ""))
            tmp[2] = "0";
        if(Objects.equals(tmp[3], ""))
            tmp[3] = "0";
        if(Objects.equals(tmp[12], ""))
            tmp[12] = "0";

        this.latitude = new Integer(tmp[0]);
        this.longitude = new Integer(tmp[1]);
        this.latitude_z = new Integer(tmp[2]);
        this.longitude_z = new Integer(tmp[3]);
        this.ref = tmp[4];
        this.region = tmp[5];
        this.commune = tmp[6];
        this.categorie = tmp[8];
        this.designation = tmp[9];
        this.proprietaire = tmp[10];
        this.description = tmp[11];
        this.annee = new Integer(tmp[12]);
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude_z() {
        return latitude_z;
    }

    public int getLongitude_z() {
        return longitude_z;
    }

    public String getRef() {
        return ref;
    }

    public String getRegion() {
        return region;
    }

    public String getCommune() {
        return commune;
    }

    public int getCategorie() {

        if(Objects.equals(categorie, "Bataille")) return 0;
        if(Objects.equals(categorie, "Fleuve")) return 1;
        if(Objects.equals(categorie, "Forêt")) return 2;
        if(Objects.equals(categorie, "Auberge")) return 3;
        if(Objects.equals(categorie, "Location de chevaux")) return 4;
        if(Objects.equals(categorie, "Montagne")) return 5;
        if(Objects.equals(categorie, "Point de régénération de magie ")) return 6;
        if(Objects.equals(categorie, "Hotel de soin")) return 7;
        if(Objects.equals(categorie, "Village")) return 8;

        return -1;
    }

    public String getDesignation() {
        return designation;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", latitude_z=" + latitude_z +
                ", longitude_z=" + longitude_z +
                ", ref='" + ref + '\'' +
                ", region='" + region + '\'' +
                ", commune='" + commune + '\'' +
                ", categorie='" + categorie + '\'' +
                ", designation='" + designation + '\'' +
                ", proprietaire='" + proprietaire + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
