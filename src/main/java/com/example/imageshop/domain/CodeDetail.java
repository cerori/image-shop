package com.example.imageshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @ToString
@EqualsAndHashCode(of = {"groupCode", "codeValue"})
@Entity
@IdClass(CodeDetailId.class)
@Table(name = "code_detail")
public class CodeDetail {

    @Id
    @Column(length = 3)
    private String groupCode;

    @Id
    @Column(length = 3)
    private String codeValue;

    @Column(length = 30, nullable = false)
    private String codeName;

    private int sortSeq;

    @Column(length = 1)
    private String useYn = "Y";

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updDate;
}
