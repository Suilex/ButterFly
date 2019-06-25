package service;

import java.util.List;

public class ShowCommand<T> {

    public void show(List<T> list) {
       for (T item : list) {
           System.out.println(item.toString());
       }

    }
}