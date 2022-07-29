package brussels.digitalcity.maxdolmans.demorest.services;

import java.util.List;

public interface ICrudService<T, TID>{
    // C.R.U.D.

    // CREATE / UPDATE
    T save(T child );

    // READ
    T getOne(TID id);
    List<T> getAll();

    // DELETE
    T delete(TID id);
}
