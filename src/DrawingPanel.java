import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by molipate on 30/11/16.
 */
public class DrawingPanel extends JPanel {

    private BufferedImage background;
    private ImageIcon test;
    private Ressources r;

    private int[] options;
    private String district;
    private String area;

    public DrawingPanel() {
        super();

        r = Ressources.getInstance();

        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0));
    }

    public void update(String str, String dis, int[] op){

        removeAll();

        options = op;
        district = dis;
        area = str;

        background = r.getMap(str);
        double scale = (700 / (double) background.getWidth());

        int tmp_width = (int) (background.getWidth() * scale);
        int tmp_height = (int) (background.getHeight() * scale);

        test = new ImageIcon(background);
        test = new ImageIcon(test.getImage().getScaledInstance(tmp_width, tmp_height, BufferedImage.SCALE_SMOOTH));

        JLabel picLabel = new JLabel(test);
        add(picLabel, BorderLayout.EAST);

        ArrayList<Datas> d = r.getDatas();

        Datas tmp = d.get(0);

        BufferedImage img = r.getIcon(0);

        Graphics g = img.getGraphics();
        g.drawImage(img, 50, 50, null);
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        ArrayList<Datas> d = r.getDatas();

        System.out.println("Affichage de l'icone");
        g.drawImage(r.getIcon(0), 100, 100, null);

        for (int i = 0; i < d.size(); i++) {
            Datas tmp = d.get(i);

            //System.out.println(tmp.getRegion());
            //System.out.println(tmp.getCommune());

            if(tmp.getRegion() == district && tmp.getCommune() == area){
                System.out.println("first");
                if(tmp.getCategorie() != -1)
                    if(options[tmp.getCategorie()] == 1){
                        System.out.println("Affichage : " + tmp.getRef());
                        g.drawImage(r.getIcon(options[tmp.getCategorie()]), tmp.getLatitude(), tmp.getLongitude(), null);
                    }

            }
        }
        //g.drawImage()
    }
}
