/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Interface
 * **/
package za.ac.cput.Repository.iml;

@Deprecated
public interface iRepository<T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
