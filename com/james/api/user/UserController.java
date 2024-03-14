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

    UtilService utilService;
    UserServiceImpl userService;


    public UserController() {
        this.userService = UserServiceImpl.getInstance();
        this.utilService = UtilServiceImpl.getInstance();
    }

    public String addUsers() {
        return userService.addUsers();
    }

    public Messenger save(Scanner sc) throws SQLException {
        System.out.println("\"아이디, 비밀번호, 비밀번호확인, 이름, 전화번호, 폰번호, 주소, 직업을 입력하세요\"");
        userService.save(User.builder()
                .username(sc.next())
                .password(sc.next())
                .checkPassword(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .build());
        return Messenger.SUCCESS;
    }

    public List<User> findAll() {
        return userService.findAll();
    }

    public String login(Scanner sc) {
        System.out.println("id와 pw를 입력하세요");
        return userService.login(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }

    public Optional<User> findById(Scanner sc) {
        return userService.findById(Long.parseLong(sc.next()));
    }

    public String updatePassword(Scanner sc) {
        System.out.println("아이디와 변경할 비밀번호 입력 : ");
        return userService.updatePassword(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }

    public String deleteUser(Scanner sc) {
        System.out.println("탈퇴할 아이디를 적어주세요 : ");
        return userService.updatePassword(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build());
    }

    public Boolean existsById(Scanner scanner) {
        return userService.existsById(Long.parseLong(scanner.next()));
    }

    public List<?> findUsersByName(Scanner sc) {
        System.out.println("이름으로 검색");
        return userService.findUsersByName(sc.next());
    }

    public Map<String, ?> findUsersByNameFromMap(Scanner scanner) {
        return userService.findUsersByNameFromMap(scanner.next());
    }

    public List<?> findUsersByJob(Scanner sc) {
        System.out.println("직업으로 검색");
        return userService.findUsersByJob(sc.next());
    }

    public String count() {
        return "회원수 : " + userService.count() + " 명";
    }

    public Optional<User> getOne(Scanner scanner) {
        return userService.getOne(scanner.next());
    }

    public Map<String, ?> getUserMap() {
        System.out.println("전체 목록 출력");
        return userService.getUserMap();
    }
    public List<?> findUsers() throws SQLException {
        return userService.findUsers();
    }
    public Messenger createTable() throws SQLException {
        return userService.createTable();
    }
    public Messenger deleteTable() throws SQLException {
        return userService.deleteTable();
    }
    public Messenger insertData(Scanner sc) throws SQLException {
        return  userService.insertData(User.builder()
                .username(sc.next())
                .password(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .height(utilService.createRandomDouble(1, 100))
                .weight(utilService.createRandomDouble(1, 100))
                .build());
    }
    public void sqlClose() throws SQLException {
        userService.sqlClose();
    }
}













