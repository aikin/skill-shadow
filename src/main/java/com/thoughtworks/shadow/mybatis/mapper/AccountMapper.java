package com.thoughtworks.shadow.mybatis.mapper;

import com.thoughtworks.shadow.mybatis.model.Account;

public interface AccountMapper {
    public Account selectAccount(int id);
}
