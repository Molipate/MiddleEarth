import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.io.*;
import java.util.*;

/**
 * Created by molipate on 07/12/16.
 */
public class Ressources {

    private static Ressources ourInstance = new Ressources();

    private Map<String, BufferedImage> maps;
    private ArrayList<Datas> datas;
    private ArrayList<BufferedImage> icons;

    public static Ressources getInstance() {
        return ourInstance;
    }

    public BufferedImage getMap(String str){

        Set<Map.Entry<String, BufferedImage>> sethm = maps.entrySet();
        Iterator<Map.Entry<String, BufferedImage>> it = sethm.iterator();

        while(it.hasNext()){
            Map.Entry<String, BufferedImage> e = it.next();
            if(e.getKey() == str)
                return e.getValue();
        }

        return null;
    }

    public ArrayList<Datas> getDatas() {
        return datas;
    }

    public BufferedImage getIcon(int id){
        return icons.get(id);
    }

    private Ressources() {

        maps = new HashMap<String, BufferedImage>();
        datas = new ArrayList<>();
        icons = new ArrayList<>();
        try {
            icons.add(ImageIO.read(new File("Assets/Icons/batailles..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/fleuve..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/foret..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/inn..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/locachevaux..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/montagne..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/regenmagie..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/regensante..png")));
            icons.add(ImageIO.read(new File("Assets/Icons/ville..png")));
        }
        catch (IOException e){
            System.out.println(e.toString());
        }

        try{

            maps.put("Middle Earth", ImageIO.read(new File("Assets/middlearth.png")));
            /*maps.put("Eriador", ImageIO.read(new File("Assets/eriador/eriador.png")));
            maps.put("Angmar", ImageIO.read(new File("Assets/eriador/angmar/angmar.png")));
            maps.put("Comté", ImageIO.read(new File("Assets/eriador/comté/comté.png")));
            maps.put("Enedwaith", ImageIO.read(new File("Assets/eriador/enedwaith/enedwaith.png")));
            maps.put("Eredluin", ImageIO.read(new File("Assets/eriador/eredluin/eredluin.png")));
            maps.put("Eregion", ImageIO.read(new File("Assets/eriador/eregion/eregion.png")));
            maps.put("Forochel", ImageIO.read(new File("Assets/eriador/forochel/forochel.png")));
            maps.put("Hauts du nord", ImageIO.read(new File("Assets/eriador/hauts du nord/hautsdunord.png")));
            maps.put("Landes d'Etten", ImageIO.read(new File("Assets/eriador/landes d'etten/landesetten.png")));
            maps.put("Monts Brumeux", ImageIO.read(new File("Assets/eriador/monts brumeux/montsbrumeux.png")));
            maps.put("Nan Curunir", ImageIO.read(new File("Assets/eriador/nan curunir/nan curunir.png")));
            maps.put("Pays de Bree", ImageIO.read(new File("Assets/eriador/pays de bree/paysbree.png")));
            maps.put("Pays de Dun", ImageIO.read(new File("Assets/eriador/pays de dun/paysdun.png")));
            maps.put("Terres solitaires", ImageIO.read(new File("Assets/eriador/terres solitaires/terressolitaires.png")));
            maps.put("Trouée des trolls", ImageIO.read(new File("Assets/eriador/trouée des trolls/troueetrolls.png")));

            maps.put("Gondor", ImageIO.read(new File("Assets/gondor/gondor.png")));
            maps.put("Ancien Anorien", ImageIO.read(new File("Assets/gondor/ancienanorien/ancienanorien.png")));
            maps.put("Centre Gondor", ImageIO.read(new File("Assets/gondor/centregondor/centregondor.png")));
            maps.put("Est Gondor", ImageIO.read(new File("Assets/gondor/estgondor/estgondor.png")));
            maps.put("Lointain Anorien", ImageIO.read(new File("Assets/gondor/lointainanorien/lointainanorien.png")));
            maps.put("Marais Morts", ImageIO.read(new File("Assets/gondor/maraismorts/maraismorts.png")));
            maps.put("Minastirith", ImageIO.read(new File("Assets/gondor/minastirith/minastirith.png")));
            maps.put("Osgiliath", ImageIO.read(new File("Assets/gondor/osgiliath/osgiliath.png")));
            maps.put("Ouest Gondor", ImageIO.read(new File("Assets/gondor/ouestgondor/ouestgondor.png")));

            maps.put("Mordor", ImageIO.read(new File("Assets/mordor/mordor.png")));

            maps.put("Rhovanion", ImageIO.read(new File("Assets/rhovanion/rhonvanion.png")));
            maps.put("Fangorn", ImageIO.read(new File("Assets/rhovanion/fangorn/fangorn.png")));
            maps.put("Foret Noiresud", ImageIO.read(new File("Assets/rhovanion/Foret noiresud/foretnoiresud.png")));
            maps.put("Grand fleuve", ImageIO.read(new File("Assets/rhovanion/grandfleuve/grabdfleuve.png")));
            maps.put("Lothlorien", ImageIO.read(new File("Assets/rhovanion/Lothlorien/lothlorien.png")));
            maps.put("Moria", ImageIO.read(new File("Assets/rhovanion/moria/moria.png")));
            maps.put("Rohan Est", ImageIO.read(new File("Assets/rhovanion/Rhoan est/rohanest.png")));
            maps.put("Rohan Ouest", ImageIO.read(new File("Assets/rhovanion/Rohan ouest/rohan ouest.png")));*/
        }
        catch (IOException e){
            System.err.println(e.toString());
        }

        try{

            InputStream ips = new FileInputStream("Assets/lotrods.csv");
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);

            String line = br.readLine();
            while((line = br.readLine()) != null)
                datas.add(new Datas(line));

            br.close();
        }
        catch (IOException e){
            System.err.println(e.toString());
        }
    }
}
