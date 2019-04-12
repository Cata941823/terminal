package com.grupa251.cata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Terminal {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("C:\\Users\\Cata\\Desktop");
        File[] fisiere = folder.listFiles();
        Scanner comanda = new Scanner(System.in);
        String s = comanda.next();
        do
        {
            if(s.toLowerCase().equals("ls"))
            {
                for(int i = 0; i<fisiere.length; i++)
                {
                    if(fisiere[i].isFile())
                        System.out.println("- " + fisiere[i].getName() );
                    else
                        System.out.println("d " + fisiere[i].getName());
                }
            }
            else if(s.toLowerCase().equals("cp"))
            {
                Path src = Paths.get(comanda.next());
                Path dest = Paths.get(comanda.next(), src.getFileName().toString());
                try {
                    Files.copy(src, dest, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
            else if(!s.toLowerCase().equals("cp") || !s.toLowerCase().equals("ls") || s.equals("-1")) System.out.println("Unknown command...");
            else break;
            s = comanda.next();
        }while(!s.equals("-1"));
    }
}
