package com.markahenrich.jrest.model;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class GenericModel<T> {
    @NonNull
    private UUID id;
    @NonNull
    private T data;
}
