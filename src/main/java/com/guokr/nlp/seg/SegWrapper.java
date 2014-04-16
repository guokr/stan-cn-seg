package com.guokr.nlp.seg;

import java.util.Properties;

import com.guokr.util.Reflector;

import edu.stanford.nlp.ie.crf.CRFClassifier;

public class SegWrapper {

    private static Class<?>  clzSettings = Reflector.classFor("com.guokr.util.Settings");
    private static Object    defaults    = Reflector.callStaticly(clzSettings, "load", new Class[] { String.class },
                                                 new Object[] { "xcf:///seg/defaults.using.prop" });

    private CRFClassifier<?> classifier;

    public SegWrapper(Object settings) {
        Properties props = (Properties) Reflector.newInstance(clzSettings, new Class[] { Properties.class,
                Properties.class }, new Object[] { settings, defaults });

        String model = props.getProperty("model");
        try {
            classifier = CRFClassifier.getClassifier(model, props);

            // ObjectOutputStream oos = new ObjectOutputStream(new
            // GZIPOutputStream(new MultipleGZIPOutputStream(
            // "/Users/mingli/git/stan-cn-seg/src/main/resources/seg/ctb/ctb.gz")));
            // classifier.serializeClassifier(oos);
            // oos.flush();
            // oos.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace(System.err);
        }
    }

    public SegWrapper() {
        new SegWrapper((Object)null);
    }

    public String segment(String text) {
        return classifier.classifyToString(text).trim();
    }

}
