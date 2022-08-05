package brussels.digitalcity.maxdolmans.demorest.services;

import java.util.List;

public interface CrudService<T, TID, TIFORM, TUFORM>{
    // C.R.U.D.

    // CREATE
    T create(TIFORM toCreate );

    // UPDATE
    T update(TID id, TUFORM toUpdate);

    // READ
    T getOne(TID id);
    List<T> getAll();

    // DELETE
    T delete(TID id);
}
