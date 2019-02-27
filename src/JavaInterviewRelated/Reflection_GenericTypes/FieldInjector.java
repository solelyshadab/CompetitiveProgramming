package JavaInterviewRelated.Reflection_GenericTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldInjector<T> {
    private T targetObject;

    public FieldInjector(T targetObject){
        this.targetObject = targetObject;
    }

    public void injectField(String fieldName, Object fieldValue){

        final Class className = targetObject.getClass();
        try {
            final Field field = className.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(targetObject, fieldValue);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
