/**
 * Created by molipate on 30/11/16.
 */
public class Main {

    public static void main(String []args){

        Model model = new Model();
        View view = new View(model);
        Control control = new Control(model, view);
    }
}
