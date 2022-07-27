package brussels.digitalcity.maxdolmans.demospring.services;

import java.util.List;

public interface IService<T, D, I> {
    List<D> getAll();
    D getById(I id);
    boolean update(I id, T t);
    boolean delete(I id);
    D insert(T t);
}
