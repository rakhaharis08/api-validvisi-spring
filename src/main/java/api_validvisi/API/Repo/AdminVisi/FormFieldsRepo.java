package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.FormFields;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormFieldsRepo extends JpaRepository<FormFields, String> {
    Optional<FormFields> findFormFieldsById(String id);
}
