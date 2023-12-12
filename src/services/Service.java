package services;

import java.io.File;
import java.util.ArrayList;

public interface Service<T> {
    File file = null;
    public void saveDataToFile();
    public void insert(T t);
    public ArrayList<T> find();
    public void delete(T t);
    public void update(T t);
}
