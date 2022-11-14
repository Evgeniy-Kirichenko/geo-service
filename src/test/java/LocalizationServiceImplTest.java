import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

public class LocalizationServiceImplTest {
    @MethodSource("argCount")
    @ParameterizedTest
    public void localTest(Country country, String expected) {
        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();
        Assertions.assertEquals(expected, localizationServiceImpl.locale(country));
    }

    public static Stream<Arguments> argCount() {
        return Stream.of(Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"));
    }
}
