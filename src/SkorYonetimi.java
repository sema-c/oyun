import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SkorYonetimi {
    private static final String SKOR_DOSYA_YOLU = "sonuclar.txt";

    public static double enYuksekSkoruOku() {
        try (BufferedReader okuyucu = new BufferedReader(new FileReader(SKOR_DOSYA_YOLU))) {
            String satir = okuyucu.readLine();
            if (satir != null && !satir.isEmpty()) {
                return Double.parseDouble(satir);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return  0.0;
    }

    public static void enYuksekSkoruYaz(double skor) {
        try (BufferedWriter yazici = new BufferedWriter(new FileWriter(SKOR_DOSYA_YOLU))) {
            yazici.write(String.valueOf(skor));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
