package com.example.hibernatetest.converter.json;

import com.example.hibernatetest.model.Role;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhurenkov Pavel 27.07.2023
 */
public class CustomListDeserializer extends StdDeserializer<List<Role>> {

    public CustomListDeserializer() {
        this(null);
    }

    public CustomListDeserializer(Class<?> t) {
        super(t);
    }

    @Override
    public List<Role> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return new ArrayList<>();
    }


}
