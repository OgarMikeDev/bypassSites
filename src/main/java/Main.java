
import java.io.IOException;
import java.io.PrintWriter;


import java.util.List;
import java.util.concurrent.ForkJoinPool;

//run
public class Main {
    public static String url = "https://skillbox.ru/";
    public static PrintWriter writer;

    public static void main(String[] args) {
        UrlsContainer.setMainPageUrl(url);
        Node node = new ForkJoinPool()
                .invoke(new WebScraper(new Node(url)));
        try {
            writer = new PrintWriter("data/siteMap.txt");
            List<String> urlsList = node.getAllUrls();
            for(String urls : urlsList){
                writer.write(urls);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}