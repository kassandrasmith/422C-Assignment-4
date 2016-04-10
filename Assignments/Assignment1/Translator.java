/*
Solves EE422C programming assignment #1
@author Kassandra Smith
KSS 2474
*/

package Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Translator {

   public static void main(String args[]) {
      if (args.length != 1) {
         System.err.println("Error: Incorrect number of command line arguments");
         System.exit(-1);
      }
      processLinesInFile(args[0]);

   }

   /******************************************************************************
    * Method Name: processLinesInFile * Purpose: Opens the file specified in
    * String filename, reads each line in it * Invokes translate () on each line
    * in the file, and prints out the * translated piglatin string. * Returns:
    * None *
    ******************************************************************************/
   public static void processLinesInFile(String filename) {

      Translator translator = new Translator();
      try {
         FileReader freader = new FileReader(filename);
         BufferedReader reader = new BufferedReader(freader);

         for (String s = reader.readLine(); s != null; s = reader.readLine()) {
            String pigLatin = translator.translate(s);
            System.out.println(pigLatin);
         }
      } catch (FileNotFoundException e) {
         System.err.println("Error: File not found. Exiting...");
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         System.err.println("Error: IO exception. Exiting...");
         e.printStackTrace();
         System.exit(-1);
      }
   }

   /******************************************************************************
    * Method Name: translate * Purpose: Converts String inputString into
    * piglatin based on rules specified * in your assignment write-up. *
    * Returns: String object containing the piglatin translation of * String
    * inputString *
    ******************************************************************************/
   public String translate(String inputString) {
      // modify the following code. Add/delete anything after this point.
      /* Check for the case where line consists purely of newline */
      if (inputString.length() < 1) {
         return inputString;
      }
      String returnString = new String(""); // holder for translation
      String[] words = inputString.split(" "); // array of strings broken up by
                                               // spaces
      String[] translatedWords = new String[words.length]; // array for
                                                           // translated strings
      int wordIndex = 0; // index for the return words array
      int numOfWords = words.length; // the number of words we need to go
                                     // through

      /*
       * if there is only one word, there is no reason to loop. Simply translate
       * and return
       */
      if (numOfWords == 1) {
         returnString = "original: \n" + returnString + inputString + "\n" + "translated: \n";
         if (!words[wordIndex].matches(ALPHA_CHARS)) {
            return returnString + dealWithSymbol(words[wordIndex]);
         }
         if (isVowel(words[0].charAt(0))) {
            return returnString + translateVowelWord(words[0], 1);
         } else if (isConsonant(words[0].charAt(0))) {
            return returnString + translateConsonantWord(words[0], 1);
         }
      }

      /* run through the new array of strings */
      for (String word : words) {
         /* check right away for empty words */
         if (word.length() < 1) {
            translatedWords[wordIndex] = " ";
            wordIndex++;
            continue;
         }
         String end = new String(" ");// holds the space at the end of each word
         int endIndex = word.length();
         boolean valid = word.matches(ALPHA_CHARS); // a "valid" word is one
                                                    // with only English
                                                    // alphabetical characters
         if (!valid) {
            translatedWords[wordIndex] = dealWithSymbol(word);
         } else {
            translatedWords[wordIndex] = translateSingleWord(word, 0, endIndex) + end;
         }
         wordIndex++;
      }
      // Assignment Requirements.B states
      // "for each input phrase you are to output the original phrase
      // and the resultant Pig Latin equivalent phrase, with appropriate
      // identifying labels on each"
      returnString = "original: \n" + returnString + inputString + "\n" + "translated: \n";
      for (String translated : translatedWords) {
         returnString = returnString + translated;
      }
      returnString = returnString.substring(0, returnString.length() - 1); // trim
                                                                           // off
                                                                           // trailing
                                                                           // space
      return returnString;
   }

   // Assignment Requirements part C states
   // "You may add anything you need to the given code, but do not delete
   // anything from it."
   /******************************************************************************
   Method Name: isVowel * Purpose: checks if a letter is a vowel 
   returns true if the character input is a vowel, false otherwise
@param letter to be checked
    ******************************************************************************/
   public boolean isVowel(char inputLetter) {
      return "AEIOUaeiou".indexOf(inputLetter) != -1; // could be simplified
                                                      // with regex, unnecessary
                                                      // though
   }

   /******************************************************************************
    Method Name: isConsonant * Purpose: checks if a letter is a consonant
    Returns: true if the character input is a vowel, false otherwise
    @param letter to be checked
    ******************************************************************************/
   public boolean isConsonant(char inputLetter) {
      return "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz".indexOf(inputLetter) != -1;
   }

   /******************************************************************************
    * Method Name: translateSingleWord * Purpose: Chooses how to translate a
    * given word Returns: a String containing the translated word
    * @param Word to be translated
    * @param Integer that indicates the starting point of the word
    * @param Integer that indicates the ending point of the word
    ******************************************************************************/
   public String translateSingleWord(String input, int startIndex, int endIndex) {
      String translatedWord = "";
      /*
       * Check if the word starts with a vowel or consonant and translate
       * appropriately
       */
      if (isVowel(input.charAt(startIndex))) {
         translatedWord = translateVowelWord(input.substring(startIndex), endIndex);
      } else if (isConsonant(input.charAt(startIndex))) {
         translatedWord = translateConsonantWord(input.substring(startIndex), endIndex);
      }
      return translatedWord;
   }

   /******************************************************************************
    * Method Name: translateVowelWord * Purpose: translates a word that starts
    * with a vowel Returns: a String containing the translated word
    * @param Word beginning with a vowel to be translated
    * @param Integer that indicates the ending point of the word
    ******************************************************************************/
   public String translateVowelWord(String input, int endIndex) {
      return input.substring(0, endIndex) + "yay"; // add ending for vowels
   }

   /******************************************************************************
    * Method Name: translateVowelWord * Purpose: translates a word that starts
    * with (a) consonant(s) Returns: a String containing the translated word
    * @param Word beginning with a consonant to be translated
    * @param Integer that indicates the ending point of the word
    ******************************************************************************/
   public String translateConsonantWord(String input, int endIndex) {
      String beginning = new String("");
      int letterIndex = 0;

      if (input.length() == 1) {
         return input + "ay";
      }

      while (isConsonant(input.charAt(letterIndex))) {
         /*
          * save the consonants while removing them from the beginning of the
          * word
          */
         beginning = beginning + input.charAt(letterIndex);
         if (letterIndex < input.length() + 1) {
            letterIndex++;
         }
      }
      /* take the rest of the word, add the consonants, and add the ending */
      return input.substring(letterIndex, endIndex) + beginning + "ay";
   }

   /******************************************************************************
    * Method Name: translateVowelWord * Purpose: translates a word that starts
    * with a vowel Returns: a String containing the translated word
    * @param Word containing symbol to be translated
    ******************************************************************************/
   public String dealWithSymbol(String input) {
      int letterIndex = 0;
      int endIndex = input.length() - 1;
      boolean includesPunct = false;
      includesPunct = input.contains(".") || input.contains("\'") || input.contains("\"") || input.contains("?")
            || input.contains("-") || input.contains(",") || input.contains("(") || input.contains(")")
            || input.contains(";") || input.contains(":") || input.contains("!");
      /*
       * If there is a symbol that is not punctuation anywhere in a word, simply
       * print it without changing
       */
      if (!includesPunct) {
         return input + " ";
      }
      /* If the symbol is a hyphen it needs to be dealt with specially */
      if (input.contains("-")) {
         return dealWithHyphen(input);
      }
      /*
       * If the word is surrounded by punctuation it needs to be dealt with
       * specially
       */
      if (includesPunct) {
         return dealWithPunctuation(input);
      } else {
         return translateSingleWord(input.substring(letterIndex), 0, endIndex);
      }

   }

   /******************************************************************************
    * Method Name: dealWithPunctuation * Purpose: Translates words containing
    * punctuation Returns: String object containing the piglatin translation of
    * one word (Input)
    * @param Word containing punctuation to be translated
    ******************************************************************************/
   public String dealWithPunctuation(String input) {
      String beginning = ("");
      String end = (" ");
      String translatedWord = ("");
      int letterIndex = 0;
      int endIndex = input.length() - 1;
      boolean firstValid = Character.isLetter(input.charAt(0));
      boolean lastValid = Character.isLetter(input.charAt(input.length() - 1));

      if (!firstValid) {
         /* If the word begins with punctuation we store it */
         while (!firstValid) {
            beginning = beginning + input.charAt(letterIndex);
            if (letterIndex < input.length() - 1) {
               letterIndex++;
            }
            firstValid = Character.isLetter(input.charAt(letterIndex));
         }
         /*
          * and then we check to see if it ends with punctuation. if it does we
          * deal with that, but if not we translate the word and add the
          * punctuation back to it
          */
         if (lastValid) {
            translatedWord = translateSingleWord(input.substring(letterIndex), 0, endIndex);
            return beginning + translatedWord;
         }
      }
      /*
       * we repeat the process for ending punctuation, adding it all back
       * together at the end
       */
      if (!lastValid) {
         while (!lastValid) {
            end = input.charAt(endIndex) + end;
            endIndex--;
            lastValid = Character.isLetter(input.charAt(endIndex));
         }
         translatedWord = translateSingleWord(input.substring(letterIndex, endIndex + 1), 0,
               (endIndex + 1) - letterIndex);
         return beginning + translatedWord + end;
      } else {
         translatedWord = translateSingleWord(input.substring(letterIndex), 0, endIndex);
         return beginning + translatedWord + end;
      }
   }

   /******************************************************************************
    * Method Name: translate hyphen * Purpose: Translates hyphenated words
    * Returns: String object containing the piglatin translation of one word
     * @param Word containing hyphen to be translated
    ******************************************************************************/
   public String dealWithHyphen(String input) {
      String[] hyphenWords = new String[2];
      /* If there's a hyphen we split the words around the hyphen */
      hyphenWords = input.split("-");
      final String wordOne = hyphenWords[0];
      final String wordTwo = hyphenWords[1];
      String translatedWordOne = ("");
      String translatedWordTwo = ("");

      boolean validWordOne = wordOne.matches(ALPHA_CHARS);
      boolean validWordTwo = wordTwo.matches(ALPHA_CHARS);
      /* checks validity of specific letter */
      if (!validWordOne) {
         translatedWordOne = dealWithSymbol(wordOne);
      } else if (validWordOne) {
         translatedWordOne = translateSingleWord(wordOne, 0, wordOne.length());
      }
      if (!validWordTwo) {
         translatedWordTwo = dealWithSymbol(wordTwo);
      } else if (validWordTwo) {
         translatedWordTwo = translateSingleWord(wordTwo, 0, wordTwo.length());
      }
      String translatedWord = translatedWordOne + "-" + translatedWordTwo;
      return translatedWord;
   }

   /*
    * this obviously had ought to be at the top of the class, but was placed
    * here so as not to break the "do not alter anything above this line" rule.
    */
   private static final String ALPHA_CHARS = "([a-zA-Z])+";// global regex
                                                           // expression
}
