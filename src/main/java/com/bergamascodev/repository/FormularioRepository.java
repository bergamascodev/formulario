package com.bergamascodev.repository;

import com.bergamascodev.entity.Formulario;
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
public class FormularioRepository implements JpaRepository<Formulario, Long> {

    @Override
    public void flush() {

    }

    @Override
    public <S extends Formulario> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Formulario> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Formulario> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Formulario getOne(Long aLong) {
        return null;
    }

    @Override
    public Formulario getById(Long aLong) {
        return null;
    }

    @Override
    public Formulario getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Formulario> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Formulario> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Formulario> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Formulario> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Formulario> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Formulario> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Formulario, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Formulario> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Formulario> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Formulario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Formulario> findAll() {
        return List.of();
    }

    @Override
    public List<Formulario> findAllById(Iterable<Long> longs) {
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
    public void delete(Formulario entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Formulario> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Formulario> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Formulario> findAll(Pageable pageable) {
        return null;
    }
}
