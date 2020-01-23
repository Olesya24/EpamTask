package com.epam.task.repositories;

import java.util.List;

public interface UserRepositoryInterface <T, Id> {
    T add(T object);
    boolean removeById(Id id);
}
