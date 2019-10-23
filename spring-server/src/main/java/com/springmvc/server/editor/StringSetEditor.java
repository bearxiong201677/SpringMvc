package com.springmvc.server.editor;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by hexiaofeng on 16-1-10.
 */
public class StringSetEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Set<String> values = new HashSet<String>();
        if (text != null) {
            StringTokenizer tokenizer = new StringTokenizer(text, ";,");
            String token;
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                values.add(token);
            }
        }
        setValue(values);
    }
}
