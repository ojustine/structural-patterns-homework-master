package ru.iteco.structural.home;

import ru.iteco.structural.home.orm.TargetOrm;
import ru.iteco.structural.home.orm.first.IFirstOrm;
import ru.iteco.structural.home.orm.second.ISecondOrm;

import java.util.Set;

public class AdapterOrm implements TargetOrm<IDbEntity> {
	private final ContextOrm contextOrm;

	public AdapterOrm(ContextOrm contextOrm) {
		this.contextOrm = contextOrm;
	}

	@Override
	public void create(IDbEntity entity) {
		if (contextOrm instanceof IFirstOrm) {
			((IFirstOrm<IDbEntity>) contextOrm).create(entity);
		}
	}

	@Override
	public IDbEntity read(Long id) {
		if (contextOrm instanceof IFirstOrm) {
			return ((IFirstOrm<IDbEntity>) contextOrm).read(id.intValue());
		} else {
			return ((ISecondOrm) contextOrm).getContext().getUsers().stream()
																	.filter(i -> id.equals(i.getId()))
																	.findFirst()
																	.orElse(null);
		}
	}

	@Override
	public void update(IDbEntity entity) {
		if (contextOrm instanceof IFirstOrm) {
			((IFirstOrm<IDbEntity>) contextOrm).update(entity);
		}
	}

	@Override
	public void delete(IDbEntity entity) {
		if (contextOrm instanceof IFirstOrm) {
			((IFirstOrm<IDbEntity>) contextOrm).delete(entity);
		}
	}

	@Override
	public Set<IDbEntity> getUsers() {
		if (contextOrm instanceof ISecondOrm) {
			return ((ISecondOrm) contextOrm).getContext().getUsers();
		} else {
			return null;
		}
	}

	@Override
	public Set<IDbEntity> getUserInfos() {
		if (contextOrm instanceof ISecondOrm) {
			return ((ISecondOrm) contextOrm).getContext().getUserInfos();
		} else {
			return null;
		}
	}
}
