package dev.first.utils;

import com.google.gson.Gson;

public final class MapperUtils {

    private MapperUtils() {
    }

    public static <S, T> T map(final S source, final Class<T> classTarget) {
        final var gson = new Gson();
        final var tmp = gson.toJson(source);

        return gson.fromJson(tmp, classTarget);
    }
}
