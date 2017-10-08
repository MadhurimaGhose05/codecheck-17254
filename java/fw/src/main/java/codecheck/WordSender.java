/*
    Player class of Simple Word Chain Framework for Shiritori
    Create by Madhurima on 09/10/2017
   Explanation: A word from the opponent player
    Originally extracted shiritori words,
    Send to referee
*/
package codecheck;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

class WordSender extends Thread {

    private final Socket socket;

    public WordSender(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Player.word = Player.getShiritoriWord(Player.startWord);
            while(true){
                synchronized(this) {
                    OutputStream os = socket.getOutputStream();
                    if(Player.word != null) {
                        os.write(Player.word.getBytes());
                        Player.word = null;
                    }
                }
            }
        } catch (NullPointerException e) {
            // Run locally if connection does not exist
            if(Player.word == null) {
                try {
                    throw new IllegalArgumentException("There is no startword specified!");
                } catch(IllegalArgumentException ex) {
                    System.out.println("Caught an IllegalArgumentException..." + ex.getMessage());
                    System.exit(1);
                }
            } else {
                System.out.println(Player.word);
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.exit(1);
        }
    }

}
