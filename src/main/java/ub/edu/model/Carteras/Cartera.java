package ub.edu.model.Carteras;

import ub.edu.model.exceptions.NotFoundException;

public interface Cartera<T> {

        T get(String name) throws NotFoundException;

        void add(T t);

        void delete(T t) throws NotFoundException;
}
