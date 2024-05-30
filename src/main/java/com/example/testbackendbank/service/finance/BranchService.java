package com.example.testbackendbank.service.finance;

import com.example.testbackendbank.entity.Branch;
import com.example.testbackendbank.repository.finance.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    public Branch getBranchById(Integer id) {
        return branchRepository.findById(id).orElse(null);
    }

}
