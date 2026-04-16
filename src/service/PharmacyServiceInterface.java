package service;

import java.util.List;

public interface PharmacyServiceInterface<T, ID> {
    void add(T item);
    void delete(ID id);
    List<T> getAll();
    void sell(ID itemId, int quantity, boolean condition);
}
