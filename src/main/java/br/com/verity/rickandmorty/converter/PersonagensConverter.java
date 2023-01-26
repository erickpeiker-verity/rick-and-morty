package br.com.verity.rickandmorty.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Converter;

public final class PersonagensConverter {

    private PersonagensConverter() {
        super();
    }

    public static Converter<Integer, Long> integerToLong() {
        return ctx -> ctx.getSource() == null
            ? 0
            : ctx.getSource().longValue();
    }

    public static Converter<Long, Integer> longToInteger() {
        return ctx -> ctx.getSource() == null
            ? 0
            : ctx.getSource().intValue();
    }

    public static Converter<List<String>, ArrayList<String>> listToArrayList() {
        return ctx -> ctx.getSource() == null
            ? new ArrayList<String>()
            : new ArrayList<String>(ctx.getSource());
    }

    public static Long stringToLong(String text) {
        return text == null
            ? 0
            : Long.parseLong(text);
    }

    
}
