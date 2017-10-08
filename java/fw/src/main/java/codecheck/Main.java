/*
    Player class of Simple Word Chain Framework for Shiritori
    Create by Madhurima on 09/10/2017
    Description: player class of shiritori game
*/


package codecheck;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
        if(args.length<0) {
            System.out.println("Please insert word dictionary!");
            System.exit(1);
        }
        int portNum = 9995;
		ArrayList<String> dict = new ArrayList<String>(Arrays.asList(args));

		Shiritori shiritori = new Shiritori(dict, portNum);

	}
}
