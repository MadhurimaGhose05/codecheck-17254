/*
    AI class of Simple Word Chain Framework
    Create by Madhurima on 09/10/2017
    Description: From shiritori game player class
    Inherited AI class
*/

package codecheck;

import  java.util.Arrays ;
import  java.util.stream. * ;
import  java.util.ArrayList ;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import  java.util.Scanner ;

public class AI extends Player {

    @Override
    public void setDict(ArrayList<String> dict) {
        setStartWord(dict.get(0));
        dict.remove(dict.get(0));
        Player.dict = dict;
    }

    @Override
    public void setStartWord(String word) {
        Player . startWord = word;
    }

    @Override
    public void wordRestriction() {
        // // The maximum number of words in the input word is 1000 words.
        if(Player.dict.size()>1001) {
            System.out.println("The max word dictionary size is 1000!");
            System.out.println("Your dictionary size: " + Player.dict.size());
            System.exit(0);
        }
        for(String word : Player.dict) {
            if(word.length()>10000) {
                System.out.println("The length of each word should be less than 10000!");
                System.out.println("Your word size: " + word.length() + ", word: " + word);
                System.exit(0);
            }
        }
    }

    public void setDictFromFile() {
        FileReader files = null;
        try {
            files = new FileReader("dict.txt");
            Scanner input = new Scanner(files);
            String line = input.nextLine();
            String[] words = line.split(" ");
            Player.dict = new ArrayList<String>(Arrays.asList(words));
            
            setStartWord(Player.dict.get(0));

            Player.dict.remove(Player.dict.get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void options(String[] args) {
           for (int i = 0; i < args.length; i++) {
                switch (args[i].charAt(0)) {
                case '-':
                    if(args[i].charAt(1)=='f') {
                        setDictFromFile();
                    }
                    break;
                default:
                    setDict(new ArrayList<String>(Arrays.asList(args)));
                    break;
                }
        }
    }

    public static void main(String[] args) {
        if(args.length<0) {
            System.out.println("Please insert word dictionary!");
            System.exit(1);
        }
        
        AI V =  new  AI ();
        
        // options changes word dictionary setting
        ai.options(args);
        
        // Specify restrictions such as size of word group, length of one word
        ai . wordRestriction ();

        // specify the referee program to connect
        configRefereeInfo("127.0.0.1", 9995);

        // Join the game
        joinGame();
    }
}
