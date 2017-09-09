package com.abinj.parser.application;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainApplication {

    public static void main(String[] args) throws IOException{
        InputStream is = new FileInputStream("/home/abin/my_space/java_backend/nlp/opennlp/my_works/opennlpexamples/Parser/src/main/resources/assets/en-parser-chunking.bin");
        ParserModel model = new ParserModel(is);
        Parser parser = ParserFactory.create(model);
        String sentence = "We must be prepared to produce insights from data.";
        Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
        for (Parse p : topParses) {
            p.show();
        }
        is.close();
    }
}
