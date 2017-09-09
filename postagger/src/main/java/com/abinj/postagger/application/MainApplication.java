package com.abinj.postagger.application;

import com.abinj.commons.utils.OpenNLPUtils;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

import java.io.File;
import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        POSModel loader = new POSModelLoader().load(new File("/home/abin/my_space/java_backend/nlp/opennlp/models/en-pos-maxent.bin"));
        POSTaggerME tagger = new POSTaggerME(loader);
        String input = "Welcome everyone lets together dive into Data science.";

        String[] sentences = OpenNLPUtils.getSentences(input);
        if (sentences!= null && sentences.length > 0) {
            for (String sentence : sentences) {
                String whiteSpaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(sentence);
                String[] tags = tagger.tag(whiteSpaceTokenizerLine);
                POSSample posSample = new POSSample(whiteSpaceTokenizerLine, tags);
                System.out.println("POS Sample: " + posSample.toString());
                for (int i = 0; i < whiteSpaceTokenizerLine.length; i++) {
                    String word = whiteSpaceTokenizerLine[i].trim();
                    String tag = tags[i];
                    System.out.println(word + ":" + tag);
                }
            }
        }
    }
}
