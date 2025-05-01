package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.example.MainMenu.fileName;

public class searchOptions {
    //create instance of an object with parameters that allow for a search function\
    BufferedReader br;


    {
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


//    Ledger ledger = new searchOptions();


}
