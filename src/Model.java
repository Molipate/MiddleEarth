/**
 * Created by molipate on 30/11/16.
 */
public class Model {

    private int district;
    private int area;

    private int[] options;

    public Model(){

        district = 0;
        area = 0;

        options = new int[10];
        for (int i = 0; i < 10; i++)
            options[i] = 0;
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

    public int[] getOptions() {
        return options;
    }

    public void setOptions(int[] options) {
        this.options = options;
    }
}
