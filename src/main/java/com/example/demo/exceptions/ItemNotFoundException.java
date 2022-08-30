/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author amurillo
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends IllegalStateException{
     public ItemNotFoundException() {
        super("Element not found");
    }
}
