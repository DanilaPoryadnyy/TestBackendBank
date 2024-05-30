package com.example.testbackendbank.dao.daoImpl.finance;

import com.example.testbackendbank.dao.daoInterface.finance.BranchDao;
import com.example.testbackendbank.entity.Branch;
import com.example.testbackendbank.repository.finance.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BranchDaoImpl implements BranchDao {
    private final BranchRepository branchRepository;

    @Override
    public Branch getBranchById(Integer id) {
        return branchRepository.findById(id).orElse(null);
    }
}
