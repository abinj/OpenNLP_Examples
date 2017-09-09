# OpenNLP_Examples

* The Apache OpenNLP library is a machine learning based toolkit for processing of natural language text. It includes a sentence detector, a tokenizer, a name finder, a parts-of-speech (POS) tagger, a chunker, and a parser.

  In this Repository, I will show you how to use Apache OpenNLP through a set of simple examples.

1. Sentence Detector
2. Tokenizer
3. Name Finder
4. POS Tagger
5. Chunker
6. Parser



**Sentence Detector**

    Sentence detector is for detecting sentence boundaries.
    The trained openNLP model "en-sent.bin" used for this.
    
    
**Tokenizer**

    Tokens are usually words which are separated by space, but there are exceptions. 
    For example, "isn't" gets split into "is" and "n't, since it is a a brief format of "is not".
    The trained openNLP model "en-token.bin" used for this operation. 


**Name Finder**

    By its name, name finder just finds names in the context.
    It accepts an array of strings, and find the names inside, So need to tokenize the input data first.


**POS Tagger**
    
    Part-of-speech tagging is the process of marking up a word in a text (corpus) as corresponding
    to a particular part of speech such as noun, verb, adjective, etc.


    POS Tags and their meanings:-
    
    CC: Coordinating conjuction                             PRP$: Prossessive pronoun
    CD: Cardinal number                                     RB: Adverb
    DT: Determiner                                          RBR: Adverb, Comparative
    EX: Existential there                                   RBS: Adverb, Superlative
    FW: Foreign word                                        RP: Particle
    IN: preposition or subordinating conjunction            SYM: Symbol
    JJ: Adjective                                           TO: to
    JJR: Adjective, Comparative                             UH: Interjection
    JJS: Adjective, Superlative                             VB:Verb, base form
    LS: List item marker                                    VBD: Verb, Past tense
    MD: Modal                                               VBG: Verb, gerund or past participle
    NN: Noun, singular or mass                              VBN:Verb, past participle
    NNS: NOun, plural                                       VBP: Verb, non3rd person singular present
    NNP: Proper noun, singular                              VBZ: Verb, 3rd person singular present
    NNPS: Proper noun, plural                               WDT: Whdeterminer
    PDT: Predeterminer                                      WP: Whpronoun
    POS: Possessive ending                                  WP$: Possessive whpronoun
    PRP: Personal pronoun                                   WRB: Wh adverb
    
    



NOTES : All the required trained models are included in this repo, only need to provide proper path to the files.
