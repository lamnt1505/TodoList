package com.example.todolist.service.todo;

import com.example.todolist.entity.Todos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface TodoService {

    List<Todos> findAll();

    List<Todos> findAll(Sort sort);

    Todos getTodoById(Long id);

    List<Todos> findAllById(Iterable<Long> longs);

    <S extends Todos> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Todos> S saveAndFlush(S entity);

    <S extends Todos> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Todos> entities);

    void deleteAllInBatch(Iterable<Todos> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Todos getOne(Long aLong);

    @Deprecated
    Todos getById(Long id);

    Todos getReferenceById(Long aLong);

    <S extends Todos> List<S> findAll(Example<S> example);

    <S extends Todos> List<S> findAll(Example<S> example, Sort sort);

    Page<Todos> findAll(Pageable pageable);

    <S extends Todos> S save(S entity);

    Optional<Todos> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    @Query(value = "select * from todos", nativeQuery = true)
    List<Todos> listTodos();

    void deleteById(Long id);

    void delete(Todos entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Todos> entities);

    void deleteAll();

    <S extends Todos> Optional<S> findOne(Example<S> example);

    <S extends Todos> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Todos> long count(Example<S> example);

    <S extends Todos> boolean exists(Example<S> example);

    <S extends Todos, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
