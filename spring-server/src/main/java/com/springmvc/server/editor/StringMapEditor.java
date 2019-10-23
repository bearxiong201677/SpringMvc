package com.springmvc.server.editor;

import org.springframework.beans.propertyeditors.CustomMapEditor;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by hexiaofeng on 16-1-10.
 */
public class StringMapEditor extends CustomMapEditor {
    public StringMapEditor() {
        super(Map.class);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            super.setAsText(null);
            return;
        }
        Map<String, String> values = new HashMap<String, String>();
        StringTokenizer tokenizer = new StringTokenizer(text, ";,");
        String token;
        int pos;
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            pos = token.indexOf('=');
            if (pos > 0) {
                values.put(token.substring(0, pos), token.substring(pos + 1));
            }
        }
        setValue(values);
    }
}
