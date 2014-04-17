package com.guokr.nlp.seg;


public enum __SEG__ {

    INSTANCE;

    private SegWrapper seg = new SegWrapper();

    public String segment(String text) {
        String result = null;
        try {
            result = seg.segment(text);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

}
