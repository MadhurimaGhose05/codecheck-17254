/*
	Main class of Simple Word chain Framework for Shiritori
	Create by Madhurima on 02/19/2017
    Description: shiritori game main class
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
