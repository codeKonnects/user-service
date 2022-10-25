package io.codeKonnects.userservice.valueobject;

import io.codeKonnects.userservice.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private Users users;
    private Department department;
}
