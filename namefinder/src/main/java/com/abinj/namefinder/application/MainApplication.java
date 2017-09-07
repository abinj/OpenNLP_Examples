package com.abinj.namefinder.application;

import com.abinj.commons.utils.OpenNLPUtils;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        //Give proper path to the "en-ner-person.bin" file
        InputStream is = new FileInputStream("en-ner-person.bin");
        TokenNameFinderModel nameFinderModel = new TokenNameFinderModel(is);
        NameFinderME nameFinderME = new NameFinderME(nameFinderModel);

        //Need to tokenize the input text first.
        Span nameSpans[] = nameFinderME.find(OpenNLPUtils.getTokens("Geoffrey Hinton is a great data scientist." +
                "He is the brain (co-inventor) behind this algorithm for training neural nets and deep learning simulations."));
        for (Span span : nameSpans) {
            System.out.println(span.toString());
        }
    }

}
