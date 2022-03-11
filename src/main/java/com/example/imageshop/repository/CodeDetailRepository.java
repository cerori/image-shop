package com.example.imageshop.repository;

import com.example.imageshop.domain.CodeDetail;
import com.example.imageshop.domain.CodeDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeDetailRepository extends JpaRepository<CodeDetail, CodeDetailId> {

    @Query("SELECT max(cd.sortSeq) from CodeDetail cd where cd.groupCode = ?1")
    public List<Object[]> getMaxSortSeq(String groupCode);

    @Query("select cd from CodeDetail cd where cd.groupCode = ?1")
    List<CodeDetail> getCodeList(String groupCode);
}
