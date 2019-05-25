package com.imooc.kuckymoney;

import com.imooc.kuckymoney.domain.Luckymoneytable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyRepository extends JpaRepository<Luckymoneytable, Integer> {
}
