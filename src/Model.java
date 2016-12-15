/**
 * Created by molipate on 30/11/16.
 */
public class Model {

    private int district;
    private int area;

    public Model(){

        district = 0;
        area = 0;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCurrentDistrict() {
        return district;
    }

    public int getCurrentArea() {
        return area;
    }
}
