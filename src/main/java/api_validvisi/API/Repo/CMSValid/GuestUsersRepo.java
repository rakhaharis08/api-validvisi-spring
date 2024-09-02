package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.GuestUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestUsersRepo extends JpaRepository<GuestUsers, Long> {
    Optional<GuestUsers> findGuestUsersById(int id);
}
