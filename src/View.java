import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by molipate on 30/11/16.
 */
public class View extends JFrame {

    private Model model;

    private JComboBox<String> listDistrict;
    private JComboBox<String> listArea;

    private JLabel labelDistrict;
    private JLabel labelArea;
    private JTextPane infos;

    private JCheckBox []boxIcons;

    private JPanel options_panel;
    private DrawingPanel drawing_panel;

    private Ressources r;

    private final String [][]area = new String[][]{
            {"Middle Earth"},
            {"Eriador", "Angmar", "Comté", "Enedwaith", "Eredluin", "Eregion", "Evendim", "Forochel",
                    "Hauts du nord", "Landes d'etten", "Monts brumeux", "Nan curunir", "Pays de bree", "Pays de Dun",
                    "Terres solitaires", "Trouée des trolls"},
            {"Gondor", "Ancien Anorien", "Centre Gondor", "Est Gondor", "Lointain Anorien", "Marais Morts",
                    "Minastirith", "Osgiliath", "Ouest Gondor"},
            {"Mordor"},
            {"Rhovanion", "Fangorn", "Foret Noiresud", "Grand fleuve", "Lothlorien", "Moria",
                    "Rohan Est", "Rohan Ouest"}};

    private final String []iconsName = new String[]{"Batailles", "Rivières", "Forêts", "Auberges",
            "Locations Cheveaux", "Montagnes", "Sources de magie", "Sources de santé", "Villes", "Campements"};

    public View(Model model) {
        this.model = model;

        listDistrict = new JComboBox<>(new String[]{"Middle Earth", "Eriador", "Gondor", "Mordor", "Rhovanion"});
        listArea = new JComboBox<>();

        labelDistrict = new JLabel("Région principale : ");
        labelArea = new JLabel("Région secondaire : ");

        boxIcons = new JCheckBox[iconsName.length];
        for (int i = 0; i < iconsName.length; i++)
            boxIcons[i] = new JCheckBox(iconsName[i]);

        infos = new JTextPane();

        options_panel = new JPanel(new GridLayout(15, 2));
        drawing_panel = new DrawingPanel();

        options_panel.setSize(300, 700);
        drawing_panel.setSize(700, 700);

        r = Ressources.getInstance();

        drawing_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    displayInfo(e.getX(), e.getY());
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        });

        setTitle("Middle Earth Map");
        setResizable(false);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(150, 50);

        update();
        render();
    }

    private void displayInfo(int x, int y) throws BadLocationException {

        ArrayList<Datas> d = r.getDatas();

        for (int i = 0; i < d.size(); i++) {

            Datas tmp = d.get(i);
            if (Objects.equals(tmp.getRegion(), area[model.getCurrentDistrict()][0])
                    && Objects.equals(tmp.getCommune(), area[model.getCurrentDistrict()][model.getCurrentArea()])) {
                if (tmp.getCategorie() != -1) {
                    if (model.getOptions()[tmp.getCategorie()] == 1) {
                        if(x >= tmp.getLatitude_z() + 42 &&  x <= tmp.getLatitude_z() + 66) {
                            if (y >= tmp.getLongitude_z() - 303 && y <= tmp.getLongitude_z() - 279)
                                infos.getStyledDocument().insertString(tmp.getDescription().length(), tmp.getDescription(), new SimpleAttributeSet());
                        }

                    }
                }
            }
        }

    }

    public void setActionListener(Control actionListener) {

        listDistrict.setActionCommand("LD");
        listDistrict.addActionListener(actionListener);

        listArea.setActionCommand("LA");
        listArea.addActionListener(actionListener);


        for (int i = 0; i < boxIcons.length; i++) {
            boxIcons[i].setActionCommand("BI");
            boxIcons[i].addActionListener(actionListener);
        }
    }

    public void update() {

        listArea.removeAllItems();
        for (int i = 0; i < area[model.getCurrentDistrict()].length; i++)
            listArea.addItem(area[model.getCurrentDistrict()][i]);
        listArea.setSelectedIndex(model.getCurrentArea());

        drawing_panel.update(area[model.getCurrentDistrict()][0], area[model.getCurrentDistrict()][model.getCurrentArea()], model.getOptions());
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

        int[] options = model.getOptions();

        for(int i = 0; i < options.length; i++)
            if(options[i] == 1)
                boxIcons[i].setSelected(true);

        options_panel.add(infos);

        drawing_panel.repaint();
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

    public int[] getOptions(){

        int[] options = new int[10];

        for (int i = 0; i < 10; i++)
            options[i] = 0;

        if(boxIcons[0].isSelected())
            options[0] = 1;
        if(boxIcons[1].isSelected())
            options[1] = 1;
        if(boxIcons[2].isSelected())
            options[2] = 1;
        if(boxIcons[3].isSelected())
            options[3] = 1;
        if(boxIcons[4].isSelected())
            options[4] = 1;
        if(boxIcons[5].isSelected())
            options[5] = 1;
        if(boxIcons[6].isSelected())
            options[6] = 1;
        if(boxIcons[7].isSelected())
            options[7] = 1;
        if(boxIcons[8].isSelected())
            options[8] = 1;
        if(boxIcons[9].isSelected())
            options[9] = 1;

        return options;
    }
}
