package ru.iteco.structural.home.orm;

import ru.iteco.structural.home.IDbEntity;

import java.util.Set;

public interface TargetOrm<T extends IDbEntity> {

	void create(T entity);

	T read(Long id);

	void update(T entity);

	void delete(T entity);

	Set<T> getUsers();

	Set<T> getUserInfos();

}
