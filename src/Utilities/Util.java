package Utilities;

import java.util.List;

public class Util {
    public static <T> void printElements(List<T> list){
        for(T element : list){
            System.out.println(element);
        }
    }
}
