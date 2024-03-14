package com.james.api.user;



import com.james.api.common.UtilService;
import com.james.api.common.UtilServiceImpl;
import com.james.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    UserServiceImpl userSerivice;
    UtilService utilService;

    public UserController() {
        this.userSerivice = UserServiceImpl.getInstance();
        this.utilService = UtilServiceImpl.getInstance();
    }
    public String delete(Scanner sc) {
        userSerivice.delete(User.builder()
                .username(sc.next())
                .build());
        return "회원삭제";
    }

    public String addUsers() {
        return userSerivice.addUsers();
    }
    public String login(Scanner sc) {
        System.out.println("ID, 비밀번호를 입력하세요.");

        return userSerivice.login(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }

    public String save(Scanner sc) {
        userSerivice.save(User.builder()
                .username(sc.next())
                .password(sc.next())
                .checkPassword(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .build());
        return "회원가입 성공";
    }

    public List<User> findAll() {
        return userSerivice.findAll();
    }
    public Optional<User> findById(Scanner sc){
        System.out.println("아이디를 입력하세요.");
        return userSerivice.findById(Long.parseLong(sc.next()));
    }
    public String changePassword(Scanner sc){
        System.out.println("아이디와 변경할 비밀번호를 입력하세요.");
        return userSerivice.changePassword(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }
    public List<?> findUsersByName(Scanner sc) {
        return userSerivice.findUsersByName(sc.next());
    }
    public Map<String, ?> findUsersByNameFromMap(Scanner sc) {
        return userSerivice.findUsersByNameFromMap(sc.next());
    }
    public List<?> findUsersByJob(Scanner sc) {
        System.out.println("직업을 입력하세요.");
        return userSerivice.findUsersByJob(sc.next());
    }
    public Map<String, ?> findUsersByJobFromMap(Scanner sc) {
        return userSerivice.findUsersByJobFromMap(sc.next());
    }

    public Map<String, ?> getUsersMap() {
        return userSerivice.getUsersMap();
    }

    public String count() {
        return "회원수 : " + userSerivice.count() + " 명";
    }
    public Optional<User> getOne(Scanner sc) {
        return userSerivice.getOne(sc.next());
    }
    public Boolean existsById(Scanner sc) {
        return userSerivice.existById(Long.parseLong(sc.next()));
    }

    public String test(Scanner sc) {
        return userSerivice.test();
    }

    public User findUser() {
        return userSerivice.findUser();
    }

    public List<?> findUsers() throws SQLException {
        return userSerivice.findUsers();
    }

    public Messenger createTable() throws SQLException {
        return userSerivice.createTable();
    }

    public Messenger deleteTable() throws SQLException {
        return userSerivice.deleteTable();
    }

    public Messenger insertData(Scanner sc) throws SQLException {
        return userSerivice.insertData(User.builder()
                .username(sc.next())
                .password(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .height(utilService.createRandomDouble(150,50))
                .weight(utilService.createRandomDouble(30,120))
                .build());
    }

    public void sqlClose() throws SQLException {
        userSerivice.sqlClose();
    }
}