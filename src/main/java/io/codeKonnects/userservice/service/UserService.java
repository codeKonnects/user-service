package io.codeKonnects.userservice.service;

import io.codeKonnects.userservice.entity.Users;
import io.codeKonnects.userservice.repository.UserRepository;
import io.codeKonnects.userservice.valueobject.Department;
import io.codeKonnects.userservice.valueobject.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    public Users saveUser(Users users) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(users);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Users users = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + users.getDepartmentId(), Department.class);
        responseTemplate.setUsers(users);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }


}
