package com.guokr.nlp.seg;

import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.xeustechnologies.jcl.AbstractClassLoader;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

import com.guokr.util.DowngradeClassLoader;

public enum __PKG__ {

    INSTANCE;

    private ProtectionDomain    domain        = JarClassLoader.class.getProtectionDomain();
    private CodeSource          source        = domain.getCodeSource();
    private URL                 location      = source.getLocation();
    private String              path          = (location != null ? location.getPath() : null);
    private AbstractClassLoader loader        = (path != null ? new JarClassLoader(new String[] { path })
                                                      : new DowngradeClassLoader(getClass().getClassLoader()));
    private JclObjectFactory    factory       = JclObjectFactory.getInstance();

    Object                      protocol      = loader.safeLoadClass("com.guokr.protocol.Protocols")
                                                      .getEnumConstants()[0];
    Class<?>                    localSettings = loader.safeLoadClass("com.guokr.util.Settings");
    Class<?>                    localIOUtils  = loader.safeLoadClass("edu.stanford.nlp.io.IOUtils");

    public Class<?> load(String clazzName) {
        return loader.safeLoadClass(clazzName);
    }

    public Object create(String clazzName) {
        try {
            return path != null ? factory.create((JarClassLoader) loader, clazzName, new Object[] { null },
                    new Class[] { Object.class }) : Class.forName(clazzName).newInstance();
        } catch (java.lang.ClassNotFoundException e) {
            return null;
        } catch (java.lang.InstantiationException e) {
            return null;
        } catch (java.lang.IllegalAccessException e) {
            return null;
        }
    }

}