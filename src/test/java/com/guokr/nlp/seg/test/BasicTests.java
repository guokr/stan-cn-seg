package com.guokr.nlp.seg.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.guokr.nlp.seg.__SEG__;

@RunWith(JUnit4.class)
public class BasicTests {

    @Test
    public void testSeg() throws Exception {
        String segText = __SEG__.INSTANCE.segment("这是个测试");
        assertEquals("这 是 个 测试", segText);
    }

}
