package com.example.hibernatetest.converter.json;

import com.example.hibernatetest.model.Role;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhurenkov Pavel 27.07.2023
 */
public class CustomListSerializer extends StdSerializer<List<Role>> {

    public CustomListSerializer() {
        this(null);
    }

    public CustomListSerializer(Class<List<Role>> t) {
        super(t);
    }
    @Override
    public void serialize(List<Role> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<String> str = new ArrayList<>();
        for (Role role : value) {
            str.add(role.getRole());
        }
        gen.writeObject(str);
    }
}
