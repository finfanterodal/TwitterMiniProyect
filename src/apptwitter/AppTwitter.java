/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     */
    public static void main(String[] args) throws TwitterException {

        Twitter twitter = TwitterFactory.getSingleton();//Objeto clase Twitter, instanciado con getSingleton que nos limita a un objeto. 
        String op = JOptionPane.showInputDialog(null, "1.Publicar tweet\n2.Línea temporal.\n3.Fliltrado.");

        //
        switch (op) {
            case "1":
                String latestStatus = null;
                // The factory instance is re-useable and thread safe, para la publicación de un Twit.
                Status status = twitter.updateStatus(latestStatus);
                System.out.println("Successfully updated the status to [" + status.getText() + "].");
                break;
            case "2":
                // The factory instance is re-useable and thread safe.
                List<Status> statuses = twitter.getHomeTimeline();
                System.out.println("Showing home timeline.");
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

        }

    }
}
