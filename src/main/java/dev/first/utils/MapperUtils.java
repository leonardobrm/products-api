package dev.first.utils;

import com.google.gson.GsonBuilder;
import dev.first.infrastructure.config.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class MapperUtils {

    private MapperUtils() {
    }

    public static <S, T> T map(final S source, final Class<T> classTarget) {
        final var gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        final var tmp = gson.toJson(source);
        return gson.fromJson(tmp, classTarget);
    }

    public static <S, T> List<T> mapList(final List<S> listSource, final Class<T> classTarget) {
        final var output = new ArrayList<T>();
        listSource.forEach(s -> output.add(map(s, classTarget)));
        return output;
    }

    public static <S, T> Optional<T> mapOptional(final Optional<S> optionalSource, final Class<T> classTarget) {
        return optionalSource.map(element -> map(element, classTarget));
    }
}
