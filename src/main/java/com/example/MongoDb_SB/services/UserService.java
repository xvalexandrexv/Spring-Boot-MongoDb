package com.example.MongoDb_SB.services;

import com.example.MongoDb_SB.Dto.UserDto;
import com.example.MongoDb_SB.model.User;
import com.example.MongoDb_SB.repository.UserRepository;
import com.example.MongoDb_SB.services.serviceException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {

         Optional<User> userOptional = userRepository.findById(id);
   if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ObjectNotFoundException("Obj not found");
        }
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }


    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDto(UserDto objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), null);
    }

}
