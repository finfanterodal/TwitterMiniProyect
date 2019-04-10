package apptwitter;

import java.util.List;
import javax.swing.JOptionPane;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author finfanterodal
 */
public class AppTwitter {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {

        Twitter twitter = TwitterFactory.getSingleton();//Objeto clase Twitter, instanciado con getSingleton que nos limita a un objeto. 
        String op = JOptionPane.showInputDialog(null, "1.Publicar tweet\n2.Línea temporal.\n3.Fliltrado.\n4.Salir");

        //
        switch (op) {
            case "1":
                String latestStatus = null;
                // The factory instance is re-useable and thread safe, para la publicación de un Twit.
                Status status = twitter.updateStatus(latestStatus);
                System.out.println("Tweet realizado correctamente [" + status.getText() + "].");
                break;
            case "2":
                // The factory instance is re-useable and thread safe.
                List<Status> statuses = twitter.getHomeTimeline();
                System.out.println("Mostrando la línea de tiempo:");
                for (Status tlstatus : statuses) {
                    System.out.println(tlstatus.getUser().getName() + ":"
                            + tlstatus.getText());
                }
                break;
            case "3":
                Query query = new Query(JOptionPane.showInputDialog(null, "Palabra clave."));
                QueryResult result = twitter.search(query);
                for (Status shstatus : result.getTweets()) {
                    System.out.println("@" + shstatus.getUser().getScreenName() + ":" + shstatus.getText());
                    break;
                }
            case "4":
                System.exit(0);

        }

    }
}
