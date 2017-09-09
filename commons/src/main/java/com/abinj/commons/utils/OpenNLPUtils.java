package com.abinj.commons.utils;

import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OpenNLPUtils {

    public static String[] getTokens(String sentence) throws IOException {
        //Give proper path to the "en-token.bin" file
        String[] tokens = new String[0];
        try {
            InputStream is = new FileInputStream("en-token.bin");
            TokenizerModel model = new TokenizerModel(is);
            Tokenizer tokenizer = new TokenizerME(model);
            tokens = tokenizer.tokenize(sentence);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tokens;
    }

    public static String[] getSentences(String paragraph) throws IOException {
        //Give proper path to the "en-sent.bin" file
        String[] sentences = new String[0];
        try {
            InputStream is = new FileInputStream("/home/abin/my_space/java_backend/nlp/opennlp/my_works/opennlpexamples/sentencesplitter/src/main/resources/assets/en-sent.bin");
            SentenceModel model = new SentenceModel(is);
            SentenceDetectorME sDetector = new SentenceDetectorME(model);
            sentences = sDetector.sentDetect(paragraph);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sentences;
    }

    public static String[] getPOSTags(String sentence) {
        String[] tags = new String[0];
        POSModel model = new POSModelLoader().load(new File("/home/abin/my_space/java_backend/nlp/opennlp/models/en-pos-maxent.bin"));
        POSTaggerME tagger = new POSTaggerME(model);
        String whiteSpaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(sentence);
        tags = tagger.tag(whiteSpaceTokenizerLine);
        return tags;
    }
}
