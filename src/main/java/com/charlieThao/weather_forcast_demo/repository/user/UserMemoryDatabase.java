package com.charlieThao.weather_forcast_demo.repository.user;

import com.charlieThao.weather_forcast_demo.model.User;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

public class UserMemoryDatabase implements UserDatabaseInterface {

    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
    HashMap<String, User> userHashMap = new HashMap<>(){{
            //String id, String userName, String email, String password,
            //  List<Location> locationList, List<Role> roleList
            put("001", new User("001", "Nanami", "nanami@io.com", " ", null, null));
            put("002", new User("002", "Luluka", "luluka@of.com", " ", null, null));
            put("003", new User("003", "MomoNa", "momoa@gmail.com", " ", null, null));
            put("004", new User("004", "Lulupy", "lulupy@org.com", " ", null, null));
            put("005", new User("005", "Fifici", "fifici@net.com", " ", null, null));
        }};

    @Override
    public boolean creatUser(String idNumber, User user) {
        if (!userHashMap.containsKey(idNumber)) {
            userHashMap.put(idNumber, user);
            return true;
        }
        return false;
    }

    @Override
    public User updateUser(String idNumber, User user) {
        if (userHashMap.containsKey(idNumber)) {
            userHashMap.put(idNumber, user);
            return user;
        }
        return null;
    }

    @Override
    public User getUser(String idNumber) {
        return userHashMap.get(idNumber);
    }

    @Override
    public List<User> getAllUser() {
        return userHashMap.values().stream().toList();
    }

    @Override
    public boolean deleteUser(String idNumber) {
        if (userHashMap.containsKey(idNumber)) {
            userHashMap.remove(idNumber);
            return true;
        }
        return false;
    }
}
