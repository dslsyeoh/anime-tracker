package com.dsl.anime.tracker;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class TestConvert
{
    public static void main(String[] args)
    {
        List<Integer> objects = Arrays.asList(1, 2, 3, 4, 5);
        TestConvert testConvert = new TestConvert();
        List<String> toList = testConvert.toList(objects, String.class);

        TestEntity testEntity = new TestEntity();
        testEntity.setId("1");
        testEntity.setValue("value_1");
        List<TestEntity> testEntities = Arrays.asList(testEntity, testEntity);
        List<TestDetails> testDetailsList = testConvert.toList(testEntities, TestDetails.class);

        toList.forEach(System.out::println);
        testDetailsList.forEach(testDetails -> System.out.println(testDetails.getId() + "=" + testDetails.getValue()));

        TestDetails testDetails = testConvert.toMap(testEntity, TestDetails.class);
        System.out.println(testDetails.getId() + "=" + testDetails.getValue());
    }

    private <T, C> List<C> toList(T object, Class<C> clazz)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return objectMapper.convertValue(object, type);
    }

    private <T, C> C toMap(T target, Class<C> clazz)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(target, clazz);
    }
}
