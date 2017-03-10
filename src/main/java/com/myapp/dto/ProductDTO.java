/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myapp.domain.User;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;

/**
 *
 * @author Kamil
 */
@Value
@Builder

public class ProductDTO {

    private final long id;
    private final String name;
    private final double price;
    private final String description;
    private final int pieces;
    @JsonProperty("user")
    private final UserDTO userDTO;
    private final Boolean isMyPost;
    
 
    
        


}
