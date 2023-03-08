package com.emc.apiContactos_01.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Usuario que llega del formulario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String username ;
    private String password;
}
