package com.james.api.enums;

import com.james.api.user.UserController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public enum UserRouterOfPredicate {
    EXIT("x", (a, b) -> {
        System.out.println("EXIT");
        return false;
    }),
    LOGIN("log", (a,b) ->{
        System.out.println("LOGIN");
        a.login(b);
        return true;
    }),
    FINDUSER("f", (a,b) ->{
        System.out.println("FIND USER");
        a.findUser();
        return true;
    }),
    CHANGEPASSWORD("c", (a,b) ->{
        System.out.println("CHANGE PASSWORD");
        a.changePassword(b);
        return true;
    }),
    DELETE("d", (a,b) ->{
        System.out.println("DELETE USER");
        a.delete(b);
        return true;
    }),
    LIST("ls", (a,b) ->{
        System.out.println("USERS LIST");
        try {
            a.findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    FINDUSERSBYNAME("fn", (a,b) ->{
        System.out.println("FIND USERS BY NAME");
        a.findUsersByName(b);
        return true;
    }),
    FINDUSERSBYJOB("fj", (a,b) ->{
        System.out.println("FIND USERS BY JOB");
        a.findUsersByJob(b);
        return true;
    }),
    USERCOUNT("uc", (a,b) ->{
        System.out.println("USER COUNT");
        a.count();
        return true;
    }),
    TOUCH("touch", (a, b)-> {
        System.out.println("CREATE");
        try {
            System.out.println(a.createTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }),
    REMOVE("rm", (a, b)-> {
        System.out.println("REMOVE");
        try {
            System.out.println(a.deleteTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    INSERT("in", (a, b)-> {
        System.out.println("INSERT");
        try {
            System.out.println(a.insertData(b));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    })
    ;

    private final String name;
    private final BiPredicate<UserController, Scanner> predicate;

    UserRouterOfPredicate(String name, BiPredicate<UserController, Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean userRouterTest(UserController ctrl, Scanner sc){
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
        return Arrays.stream(values())
                .filter(i->i.name.equals(msg))
                .findFirst().orElseThrow(() ->new IllegalArgumentException("올바른 값이 아닙니다."))
                .predicate.test(ctrl,sc);
    }
}
