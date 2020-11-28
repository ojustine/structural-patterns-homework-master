package ru.iteco.structural.home.orm.first;

import ru.iteco.structural.home.ContextOrm;
import ru.iteco.structural.home.IDbEntity;

/**
 * IFirstOrm.
 *
 * @author Ilya_Sukhachev
 */
public interface IFirstOrm<T extends IDbEntity> extends ContextOrm {

    void create(T entity);

    T read(int id);

    void update(T entity);

    void delete(T entity);
}
