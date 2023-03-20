package com.example.todolist.service.todo;

import com.example.todolist.entity.Todos;
import com.example.todolist.respository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todos> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todos> findAll(Sort sort) {
        return todoRepository.findAll(sort);
    }

    @Override
    public Todos getTodoById(Long id){
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Todos> findAllById(Iterable<Long> longs) {
        return todoRepository.findAllById(longs);
    }

    @Override
    public <S extends Todos> List<S> saveAll(Iterable<S> entities) {
        return todoRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        todoRepository.flush();
    }

    @Override
    public <S extends Todos> S saveAndFlush(S entity) {
        return todoRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Todos> List<S> saveAllAndFlush(Iterable<S> entities) {
        return todoRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Todos> entities) {
        todoRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Todos> entities) {
        todoRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        todoRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        todoRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Todos getOne(Long aLong) {
        return todoRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public Todos getById(Long id) {
        return todoRepository.getById(id);
    }

    @Override
    public Todos getReferenceById(Long aLong) {
        return todoRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends Todos> List<S> findAll(Example<S> example) {
        return todoRepository.findAll(example);
    }

    @Override
    public <S extends Todos> List<S> findAll(Example<S> example, Sort sort) {
        return todoRepository.findAll(example, sort);
    }

    @Override
    public Page<Todos> findAll(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    @Override
    public <S extends Todos> S save(S entity) {
        return todoRepository.save(entity);
    }

    @Override
    public Optional<Todos> findById(Long aLong) {
        return todoRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return todoRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return todoRepository.count();
    }

    @Override
    public List<Todos> listTodos() {
        return todoRepository.listTodos();
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void delete(Todos entity) {
        todoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        todoRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Todos> entities) {
        todoRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        todoRepository.deleteAll();
    }

    @Override
    public <S extends Todos> Optional<S> findOne(Example<S> example) {
        return todoRepository.findOne(example);
    }

    @Override
    public <S extends Todos> Page<S> findAll(Example<S> example, Pageable pageable) {
        return todoRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Todos> long count(Example<S> example) {
        return todoRepository.count(example);
    }

    @Override
    public <S extends Todos> boolean exists(Example<S> example) {
        return todoRepository.exists(example);
    }

    @Override
    public <S extends Todos, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return todoRepository.findBy(example, queryFunction);
    }
}
