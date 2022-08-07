package za.ac.cput.Repository.iml;

@Deprecated
public interface iRepository<T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
