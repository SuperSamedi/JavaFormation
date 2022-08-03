package brussels.digitalcity.maxdolmans.demorest.services;

import java.util.List;

public interface CrudService<T, TID>{
    // C.R.U.D.

    // CREATE
    T create(T toCreate );

    // UPDATE
    T update(TID id, T toUpdate);

    // READ
    T getOne(TID id);
    List<T> getAll();

    // DELETE
    void delete(TID id);
}
