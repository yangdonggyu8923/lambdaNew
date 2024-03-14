package com.james.api.user;
import com.james.api.common.AbstractService;
import com.james.api.common.UtilService;
import com.james.api.common.UtilServiceImpl;
import com.james.api.enums.Messenger;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    private static UserServiceImpl instance = new UserServiceImpl();

    UserRepository userRepository;

    Map<String, User> users;
    private UserServiceImpl() {
        this.users = new HashMap<>();
        this.userRepository= UserRepository.getInstance();

    }
    public static UserServiceImpl getInstance() {return instance;}

    @Override
    public Messenger save(User user) {
        users.put(user.getUsername(), user);
        return Messenger.SUCCESS;
    }

    @Override
    public List<User> findAll() {
        return  new ArrayList<>(users.values());
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
    }
    @Override
    public Optional<User> findById(long id) {
        return Optional.of(users
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }
    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());

        return "비번 변경 성공";
    }
    @Override
    public String delete(User user) {
        users.remove(user.getUsername());
        return "회원삭제";
    }
    @Override
    public Boolean existsById(long id) {
        return users.containsKey(id);
    }
    @Override
    public List<?> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(i->i.getName().equals(name))
                .collect(Collectors.toList());
    }
    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i->i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return userRepository.findUsers();
    }

    @Override
    public List<?> findUsersByJob(String job) {
        System.out.println("findUsersByJob 파라미터 : "+job);
        return users
                .values()
                .stream()
                .filter(i->i.getJob().equals(job))
                .collect(Collectors.toList());
    }
    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i->i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    @Override
    public String count() {
        return users.size() + "";
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.empty();
    }

    public Map<String, User> getUserMap() {
        users.forEach((k, v) -> System.out.println("{" + k + "," + v + "}"));
        return users;
    }

    @Override
    public String addUsers() {
        UtilService util = UtilServiceImpl.getInstance();
        Map<String, User> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String username = util.createRandomUsername();
            map.put(username, User.builder()
                    .username(username)
                    .password("1")
                    .checkPassword("1")
                    .name(util.createRandomWriter())
                    .job(util.createRandomJob())
                    .build());
        }
        users = map;
        return users.size() + "개 더미추가";
    }

    @Override
    public Messenger createTable() throws SQLException {
        return userRepository.createTable();
    }
    @Override
    public Messenger deleteTable() throws SQLException {
        return userRepository.deleteTable();
    }

    public Messenger insertData(User user) throws SQLException {
        return userRepository.insertData(user);
    }

    public void sqlClose() throws SQLException {
        userRepository.sqlClose();
    }
}