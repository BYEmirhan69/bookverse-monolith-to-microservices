package com.bookverse.single_file_monolith.clients;

import com.bookverse.single_file_monolith.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * UserServiceClient - user-service mikroservisine HTTP istekleri yapar.
 * Bu sınıf, Strangler Fig deseninin bir parçasıdır ve 
 * monolitin kullanıcı verilerine erişmesini sağlar.
 */
@Component
public class UserServiceClient {
    private final RestTemplate restTemplate;
    private final String userServiceUrl = "http://localhost:8081/api/users";

    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Belirli bir kullanıcıyı ID'ye göre getirir.
     * HTTP GET isteği ile user-service'e bağlanır.
     */
    public UserDTO getUserById(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/" + id, UserDTO.class);
    }

    /**
     * Tüm kullanıcıları getirir.
     */
    public List<UserDTO> getAllUsers() {
        UserDTO[] users = restTemplate.getForObject(userServiceUrl, UserDTO[].class);
        return users != null ? Arrays.asList(users) : List.of();
    }

    /**
     * Yeni bir kullanıcı oluşturur.
     */
    public UserDTO createUser(UserDTO user) {
        return restTemplate.postForObject(userServiceUrl, user, UserDTO.class);
    }

    /**
     * Bir kullanıcıyı siler.
     */
    public void deleteUser(Long id) {
        restTemplate.delete(userServiceUrl + "/" + id);
    }
}
