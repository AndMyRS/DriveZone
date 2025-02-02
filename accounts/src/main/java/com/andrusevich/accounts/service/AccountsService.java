package com.andrusevich.accounts.service;

import com.andrusevich.accounts.dto.CustomerDto;

public interface AccountsService {

    void createAccount(CustomerDto dto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
