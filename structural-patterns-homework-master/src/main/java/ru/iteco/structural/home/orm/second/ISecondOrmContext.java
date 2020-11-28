package ru.iteco.structural.home.orm.second;

import ru.iteco.structural.home.DbUserEntity;
import ru.iteco.structural.home.DbUserInfoEntity;
import ru.iteco.structural.home.IDbEntity;

import java.util.Set;

/**
 * ISecondOrmContext.
 *
 * @author Ilya_Sukhachev
 */
public interface ISecondOrmContext {

    Set<IDbEntity> getUsers();
    Set<IDbEntity> getUserInfos();

}
