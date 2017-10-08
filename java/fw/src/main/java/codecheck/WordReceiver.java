/*
    Player class of Simple Word Chain Framework for Shiritori
    Create by Madhurima on 09/10/2017
    Explanation: The word that the opponent player said
    To receive from the referee
*/
package codecheck;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

class WordReceiver extends Thread {

    private final Socket socket;

    public WordReceiver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            byte[] b = new byte[1024];
            InputStream is;
            String word;

            while(true){
                synchronized(this) {
                    if(Player.word==null) {
                        is = socket.getInputStream();
                        word = new String(b, 0, is.read(b));
                        word = Player.getShiritoriWord(word);

                        Player.word = word;

                        this.notify();

                        if(word.equals(" ")) {
                            System.exit(0);
                        }
                    }
                }

            }
        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

}
