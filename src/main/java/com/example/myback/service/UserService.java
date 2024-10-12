package com.example.myback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myback.entity.User;
import com.example.myback.repository.UserRepository;



import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    

    public List<User> getAllUsers() {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        usersIterable.forEach(userList::add);
        return userList;
    }

    public User getUser(int userid) { // Utilisation de int
        return userRepository.findById(userid).orElse(null);
    }
    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Utilisateur authentifié
        }
        return false; // Échec de l'authentification
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userid) { // Utilisation de int
        userRepository.deleteById(userid);
    }
}
