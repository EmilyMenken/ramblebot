import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A tokenizer that converts text input to lowercase and splits it 
 * into a list of tokens, where each token is either a word or a period.
 */
public class LowercaseSentenceTokenizer implements Tokenizer {
  /**
   * Tokenizes the text from the given Scanner. The method should 
   * convert the text to lowercase and split it into words and periods.
   * Words are separated by spaces, and periods are treated as separate tokens.
   * 
   * For example:
   * If the input text is: "Hello world. This is an example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "an", "example", "."]
   * 
   * Notice that the text is converted to lowercase, and each period is treated as a separate token.
   * 
   * However, a period should only be considered a separate token if it occurs at the end
   * of a word. For example:
   * 
   * If the input text is: "Hello world. This is Dr.Smith's example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "dr.smith's", "example", "."]
   * 
   * The internal period in Dr.Smith's is not treated as its own token because it does not occur at the end of the word.
   * 
   * @param scanner the Scanner to read the input text from
   * @return a list of tokens, where each token is a word or a period
   */

   @Override //forgot to add an override before oopsie
   public List<String> tokenize(Scanner scanner) {

  List<String> tokens = new ArrayList<>(); //makes an arrayList for the tokens to be placed into
    while(scanner.hasNext()){
      String rambleWord = scanner.next().toLowerCase();
      int length = getLength(rambleWord);

        if (length > 0 && rambleWord.charAt(length-1) == '.' && length > 1){
          tokens.add(rambleWord.substring(0,length-1)); //adds word, removes end period
          tokens.add("."); //readds period as a different token
          }
          else {
            tokens.add(rambleWord);
          }
        }
        return tokens;
      }

public int getLength(String string){
  return string.length();
  }

} //end LowerCaseTokenizer.java

