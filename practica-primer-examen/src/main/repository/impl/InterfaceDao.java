package main.repository.impl;

import java.util.ArrayList;

public interface InterfaceDao <T>{

    public T registrar(T t);

    public ArrayList<T> listarTodos();

}
