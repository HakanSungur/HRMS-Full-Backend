package hrmsfullBackend.hrms.core.services;

import java.util.List;

public interface DtoConventerService {

	<S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);

    <T> Object dtoClassConverter(Object source, Class<T> baseClass);
}
