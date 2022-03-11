package com.example.imageshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "code_group")
public class CodeGroup {

    @Id
    @Column(length = 3)
    private String groupCode;

    @Column(length = 30, nullable = false)
    private String groupName;

    @Column(length = 1)
    private String useYn = "Y";

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "groupCode")
    private List<CodeDetail> codeDetails;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updDate;

}
