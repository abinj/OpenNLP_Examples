package com.abinj.commons.utils;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
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

    public static String[] getSentences(String paragraph) throws IOException {
        //Give proper path to the "en-sent.bin" file
        InputStream is = new FileInputStream("/home/abin/my_space/java_backend/nlp/opennlp/my_works/opennlpexamples/sentencesplitter/src/main/resources/assets/en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sDetector = new SentenceDetectorME(model);
        String[] sentences = sDetector.sentDetect(paragraph);
        is.close();
        return sentences;
    }
}
