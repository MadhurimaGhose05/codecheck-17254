/*
    Player class of Simple Word Chain Framework for Shiritori
    Create by Madhurima on 09/10/2017
    Description: player class of shiritori game
*/
package codecheck;
import java.io.IOException;
import  java.util.ArrayList ;
import java.lang.StringBuffer;

public class Shiritori {
	private Referee referee;
	public static ArrayList<String> dict = new ArrayList<String>();

	public Shiritori(ArrayList<String> dict, int portNum) throws IOException {
		// Exclude the first word
        dict.remove(dict.get(0));
		Shiritori . Dict = Dict;
		
		// Inspect word limit
		wordRestriction();

		// Delete if control character is included.
		deleteControlCharsOfDict();

		// Start the referee program
		createReferee(portNum);

		// Player's Participation Monday
		waitPlayer();
	}

    private void wordRestriction() {
        // // The maximum number of words in the input word is 1000 words.
        if(Shiritori.dict.size()>1001) {
            System.out.println("The max word dictionary size is 1000!");
            System.out.println("Your dictionary size: " + Shiritori.dict.size());
            System.exit(0);
        }
        for(String word : Shiritori.dict) {
            if(word.length()>10000) {
                System.out.println("The length of each word should be less than 10000!");
                System.out.println("Your word size: " + word.length() + ", word: " + word);
                System.exit(0);
            }
        }
    }

	private void waitPlayer() throws IOException {
		referee.waitPlayer();
	}

	// Generate referee
	private void  createReferee(int portNum) {
		referee = new Referee(portNum);
	}

	private static void deleteControlCharsOfDict() {
		for (int i=0; i<dict.size(); i++) {
			Shiritori . Dict . Set (I, DeleteControlChars ( Shiritori . Dict . Get (I)));
		}
	}

	// Delete if control character is included.
	private static String deleteControlChars(String s) {
	// Control Codes not in (0<= s <= 001f) and (007f <= s <=009f)
		StringBuffer buf = new StringBuffer();
		for(char ch : s.toCharArray()){
			if(ch > 0x1f && !(ch >= 0x7f && ch <= 0x9f)){
				buf.append(ch);
			}
		}
		return buf.toString();
	}
}
