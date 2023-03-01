package com.charlieThao.weather_forcast_demo.repository.user;

import com.charlieThao.weather_forcast_demo.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserMemoryDatabase implements UserDatabaseInterface {

    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
    HashMap<String, User> userHashMap = new HashMap<>(){{
        try {
            put("001", new User(false, "Nanami", " ", sdFormat.parse("2000/10/09"), "nanami@io.com", "090-8888-1234", "Australia", "AA111"));
            put("002", new User(false, "Luluka", " ", sdFormat.parse("2001/11/25"), "luluka@of.com", "070-3333-3456", "New Zealand", "BB222"));
            put("003", new User(false, "MomoNa", " ", sdFormat.parse("1999/7/28"), "momoa@gmail.com", "080-7777-6789", "Swiss", "CC333"));
            put("004", new User(false, "Lulupy", " ", sdFormat.parse("1998/7/18"), "lulupy@org.com", "090-5555-9865", "England", "DD444"));
            put("005", new User(false, "Fifici", " ", sdFormat.parse("2002/6/12"), "fifici@net.com", "090-6666-3498", "America", "EE555"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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
