package com.ps.FoodDelivery.repository;

import com.ps.FoodDelivery.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findFirstByFirstName(String firstName);
    User findFirstByLastName(String lastName);
    List<User> findAllByFirstName(String firstName);
    List<User> findAllByLastName(String lastName);
    List<User> findAllByEmail(String email);
    User findFirstByEmail(String email);
    User findFirstByPassword(String password);

    @Query(value = "select * from user",nativeQuery = true)
    List<User> showAllUsers();

<<<<<<< HEAD
    @Query(value = "select * from user where logged=true",nativeQuery = true)
    List<User> getLoggedUsers();

=======
>>>>>>> 583e829b44b8ed474109c9b0b4d0a65ffeb42dd4
    User findFirstById(Long id);
    void deleteById(Long id);

    User findFirstByEmailAndId(String email,Long id);
    User findFirstByEmailAndPassword(String email,String password);
}
