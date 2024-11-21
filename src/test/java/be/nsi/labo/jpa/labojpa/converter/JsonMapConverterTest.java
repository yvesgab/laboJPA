package be.nsi.labo.jpa.labojpa.converter;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JsonMapConverterTest {
    JsonMapConverter converter = new JsonMapConverter();

    @Test
    void convertToDatabaseColumn() {
        String json = converter.convertToDatabaseColumn(Map.of("foo", "bar"));
        assertThat(json).isNotEmpty();
    }

    @Test
    void convertToEntityAttribute() {
        Map<String, Serializable> map = Map.of("foo", "bar");
        String json = converter.convertToDatabaseColumn(map);
        Map<String, Serializable> converted = converter.convertToEntityAttribute(json);

        assertThat(converted).containsKey("foo");
    }
}