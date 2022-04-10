/*iRepository.java
Interface for Repository
Author: Kanya Ramncwana (218297521)
Date: 09 April 2022*/

package za.ac.cput.Interface;

public interface iRepository<T, ID>{
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
}
