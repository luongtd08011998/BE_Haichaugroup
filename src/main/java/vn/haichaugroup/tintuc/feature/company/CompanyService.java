package vn.haichaugroup.tintuc.feature.company;

import vn.haichaugroup.tintuc.dto.ResultPaginationDTO;
import vn.haichaugroup.tintuc.feature.company.dto.CompanyResponse;
import org.springframework.data.domain.Pageable;
import vn.haichaugroup.tintuc.feature.company.dto.CreateCompanyRequest;
import vn.haichaugroup.tintuc.feature.company.dto.UpdateCompanyRequest;

public interface CompanyService {

    CompanyResponse create(CreateCompanyRequest request);

    CompanyResponse update(UpdateCompanyRequest request);

    CompanyResponse getById(Long id);

    ResultPaginationDTO getAll(Pageable pageable);

    void delete(Long id);
}
