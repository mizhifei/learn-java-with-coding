package ch4.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class LearnClass {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<System> systemClass = System.class;
        Class<?>[] classes = systemClass.getClasses();
        System.out.println(classes);
        String simpleName = systemClass.getSimpleName();

        Class<String> stringClass = String.class;
        Class<String[]> aClass = String[].class;
        String packageName = aClass.getPackageName();
        String name = stringClass.getPackage().getName();
        System.out.println(simpleName);

        Class<Integer> integerClass = int.class;

        Field value = String.class.getDeclaredField("value");
        Class<?> type = value.getType();
        int modifiers = value.getModifiers();
        String s = Modifier.toString(modifiers);
        System.out.println(s);


    }
}
