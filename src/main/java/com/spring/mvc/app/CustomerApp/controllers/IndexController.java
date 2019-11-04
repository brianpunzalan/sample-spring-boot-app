/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.mvc.app.CustomerApp.controllers;

import org.springframework.stereotype.Controller;

/**
 *
 * @author brianpunzalan
 */
@Controller
public class IndexController {
    
    public String index() {
        return "index";
    }
}
