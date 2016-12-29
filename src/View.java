import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by molipate on 30/11/16.
 */
public class View extends JFrame {

    private Model model;

    private JComboBox<String> listDistrict;
    private JComboBox<String> listArea;

    private JLabel labelDistrict;
    private JLabel labelArea;

    private JLabel []labelIcons;
    private JCheckBox []boxIcons;

    private JPanel options_panel;
    private DrawingPanel drawing_panel;

    private final String [][]area = new String[][]{
            {"Middle Earth"},
            {"Eriador", "Angmar", "Comté", "Enedwaith", "Eredluin", "Eregion", "Evendim", "Forochel",
                    "Hauts du nord", "Landes d'Etten", "Monts Brumeux", "Nan Curunir", "Pays de Bree", "Pays de Dun",
                    "Terres solitaires", "Trouée des trolls"},
            {"Gondor", "Ancien Anorien", "Centre Gondor", "Est Gondor", "Lointain Anorien", "Marais Morts",
                    "Minastirith", "Osgiliath", "Ouest Gondor"},
            {"Mordor"},
            {"Rhovanion", "Fangorn", "Foret Noiresud", "Grand fleuve", "Lothlorien", "Moria",
                    "Rohan Est", "Rohan Ouest"}};

    private final String []iconsName = new String[]{"Batailles", "Rivières", "Forêts", "Auberges",
            "Locations Cheveaux", "Montagnes", "Sources de magie", "Sources de santé", "Villes"};

    public View(Model model) {
        this.model = model;

        listDistrict = new JComboBox<>(new String[]{"Middle Earth", "Eriador", "Gondor", "Mordor", "Rhovanion"});
        listArea = new JComboBox<>();

        labelDistrict = new JLabel("Région principale : ");
        labelArea = new JLabel("Région secondaire : ");

        labelIcons = new JLabel[iconsName.length];
        for (int i = 0; i < iconsName.length; i++)
            labelIcons[i] = new JLabel(iconsName[i]);

        boxIcons = new JCheckBox[iconsName.length];
        for (int i = 0; i < iconsName.length; i++)
            boxIcons[i] = new JCheckBox(iconsName[i]);

        options_panel = new JPanel(new GridLayout(20, 2));
        drawing_panel = new DrawingPanel();

        options_panel.setSize(300, 700);
        drawing_panel.setSize(700, 700);

        setTitle("Middle Earth Map");
        setResizable(false);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(150, 50);

        update();
        render();
    }

    public void setActionListener(Control actionListener) {

        listDistrict.setActionCommand("LD");
        listDistrict.addActionListener(actionListener);

        listArea.setActionCommand("LA");
        listArea.addActionListener(actionListener);
    }

    public void update() {

        listArea.removeAllItems();
        for (int i = 0; i < area[model.getCurrentDistrict()].length; i++)
            listArea.addItem(area[model.getCurrentDistrict()][i]);
        listArea.setSelectedIndex(model.getCurrentArea());

        drawing_panel.update(area[model.getCurrentDistrict()][model.getCurrentArea()]);
    }

    public void render() {

        options_panel.removeAll();

        options_panel.add(labelDistrict);
        options_panel.add(listDistrict);
        options_panel.add(labelArea);
        options_panel.add(listArea);

        options_panel.add(new JLabel());
        options_panel.add(new JLabel());

        for (int i = 0; i < iconsName.length; i++) {
            options_panel.add(boxIcons[i]);
            options_panel.add(new JLabel());
        }

        add(options_panel);
        add(drawing_panel);

        setVisible(true);
    }

    public int getDistrictID() {
        return listDistrict.getSelectedIndex();
    }

    public int getAreaID() {
        return listArea.getSelectedIndex();
    }
}
