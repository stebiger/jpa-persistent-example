package de.oc.hg;

import javax.inject.Named;

@Named
public class Foo {

    private String attr = "Bar";

    public String getAttr() {
        return attr;
    }
}
