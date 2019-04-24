package caesarcipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {
    
public static void main(String[] args) throws IOException {
      
FileReader txtFile = new FileReader("/Users/ben/Desktop/cipher.txt");
        
        BufferedReader reader = new BufferedReader(txtFile);
        
        String message = "";
        String line = reader.readLine();
        
        while (line != null)
        {
            message += line;
            line = reader.readLine();
        }
        

        int input = 0, key = 0;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n== Caesar Cipher Decryption Program ==\n");
        
        while (input != 3)
        {
        System.out.println("Enter '1' to decrypt.");

        input = scan.nextInt();

        if(input == 1)
        {
            for (int i = 0; i < 26; i++)
            {
            decrypt(message, i);
            }
        }
        }
    }

    public static void decrypt(String y, int x)
    {  
        String decrypt = "";
        char ch;
        
        for (int i = 0; i < y.length(); i++)
        {
            ch = y.charAt(i);
            
            if (ch >= 'a' && ch <= 'z')
            {
                ch = (char)(ch - x);
                if(ch < 'a')
                {
                    ch = (char)(ch + 'z' - 'a' + 1);
                }
                decrypt += ch;
            }
            
            else if (ch >= 'A' && ch <= 'Z')
            {
                ch = (char)(ch - x);
                if(ch < 'A')
                {
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }
                decrypt += ch;
            }
            
            else
                decrypt += ch;
        }

        System.out.println("---------------------------------------------------");
        System.out.println("\nDecrypting... \n");
        System.out.print("Key: " + x + "\n");
        System.out.println("Message: " + decrypt);
    }  
}
