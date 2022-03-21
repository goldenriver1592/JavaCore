package bo;

import java.util.List;

public interface IMethod<E> {

    boolean add();

    boolean update(String rollNumber);

    boolean remove(String rollNumber);

    List<E> search(String text);

    void sort();

    void display();
}
