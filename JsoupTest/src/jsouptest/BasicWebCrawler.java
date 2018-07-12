dpackage JsoupTest;

import java.awt.AWTException;
import java.io.BufferedReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class BasicWebCrawler {
    private HashSet<String> links;
    static final String AB = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    
    public BasicWebCrawler() {
        links = new HashSet<>();
    }
    public void getPageLinks(String URL) {
        //4. Check if you have already crawled the URLs
        //(we are intentionally not checking for duplicate content in this example)
        if (!links.contains(URL)) {
            try {
                //4. (i) If not add it to the index
                if (links.add(URL)) {
                    System.out.println(URL);
                }

                //2. Fetch the HTML code
                Document document = Jsoup.connect(URL).get();
                //3. Parse the HTML to extract links to other URLs
                Elements linksOnPage = document.select("a[href]");

                //5. For each extracted URL... go back to Step 4.
                linksOnPage.forEach((page) -> {
                    getPageLinks(page.attr("abs:href"));
                });
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }
    public static boolean exists(String URL){
    try {
      HttpURLConnection.setFollowRedirects(false);
      // note : you may also need
      //        HttpURLConnection.setInstanceFollowRedirects(false)
      HttpURLConnection con =
         (HttpURLConnection) new URL(URL).openConnection();
      con.setRequestMethod("HEAD");
      return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
    }
    
    catch (Exception e) {
       return false;
    }
  }
    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
    public static void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        Files.write(path, aLines, StandardCharsets.UTF_8);
    }
}

class main{

    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        //1. Pick a URL from the frontier
        BasicWebCrawler bot = new BasicWebCrawler();
        String protocol = "https://";
        String target = bot.randomString(16);
        String domain = ".onion";
        String address = protocol + target + domain;
        List<String> lines = Arrays.asList(new String[] { address });
                
        // ping the target, if reply; is true;
        while(true){
            Runtime rt = Runtime.getRuntime();
        if(bot.exists(address) == true){
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec("ping" + address);
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                String line=null;
                while((line=input.readLine()) != null) {
                    System.out.println(line);
                }
                int exitVal = pr.waitFor();
                System.out.println("Exited with error code "+exitVal);
            System.out.println("Writing " + address + " to file.");
            //FILE WRITE PROCESS//
            String filepath = "C:/bwc_index/realURLS.txt";
            bot.writeSmallTextFile(lines, filepath);
        }
        else if (bot.exists(address) == false){
            System.out.println( address + " is not a valid URL.");
            target = bot.randomString(16);
            address = protocol + target + domain;
            System.out.println("Trying " + address);
            String filepath = "C:/bwc_index/fake.txt";
            bot.writeSmallTextFile(lines, filepath);
            }
        
        }
        /**
         * generate
         * check if it's real
         * if not make another
         * 
         */
        
        
    }

}
