package com.thigki.ntu._5.hanguyentienthinh_fitCMS.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thigki.ntu._5.hanguyentienthinh_fitCMS.models.Page;
@Repository
public interface PageRepository extends JpaRepository<Page,Integer>{

}
