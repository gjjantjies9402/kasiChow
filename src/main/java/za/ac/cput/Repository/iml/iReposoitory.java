package za.ac.cput.Repository.iml;

public interface iReposoitory <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
