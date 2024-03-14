package com.james.api.enums;

import com.james.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("x", scan -> {
        System.out.println("EXIT");
        return false;
    }),
    LOGIN("log", scan ->{
        System.out.println("LOGIN");
        UserController.getInstance().login(scan);
        return true;
    }),
    FINDUSER("f", scan ->{
        System.out.println("FIND USER");
        UserController.getInstance().getOne(scan);
        return true;
    }),
    CHANGEPASSWORD("c", scan ->{
        System.out.println("CHANGE PASSWORD");
        System.out.println(UserController.getInstance().changePassword(scan));
        return true;
    }),
    DELETE("d", scan ->{
        System.out.println("DELETE USER");
        System.out.println(UserController.getInstance().delete(scan));
        return true;
    }),
    LIST("ls", scan ->{
        System.out.println("USERS LIST");
        try {
            UserController.getInstance().findUsers().forEach(i-> System.out.println(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    FINDUSERSBYNAME("fn", scan ->{
        System.out.println("FIND USERS BY NAME");
        UserController.getInstance().findUsersByName(scan);
        return true;
    }),
    FINDUSERSBYJOB("fj", scan ->{
        System.out.println("FIND USERS BY JOB");
        UserController.getInstance().findUsersByJob(scan);
        return true;
    }),
    USERCOUNT("uc", scan ->{
        System.out.println("USER COUNT");
        UserController.getInstance().count();
        return true;
    }),
    TOUCH("touch", scan-> {
        System.out.println("CREATE");
        try {
            System.out.println(UserController.getInstance().createTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }),
    REMOVE("rm", scan -> {
        System.out.println("REMOVE");
        try {
            System.out.println(UserController.getInstance().deleteTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    INSERT("in", scan -> {
        System.out.println("INSERT");
        try {
            System.out.println(UserController.getInstance().insertData(scan));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    WRONG("WRONG", scan -> {
        System.out.println("WRONG");
        return true;
    })
    ;

    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean userRouter(UserController ctrl, Scanner sc){
        System.out.println("[MENU]\n" +
                "x-Exit\n" +
                "log-LOGIN\n" +
                "f-FIND USER\n" +
                "c-CHANGE PASSWORD\n" +
                "d-DELETE USER\n" +
                "ls-USERS LIST\n" +
                "fn-FIND USERS BY NAME\n" +
                "fj-FIND USERS BY JOB\n" +
                "uc-USER COUNT\n" +
                "touch-테이블생성\n" +
                "rm-테이블삭제\n" +
                "in-데이터추가");
        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findFirst().orElseGet(() -> WRONG)
                .predicate.test(sc);
    }
}
