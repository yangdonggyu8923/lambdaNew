package com.james.api.user;

import com.james.api.common.AbstractService;
import com.james.api.common.UtilService;
import com.james.api.common.UtilServiceImpl;
import com.james.api.enums.Messenger;
import com.james.api.menu.Menu;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    UserRepository userRepository;

    private static UserServiceImpl instance = new UserServiceImpl() ;

    Map<String, User> usersMap;

    private UserServiceImpl() {
        this.usersMap = new HashMap<>();
        this.userRepository = UserRepository.getInstance();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public String login(User user) {
        User userInMap = usersMap.get(user.getUsername());
        String msg = "";
        if (userInMap == null){
            msg = "유효하지 않은 아이디입니다.";
        }else{
            if (userInMap.getPassword().equals(user.getPassword())){
                msg = "로그인 완료";
            }
            else{msg ="유효하지 않은 비밀번호입니다.";}}

        return msg;
    }

    @Override
    public String addUsers() {
        Map<String, User> map = new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();

        for (int i = 0; i < 5; i++) {
            String username = util.createRandomUsername();
            map.put(username, User.builder()
                    .username(username)
                    .password("1")
                    .checkPassword("1")
                    .name(util.createRandomName())
                    .job(util.createRandomJob())
                    .build());
        }
        usersMap = map;
        return usersMap.size() + " 개 더미값 추가";
    }


    @Override
    public String changePassword(User user) {
//        users.get(com.james.api.user.getUsername()).setPassword();
        User userInMap = usersMap.get(user.getUsername());
        String msg = "";
        if (userInMap != null){
            msg = "아이디 동일, 비밀번호 변경완료";
            userInMap.setPassword(user.getPassword());
        }else {
            msg = "아이디 불일치";
        }
        return msg;
    }



    @Override
    public List<?> findUsersByName(String name) {
        return usersMap
                .values()
                .stream()
                .filter(i->i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return usersMap
                .entrySet()
                .stream()
                .filter(i->i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return usersMap
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return usersMap
                .entrySet()
                .stream()
                .filter(i->i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    @Override
    public Map<String, User> getUsersMap() {
        usersMap.forEach((k, v) -> System.out.println("{" + k + ',' + v + "}"));
        return usersMap;
    }



    @Override
    public Messenger save(User user) {
        usersMap.put(user.getUsername(), user);
        return Messenger.SUCCESS;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(usersMap.values());
    }


    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(usersMap
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public String count() {
        return usersMap.size()+"";
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.of(usersMap.get(id));
    }

    @Override
    public String delete(User user) {
        User userInMap = usersMap.get(user.getUsername());
        String msg = "";
        if (userInMap != null){
            if(userInMap.getPassword().equals(user.getPassword())){
                msg = "아이디, 비밀번호 동일, 탈퇴완료";
                usersMap.remove(user.getUsername());
            }}
        else {msg = "아이디 불일치, 탈퇴실패";}

        return msg;
    }



    @Override
    public Boolean existById(Long id) {
        return usersMap.containsKey(id);
    }

    @Override
    public String test() {
        return userRepository.test();
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return userRepository.findUsers();
    }

    @Override
    public Messenger deleteTable() throws SQLException {
        return userRepository.deleteTable();
    }
    @Override
    public Messenger createTable() throws SQLException {
        return userRepository.createTable();
    }

    @Override
    public Messenger insertData(User user) throws SQLException {
        return userRepository.insertData(user);
    }

    @Override
    public void sqlClose() throws SQLException {
        userRepository.sqlClose();
    }

    @Override
    public Messenger insertMenuData(Menu menu) throws SQLException {
        return userRepository.insertMenuData(menu);
    }

    @Override
    public Messenger createMenuTable() throws SQLException {
        return userRepository.createMenuTable();
    }

    @Override
    public Messenger deleteMenuTable() throws SQLException {
        return userRepository.deleteMenuTable();
    }
}
