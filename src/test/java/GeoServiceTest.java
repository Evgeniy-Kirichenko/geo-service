import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceTest {
    GeoServiceImpl geoService;

    @BeforeEach
    public void init() {
        geoService = new GeoServiceImpl();
    }

    @MethodSource("argId")
    @ParameterizedTest
    public void byIpTest(String id, Country expected) {
        Location rez = geoService.byIp(id);
        Assertions.assertEquals(expected, rez.getCountry());Assertions.assertEquals(new Location("Moscow", Country.RUSSIA, "Lenina", 15),rez);

    }

    public static Stream<Arguments> argId() {
        return Stream.of(Arguments.of("172.", Country.RUSSIA),
                Arguments.of(GeoServiceImpl.MOSCOW_IP, Country.RUSSIA),
                Arguments.of("96.", Country.USA),
                Arguments.of(GeoServiceImpl.NEW_YORK_IP, Country.USA));
    }

    @Test
    public void byIpTestNull() {
        Location rez = geoService.byIp("127.0.0.1");
        Assertions.assertNull(rez.getCountry());
    }

}
