package com.epam.task.repositories;

import java.util.List;

public interface AdRepositoryInterface<T, Id> {
    List<T> get();
    T get(Id id);
    T add(T object);
    boolean removeById(Id id);
    List<T> findAllByUserId(Id id);
}
