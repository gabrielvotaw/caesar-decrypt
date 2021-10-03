/*
 * Decrypts all possible plaintext of a Caesar cipher
 * 
 * @author Gabriel Votaw
 * @version FINAL 2021-10-03
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

#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int main() {
    string usage = "decrypt <ciphertext>\n";
           usage += "ciphertext restricted to aplhabetic characters\n";

    int key;
    char input[100];
    char* ptr;
    string ctext;
    string message;
    vector<string> tokens;

    cin.getline(input, 100);
    ptr = strtok(input, " ");

    while (ptr != NULL) {
        tokens.push_back(ptr);
        ptr = strtok(NULL, " ");
    }

    if (tokens.size() != 2 || tokens[0] != "decrypt") {
        cout << usage << endl;
        exit(0);
    }

    ctext = tokens[1];

    cout << "All possible plaintext: " << endl;

    for (int i = 1; i < 26; i++) {
        message = ctext;
        key = i;

        for (auto& c : message) {
            c = tolower(c);
            c = (char) c - i;

            if (c < 'a') {
                c = (char) c + 'z' - 'a' + 1;
            }
        }

        cout << message << " Key: " << key << endl;
    }
}