package com.bergamascodev.repository;

import com.bergamascodev.entity.RegistroFormulario;
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
public class RegistroFormularioRepository implements JpaRepository<RegistroFormulario, Long> {

    @Override
    public void flush() {

    }

    @Override
    public <S extends RegistroFormulario> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RegistroFormulario> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<RegistroFormulario> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RegistroFormulario getOne(Long aLong) {
        return null;
    }

    @Override
    public RegistroFormulario getById(Long aLong) {
        return null;
    }

    @Override
    public RegistroFormulario getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends RegistroFormulario> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RegistroFormulario> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends RegistroFormulario> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends RegistroFormulario> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RegistroFormulario> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RegistroFormulario> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RegistroFormulario, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends RegistroFormulario> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RegistroFormulario> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<RegistroFormulario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<RegistroFormulario> findAll() {
        return List.of();
    }

    @Override
    public List<RegistroFormulario> findAllById(Iterable<Long> longs) {
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
    public void delete(RegistroFormulario entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends RegistroFormulario> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<RegistroFormulario> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<RegistroFormulario> findAll(Pageable pageable) {
        return null;
    }
}
