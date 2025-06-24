import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Oyun extends JPanel implements KeyListener, ActionListener {
    private int hedefX = 0;
    private int hedefdirX = 2;
    private int karakterX = 0;
    private final int dirKarakterX = 20;
    private ArrayList<Ates> atesler = new ArrayList<Ates>();
    private final int atesdirY = 8;
    Hedef easyLevel = new Hedef(5);
    Hedef mediumLevel = new Hedef(10);
    Hedef hardLevel = new Hedef(20);
    Timer timer = new  Timer(5,this);
    int sayac = 0;
    double sonuc;
    private Hedef currentLevel;
    private int gecen_sure = 0;
    private int harcanan_ates = 0;
    private BufferedImage backgroundImage, backgroundImage2, backgroundImage3;
    private BufferedImage lazer1, lazer2, lazer3;
    private BufferedImage karakter1, karakter2, karakter3;
    private BufferedImage hedef1, hedef2, hedef3;

    public void seviyedegistir(Hedef newLevel) {
        currentLevel = newLevel;
        hedefdirX = currentLevel.getTopSpeed();
        karakterX = 0;
        atesler.clear();
    }

    public boolean kontrolEt(){

        for(Ates ates : atesler){
            if(new Rectangle(ates.getX(), ates.getY(), 9, 54).intersects(new Rectangle(hedefX, 0, 40, 40))){
                sayac++;
                return true;
            }
        }
        return false;
    }
    public Oyun(){

        try {
            backgroundImage = ImageIO.read(new File("bg.png"));
            karakter1 = ImageIO.read(new FileImageInputStream(new File("karakter1.png")));

        }catch(IOException ex){
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE,null,ex);
        }

        timer.start();
        seviyedegistir(easyLevel);

    }

    @Override
    public void paint(Graphics g) {
        try {
            karakter2 = ImageIO.read(new FileImageInputStream(new File("karakter2.png")));
            karakter3 = ImageIO.read(new FileImageInputStream(new File("karakter3.png")));
            hedef1 = ImageIO.read(new FileImageInputStream(new File("hedef1.png")));
            hedef2 = ImageIO.read(new FileImageInputStream(new File("hedef2.png")));
            hedef3 = ImageIO.read(new FileImageInputStream(new File("hedef3.png")));
            lazer1 = ImageIO.read(new FileImageInputStream(new File("laser1.png")));
            lazer2 = ImageIO.read(new FileImageInputStream(new File("laser2.png")));
            lazer3 = ImageIO.read(new FileImageInputStream(new File("laser3.png")));
            backgroundImage2 = ImageIO.read(new FileImageInputStream(new File("bg2.png")));
            backgroundImage3 = ImageIO.read(new FileImageInputStream(new File("bg3.png")));


        }catch(IOException ex){
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE,null,ex);
        }

        gecen_sure+=15;

        if(sayac == 0){
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(hedef1, hedefX,0, hedef1.getWidth()/2, hedef1.getHeight()/2, this);
            g.drawImage(karakter1, karakterX, 400, karakter1.getWidth()*2, karakter1.getHeight()*2, this);
        }

        if(sayac == 1){
            g.drawImage(backgroundImage2, 0, 0, backgroundImage2.getWidth()*2, backgroundImage2.getHeight()*2, this);
            g.drawImage(hedef2, hedefX, 0, hedef2.getWidth()/2, hedef2.getHeight()/2, this);
            g.drawImage(karakter2, karakterX,400, karakter2.getWidth()*2, karakter2.getHeight()*2, this);

        }

        if(sayac == 2){
            g.drawImage(backgroundImage3, 0, 0, backgroundImage3.getWidth()*2, backgroundImage3.getHeight()*2, this);
            g.drawImage(hedef3, hedefX, 0, hedef3.getWidth()/2, hedef3.getHeight()/2, this);
            g.drawImage(karakter3, karakterX, 400, karakter3.getWidth()*2, karakter3.getHeight()*2, this);
        }


        for(Ates ates : atesler){
            if(ates.getY()<0){
                atesler.remove(ates);
            }
        }

        for(Ates ates : atesler){
            if(sayac == 0){
                g.drawImage(lazer1,ates.getX()/1,ates.getY()/1,9,54,this);
            }
            if(sayac == 1){
                g.drawImage(lazer2,ates.getX()/1,ates.getY()/1,9,54,this);
            }
            if(sayac == 2){
                g.drawImage(lazer3,ates.getX()/1,ates.getY()/1,9,54,this);
            }
        }

        if(kontrolEt()){
            System.out.println("Sayac: " +sayac);
            if(sayac == 1) {
                timer.stop();
                seviyedegistir(mediumLevel);
                timer.start();
            }

            if(sayac == 2) {
                timer.stop();
                seviyedegistir(hardLevel);
                timer.start();
            }

            if(sayac == 3){
                timer.stop();
                sonuc = (harcanan_ates + gecen_sure / 1000);
                double mevcutSkor = sonuc;

                double enYuksekSkor = SkorYonetimi.enYuksekSkoruOku();

                if (mevcutSkor < enYuksekSkor) {
                    String message = "Kazandınız!\n" + "Harcanan ateş: " + harcanan_ates + "\nGeçen süre: " + gecen_sure / 1000.0 + "\nÖnceki en yüksek skor: " + enYuksekSkor + "\nTEBRİKLER! \nYeni en yüksek skor: " + mevcutSkor;
                    JOptionPane.showMessageDialog(this, message);

                    SkorYonetimi.enYuksekSkoruYaz(mevcutSkor);
                } else {
                    String message = "Kazandınız!\n" + "Harcanan ateş: " + harcanan_ates + "\nGeçen süre: " + gecen_sure / 1000.0 + "\nYapılan skor: " + mevcutSkor + "\nEn yüksek skor: " + enYuksekSkor;
                    JOptionPane.showMessageDialog(this, message);
                }
                System.exit(0);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c=e.getKeyCode();

        if (c == KeyEvent.VK_SPACE ) {
            atesler.add(new Ates(karakterX + 27, 390));
            harcanan_ates++;
        }

        if(c == KeyEvent.VK_LEFT ) {
            if (karakterX <= 0) {
                karakterX = 0;
            } else {
                karakterX-=dirKarakterX;

            }
        }
        else if(c == KeyEvent.VK_RIGHT){
            if(karakterX>=740){
                karakterX=740;
            }
            else{
                karakterX+=dirKarakterX;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(Ates ates : atesler){
            ates.setY(ates.getY()-atesdirY);
        }
        hedefX+=hedefdirX;

        if(hedefX>=700){
            hedefdirX=-hedefdirX;
        }
        if(hedefX<=0){
            hedefdirX=-hedefdirX;
        }
        repaint();
    }
}
