package com.anish.sample.service;

import com.anish.sample.entity.User;
import com.anish.sample.entity.UserProfile;
import com.anish.sample.repository.UserProfileRepository;
import com.anish.sample.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService
{


    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;
    public UserService(UserRepository userRepository,
                       UserProfileRepository userProfileRepository)
    {
        this.userRepository=userRepository;
        this.userProfileRepository=userProfileRepository;
    }

    public User addUser(User user)
    {
        return userRepository.save(user);
    }
    @Transactional(readOnly = true)
    public String getProfileCity(Long userId)
    {
        User user=userRepository.findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("User Not found"));

        UserProfile profile=user.getUserProfile();

        if(profile==null)
        {
            throw new EntityNotFoundException("Profile not found for this user");
        }
        return profile.getCity();
    }

    @Transactional(readOnly = true)
    public String getUsername(Long profileId)
    {


        UserProfile profile=userProfileRepository.findById(profileId)
            .orElseThrow(()->new EntityNotFoundException("User not found"));

        User user=profile.getUser();

        if(user==null)
        {
            throw new EntityNotFoundException("Profile not found");
        }
        return user.getUsername();
    }
}
