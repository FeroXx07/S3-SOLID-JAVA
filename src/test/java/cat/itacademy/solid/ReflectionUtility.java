package cat.itacademy.solid;

import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;

public class ReflectionUtility {

    // Fetches all classes that implement the interface,
    // invokes their methods through functional interface (Consumer<T>)
    // and assert it doesn't throw any exception
    public static <T> void assertAllImplementationsSupport(
            Class<T> interfaceClass,
            Consumer<T> assertions
    ) throws Exception {

        Set<Class<? extends T>> implementations =
                findImplementations(interfaceClass);

        for (Class<? extends T> implementation : implementations) {

            T instance = implementation.getDeclaredConstructor().newInstance();

            assertThatCode(() -> assertions.accept(instance))
                    .as("Implementation %s should support all interface methods",
                            implementation.getSimpleName())
                    .doesNotThrowAnyException();
        }
    }

    // Returns all classes that implement the specified interface
    private static <T> Set<Class<? extends T>> findImplementations(Class<T> type) {
        Reflections reflections = new Reflections("com.myproject");

        return reflections.getSubTypesOf(type).stream()
                .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers()))
                .filter(clazz -> !clazz.isInterface())
                .collect(Collectors.toSet());
    }
}
