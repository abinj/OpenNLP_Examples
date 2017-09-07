package com.abinj.tokenizer.application;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainApplication {

    public static void main(String[] args) throws InvalidFormatException, IOException {
        InputStream is = new FileInputStream("en-token.bin");
        TokenizerModel model = new TokenizerModel(is);
        Tokenizer tokenizer = new TokenizerME(model);
        String[] tokens = tokenizer.tokenize("Hello Everyone, Lets code for fun. Enjoy each and every moment.");
        for (String token : tokens) {
            System.out.println(token);
        }
        is.close();
    }
}
