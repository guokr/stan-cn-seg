package com.guokr.nlp.seg;

import com.guokr.protocol.Protocols;
import com.guokr.util.Settings;

import edu.stanford.nlp.ie.crf.CRFClassifier;

public class SegWrapper {

    static Protocols         protocols = Protocols.INSTANCE;
    static Settings          defaults  = Settings.load("xcf:///seg/defaults.using.prop");

    private CRFClassifier<?> classifier;

    public SegWrapper() {
        this(null);
    }

    public SegWrapper(Settings settings) {
        Settings props = new Settings(settings, defaults);
        String model = props.getProperty("model");
        try {
            this.classifier = CRFClassifier.getClassifier(model, props);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public String segment(String text) {
        return this.classifier.classifyToString(text).trim();
    }

}
