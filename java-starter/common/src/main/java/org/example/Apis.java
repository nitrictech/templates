package org.example;

import io.nitric.Nitric;
import io.nitric.resources.ApiResource;

public class Apis {
    public static ApiResource publicApi() {
        return Nitric.INSTANCE.api("public");
    }
}