package loader.halqloader.hwid;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Halq
 * @since 21/02/2022
 */

public class HwidVerificator {

    static String urlS = "your pastebin";
    static List<String> arrayHwid = new ArrayList<>();
    static String hwid;
    static String sys = System.getenv("PROCESSOR_LEVEL") + System.getProperty("user.name") + System.getProperty("os.version") + System.getProperty("java.version");
    static String pHwid = "HalqLoader-" + sys;

    public static void verify() {
        try {
            URL url = new URL(urlS);

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            System.out.println(pHwid);

            hwid = reader.readLine();

            arrayHwid.add(hwid);

            if (!arrayHwid.contains(pHwid)) {
                FileWriter fl = new FileWriter("C:/Users/" + System.getProperty("user.name") + "/Desktop/HWID.txt");

                fl.write("You Hwid : " + pHwid);
                fl.close();

                System.out.println("NO HWID");

                try{
                    TimeUnit.SECONDS.sleep(5);

                    causeStackOverflow();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void causeStackOverflow() {
        causeStackOverflow();
    }
}
