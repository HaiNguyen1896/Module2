package manager.i_manager;

import java.util.List;

public interface IManagement<E>{
    void add(E e);
    void remove(int id);
    int findIndexByID(int id);
    List<E> getAll();
}
