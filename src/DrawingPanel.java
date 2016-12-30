import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by molipate on 30/11/16.
 */
public class DrawingPanel extends JPanel {

    private BufferedImage background;
    private Ressources r;

    private ArrayList<Datas> d;
    private String district;
    private String area;
    private int[] options;
    private ImageIcon test;

    public DrawingPanel() {
        super();

        r = Ressources.getInstance();
        d = r.getDatas();
        setLayout(new BorderLayout());
    }

    public void update(String district, String area, int[] option){

        removeAll();

        this.district = district;
        this.area = area;
        this.options = option;

        background = r.getMap(area);

        /*double scale = (700 / (double) background.getWidth());
        int tmp_width = (int) (background.getWidth() * scale);
        int tmp_height = (int) (background.getHeight() * scale);

        test = new ImageIcon(background);
        test = new ImageIcon(test.getImage().getScaledInstance(tmp_width, tmp_height, BufferedImage.SCALE_SMOOTH));

        JLabel picLabel = new JLabel(test);
        add(picLabel, BorderLayout.EAST);*/
    }

    protected void paintComponent(Graphics g){

        ArrayList<Datas> d = r.getDatas();

        double scale = (700 / (double) background.getWidth());
        int tmp_width = (int) (background.getWidth() * scale);
        int tmp_height = (int) (background.getHeight() * scale);

        g.drawImage(background.getScaledInstance(tmp_width, tmp_height, BufferedImage.SCALE_SMOOTH), 300, 130, null);

        //Affichage des icones

        for (int i = 0; i < d.size(); i++) {

            Datas tmp = d.get(i);
            if (Objects.equals(tmp.getRegion(), district) && Objects.equals(tmp.getCommune(), area)) {
                if (tmp.getCategorie() != -1) {
                    if (options[tmp.getCategorie()] == 1) {
                        System.out.println("Affichage : " + tmp.getCategorie());
                        g.drawImage(r.getIcon(tmp.getCategorie()), tmp.getLatitude_z() + 42, tmp.getLongitude_z() - 303, null);
                    }
                }
            }
        }
    }
}
