package com.bergamascodev.repository;

import com.bergamascodev.entity.Time;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class TimeRepository implements JpaRepository<Time, Long> {

    @Override
    public void flush() {

    }

    @Override
    public <S extends Time> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Time> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Time> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Time getOne(Long aLong) {
        return null;
    }

    @Override
    public Time getById(Long aLong) {
        return null;
    }

    @Override
    public Time getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Time> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Time> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Time> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Time> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Time> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Time> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Time, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Time> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Time> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Time> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Time> findAll() {
        return List.of();
    }

    @Override
    public List<Time> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Time entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Time> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Time> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Time> findAll(Pageable pageable) {
        return null;
    }
}
