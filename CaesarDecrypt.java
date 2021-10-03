/**
 * Decrypts all possible plaintext of a Caesar cipher
 * 
 * @author Gabriel Votaw
 * @since 2021-10-03
 * 
 * Copyright (c) 2021 Gabriel Votaw
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package caesardecrypt;

import java.io.IOException;
import java.util.Scanner;

public class CaesarDecrypt {
    public static void main(String[] args) throws IOException {
        String usage = "CaesarDecrypt <ciphertext>\n";
        usage += "Ciphertext restricted to aplhabetic characters\n";

        Scanner in = new Scanner(System.in);
        String[] tokens = in.nextLine().split(" ");
        
        if (tokens.length != 2 || !tokens[0].equals("CaesarDecrypt")) {
            System.out.println(usage);
            System.exit(1);
        }
        
        String message = tokens[1].toLowerCase();
        StringBuilder decryptedMessage;
        char ch;
        int key;

        System.out.println("All possible plaintext:");
        
        for (int i = 1; i < 26; i++) {
            decryptedMessage = new StringBuilder();
            
            key = i;
            
            for (int j = 0; j < message.length(); j++) {
                ch = message.charAt(j);
                ch = (char)(ch - i);
                
                if (ch < 'a') {
                    ch = (char)(ch + 'z' - 'a' + 1);
                }
                
                decryptedMessage.append(ch);
            }
            
            System.out.println(decryptedMessage + "\tKey: " + key);
        }
    }
}