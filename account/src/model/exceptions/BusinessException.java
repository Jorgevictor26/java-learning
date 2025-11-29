/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exceptions;

/**
 *
 * @author jorge-victor
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String msg) {
        super(msg);
    }
}
