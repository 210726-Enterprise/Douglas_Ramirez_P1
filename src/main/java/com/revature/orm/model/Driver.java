package com.revature.orm.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] constructors = User.class.getConstructors();

        for (Constructor<?> constructor: constructors)
        {
            System.out.println(constructor);

        }

        User u = (User) Arrays.stream(constructors).filter(c -> c.getParameterCount() == 0)
                .findFirst()
                .orElseThrow(RuntimeException::new).newInstance();

        System.out.println(u.getEmployee_id());
        System.out.println(u.getEmail());
        System.out.println(u.getFirstname());
        System.out.println(u.getLastname());


    }

}
