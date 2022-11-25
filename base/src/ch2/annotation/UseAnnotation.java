package ch2.annotation;

import java.lang.reflect.Field;

public class UseAnnotation {

    public static void main(String[] args) throws NoSuchFieldException {

        Person person = new Person("Tom", 23);
        Field age = person.getClass().getDeclaredField("age");
        Range annotation = age.getAnnotation(Range.class);
        if (null != annotation) {
            if (person.getAge() < annotation.min() || person.getAge() > annotation.max()) {
                throw new IllegalArgumentException("年龄必须处于0到100岁之间");
            }
        }

    }
}
