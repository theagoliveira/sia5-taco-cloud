package tacos.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import tacos.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

}
