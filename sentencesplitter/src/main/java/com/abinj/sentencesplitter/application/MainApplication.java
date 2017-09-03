package com.abinj.sentencesplitter.application;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainApplication {

    public static void main(String[] args) throws InvalidFormatException, IOException {
        String paragraph = "Hi. How are you? This is Mike.";

        //Always start with a model, a model is learned from training data
        //Give proper path to the "en-sent.bin" file
        InputStream is = new FileInputStream("en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sDetector = new SentenceDetectorME(model);
        String[] sentences = sDetector.sentDetect(paragraph);

        for (String s : sentences) {
            System.out.println(s);
        }
        is.close();
    }
}
