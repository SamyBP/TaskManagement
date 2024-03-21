package ro.app.taskmanagement.mappers;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;


@Component
public interface Mapper<Destination> {
    default <Source> Destination createMap(Source source, Class<Destination> clazz) {
        Destination destination = null;

        try {
            destination = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Field[] sourceFields = source.getClass().getDeclaredFields();

        for (Field sourceField : sourceFields) {
            try {
                sourceField.setAccessible(true);
                Field destiantionField = clazz.getDeclaredField(sourceField.getName());
                destiantionField.setAccessible(true);
                destiantionField.set(destination, sourceField.get(source));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return destination;
    }
}
