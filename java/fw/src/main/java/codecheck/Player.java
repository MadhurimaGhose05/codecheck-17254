/*
    Player class of Simple Word Chain Framework for Shiritori
    Create by Madhurima on 09/10/2017
    Description: player class of shiritori game
*/

package codecheck;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
import java.io.IOException;
import  java.util.ArrayList ;
import java.lang.StringBuffer;

abstract class Player {
	public  static  String word =  null ; // Receive, say word
    public  static  ArrayList < String > dict; // word dictionary
    public  static  String startWord =  null ;

    private static Socket socket;

    public static String getShiritoriWord(String inputWord){
        dict.remove(inputWord);

        String tail = inputWord.substring(inputWord.length()-1,inputWord.length());  

        for(String word : dict) {
            if(tail.equals(word.substring(0,1))){
                dict.remove(word);
                return word;
            }
        }

        return " ";
    }

    // Initialize the word dictionary
    abstract public void setDict(ArrayList<String> dict);

    // Specify the first word
    abstract public void setStartWord(String word);

    // Define word constraints
    abstract public void wordRestriction();

    // Delete if control character is included.
    private static void deleteControlCharsOfDict() {
        for (int i=0; i<dict.size(); i++) {
            dict.set(i, deleteControlChars(dict.get(i)));
        }
    }

    // Delete if control character is included.
    private static String deleteControlChars(String s){
        // Control Codes 0 <= 001f and 007f
        StringBuffer buf = new StringBuffer();
        for(char ch : s.toCharArray()){
            if(ch > 0x1f && !(ch >= 0x7f && ch <= 0x9f)){
                buf.append(ch);
            }
        }
        return buf.toString();
    }


    // Set the address and port number of the referee server
    public static void configRefereeInfo(String refereeIP, int refereePort) {
        try {
            if(refereeIP==null) {
                socket =  new  Socket ( " 127.0.0.1 " , 9995 );
            } else {
                socket =  new  Socket (refereeIP, refereePort);
            }
        } catch (ConnectException e) {
            // e.printStackTrace();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } 
    }

    public static void joinGame() {
        
        // Delete if control character is included.
        deleteControlCharsOfDict();

        new WordSender(socket).start();
        new WordReceiver(socket).start();
    }
}
