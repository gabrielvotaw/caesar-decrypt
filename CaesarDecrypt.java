package caesardecrypt;

import java.io.IOException;
import java.util.Scanner;

/**
 * Decrypts all possible plaintext of a Caesar cipher
 * @author Gabriel Votaw
 * @since 2021-09-28
 */
public class CaesarDecrypt
{
    public static void main(String[] args) throws IOException
    {
        String usage = "CaesarDecrypt <ciphertext>\n";
        usage += "Ciphertext restricted to aplhabetic characters";

        Scanner in = new Scanner(System.in);
        String[] tokens = in.nextLine().split(" ");
        if (tokens.length != 2 || !tokens[0].equals("CaesarDecrypt"))
        {
            System.out.println(usage);
            throw new IOException("Invalid arguments");
        }
        
        String message = tokens[1].toLowerCase();
        StringBuilder decryptedMessage;
        char ch;
        int key;

        System.out.println("All possible plaintext:");
        for (int j = 1; j < 26; j++)
        {
            decryptedMessage = new StringBuilder();
            key = j;
            
            for (int i = 0; i < message.length(); i++)
            {
                ch = message.charAt(i);
                ch = (char)(ch - j);
                
                if (ch < 'a')
                {
                    ch = (char)(ch + 'z' - 'a' + 1);
                }
                decryptedMessage.append(ch);
            }
            System.out.println(decryptedMessage + "\tKey: " + key);
        }
    }
}