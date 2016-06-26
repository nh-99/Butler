package com.nohowdezign.butler.processing;

import edu.stanford.nlp.simple.Sentence;

/**
 * @author Noah Howard
 */
public class LanguageProcessor {

    public LanguageProcessor() {
    }

    public String getPartOfSpeechFromSentence(String sentence, String pos) {
        String toReturn = "";
        Sentence sentence1 = new Sentence(sentence);
        for(int i = 0; i < sentence1.words().size(); i++) {
            if(sentence1.posTags().get(i).contains(pos)) {
                toReturn += sentence1.words().get(i) + " ";
            }
        }
        return toReturn.trim().replaceAll("(\\s)+", "$1");
    }

    public String tagPartsOfSpeech(String sentence) {
        String toReturn = "";
        Sentence sentence1 = new Sentence(sentence);
        for(int i = 0; i < sentence1.words().size(); i++) {
            toReturn += sentence1.words().get(i) + "_" + sentence1.posTags().get(i) + " ";
        }
        return toReturn.trim().replaceAll("(\\s)+", "$1");
    }

    public String getSubject(String sentence) {
        String toReturn = "";
        Sentence sentence1 = new Sentence(sentence);
        for(int i = 0; i < sentence1.incomingDependencyLabels().size(); i++) {
            if(sentence1.incomingDependencyLabel(i).get().equals("nsubj")) {
                toReturn = sentence1.word(i);
            }
        }
        return toReturn.trim().replaceAll("(\\s)+", "$1");
    }

    public String getNamedEntities(String sentence) {
        String toReturn = "";
        Sentence sentence1 = new Sentence(sentence);
        for(int i = 0; i < sentence1.nerTags().size(); i++) {
            toReturn += sentence1.word(i) + "_" + sentence1.nerTag(i) + " ";
        }
        return toReturn.trim().replaceAll("(\\s)+", "$1");
    }

    public String getNamedEntity(String sentence, String entity) {
        String toReturn = "";
        Sentence sentence1 = new Sentence(sentence);
        for(int i = 0; i < sentence1.nerTags().size(); i++) {
            if(sentence1.nerTag(i).contains(entity)) {
                toReturn += sentence1.word(i) + " ";
            }
        }
        return toReturn.trim().replaceAll("(\\s)+", "$1");
    }

}