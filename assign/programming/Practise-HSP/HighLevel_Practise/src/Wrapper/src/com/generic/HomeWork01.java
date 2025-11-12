package Wrapper.src.com.generic;


import java.util.*;

public class HomeWork01 {

    public void TestJ(){
        DAO<DAO.User> userDAO = new DAO<>();
        userDAO.save("01",new DAO.User(1,30,"LOVE"));
        userDAO.save("01",new DAO.User(1,30,"L2E"));
        userDAO.save("01",new DAO.User(1,30,"L1E"));
        List list = userDAO.list();
        System.out.println(list);
    }


}

class DAO<T> {
    Map<String, T> map;

    public DAO() {
        map = new HashMap<>();
    }

    public void save(String id, T entity) {
        this.map.put(id, entity);
    }

    public T get(String id) {
        return this.map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> set = map.keySet();
        for (String s : set) {
            list.add(map.get(s));
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }

    static class User{
        private int id;
        private int age;
        private String name;

        public User(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }
}
