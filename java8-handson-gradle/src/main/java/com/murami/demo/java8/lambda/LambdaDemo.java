package com.murami.demo.java8.lambda;

import java.util.List;

public class LambdaDemo {

    /**
     * List から，カンマ区切りの文字列にする．
     * 
     * @param names
     * @return
     */
    public static String reduceNamesToList(List<String> names) {
        StringBuilder builder = new StringBuilder();
        String delimeter = ", ";
        names.forEach( //
        (name) -> {
            if (builder.length() != 0) {
                builder.append(delimeter);
            }
            builder.append(name);
        }//
        );
        return builder.toString();
    }

}
