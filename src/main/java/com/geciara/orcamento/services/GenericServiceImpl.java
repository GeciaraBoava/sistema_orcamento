package com.geciara.orcamento.services;

import com.geciara.orcamento.exceptions.ItemNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.List;

public abstract class GenericServiceImpl<T, R extends JpaRepository<T, Long>> implements BaseService<T>{

    protected final R repository;

    public GenericServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> listAll() {
        return repository.findAll();
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    //sobrescreve apenas os dados não nulas e salva no banco de dados
    public T update(Long id, T updatedEntity) {
        return repository.findById(id)
                .map(existingEntity -> {
                    copyNonNullProperties(updatedEntity, existingEntity);
                    return repository.save(existingEntity);
                })
                .orElseThrow(ItemNotFoundException::new);
    }

    //método para copiar somente as propriedades não nulas de updateEntity para existingEntity
    private void copyNonNullProperties(T source, T target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source)); //copia as propriedades de um objeto para outro
    }

    //cria um array com as propriedades nulas, a serem ignoradas ao copiar e sobrescrever
    private String[] getNullPropertyNames(T source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Arrays.stream(wrappedSource.getPropertyDescriptors())
                .filter(pd -> pd.getReadMethod() != null) //garante que há um getter
                .filter( pd -> {
                    try {
                        Object value = pd.getReadMethod().invoke(source);
                        return value == null;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .map(FeatureDescriptor::getName)
                .toArray(String[]::new);
    }

}
