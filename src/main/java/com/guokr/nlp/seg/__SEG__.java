package com.guokr.nlp.seg;

import java.lang.reflect.Method;

public enum __SEG__ {

    INSTANCE;

    private Class<?> clazz = __PKG__.INSTANCE.load("com.guokr.nlp.seg.SegWrapper");
    private Object   seg   = __PKG__.INSTANCE.create("com.guokr.nlp.seg.SegWrapper");

    public String segment(String text) {
        String result = null;
        try {
            Class<?>[] argTypes = new Class[] { String.class };
            Method mtd = this.clazz.getDeclaredMethod("segment", argTypes);
            Object[] args = new String[] { text };
            result = mtd.invoke(this.seg, args).toString();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }

}
