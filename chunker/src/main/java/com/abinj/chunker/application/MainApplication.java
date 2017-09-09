package com.abinj.chunker.application;

import com.abinj.commons.utils.OpenNLPUtils;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.Span;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        POSModel model = new POSModelLoader().load(new File("/home/abin/my_space/java_backend/nlp/opennlp/models/en-pos-maxent.bin"));
        POSTaggerME tagger = new POSTaggerME(model);

        String input = "Welcome everyone lets together dive into Data science. I am super excited for being here.";
        String[] sentences = OpenNLPUtils.getSentences(input);

        InputStream is = new FileInputStream("/home/abin/my_space/java_backend/nlp/opennlp/my_works/opennlpexamples/chunker/src/main/resources/assets/en-chunker.bin");
        ChunkerModel cModel = new ChunkerModel(is);
        ChunkerME chunkerME = new ChunkerME(cModel);
        for (String sentence: sentences) {
            String whiteSpaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(sentence);
            String[] tags = tagger.tag(whiteSpaceTokenizerLine);
            String result[] = chunkerME.chunk(whiteSpaceTokenizerLine, tags);
            for (String s : result) {
                System.out.println(s);
            }
            Span[] spans = chunkerME.chunkAsSpans(whiteSpaceTokenizerLine, tags);
            for (Span span : spans) {
                System.out.println(span.toString());
            }
        }
        is.close();
    }
}
