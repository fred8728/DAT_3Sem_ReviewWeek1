/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author fskn
 */
public class EmployeeDTO {
    private long id;
    private String name;
    private String address;

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    
}
