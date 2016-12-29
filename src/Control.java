import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by molipate on 30/11/16.
 */
public class Control implements ActionListener{

    private Model model;
    private View view;

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand() == "LD"){

            model.setDistrict(view.getDistrictID());
            model.setArea(0);
            view.update();
            view.render();
        }

        else if(e.getActionCommand() == "LA"){

            if(view.getAreaID() != -1)
                model.setArea(view.getAreaID());
            view.update();
            view.render();
        }

        else if(e.getActionCommand() == "BI"){

            model.setOptions(view.getOptions());
            view.update();
            view.render();
        }
    }
}
