package ro.app.taskmanagement.mappers;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Component;
import ro.app.taskmanagement.dtos.SignUpDto;
import ro.app.taskmanagement.models.User;

import java.lang.reflect.Field;

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
//            boolean flag = destinationField.isAnnotationPresent(Id.class)
//                    | destinationField.isAnnotationPresent(OneToMany.class)
//                    | destinationField.isAnnotationPresent(ManyToOne.class)
//                    | destinationField.isAnnotationPresent(ManyToMany.class);
//
//            if (!flag) {
//               try {
//                   destinationField.setAccessible(true);
//                   Field sourceField = source.getClass().getDeclaredField(destinationField.getName());
//                   sourceField.setAccessible(true);
//                   destinationField.set(destination, sourceField.get(source));
//               } catch (NoSuchFieldException | IllegalAccessException e) {
//                   throw new RuntimeException(e);
//               }
//            }

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
