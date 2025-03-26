package com.geciara.orcamento.services;

import java.util.List;

public interface BaseService<T> {
    List<T> listAll();
    T findById(Long id);
    T save(T entity);
    void delete(Long id);
    T update(Long id, T updatedEntity);
}
