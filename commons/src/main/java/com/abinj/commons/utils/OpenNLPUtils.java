package com.abinj.commons.utils;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OpenNLPUtils {

    public static String[] getTokens(String sentence) throws IOException {
        //Give proper path to the "en-token.bin" file
        InputStream is = new FileInputStream("en-token.bin");
        TokenizerModel model = new TokenizerModel(is);
        Tokenizer tokenizer = new TokenizerME(model);
        String[] tokens = tokenizer.tokenize(sentence);
        is.close();
        return tokens;
    }
}
