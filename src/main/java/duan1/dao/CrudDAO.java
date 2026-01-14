/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.dao;

import java.util.List;

/**
 *
 * @author pc
 */
public interface CrudDAO<Entity,ID> {
    Entity create(Entity entity);
    void update(Entity entity);
    void delete(ID id);
    
    List<Entity> findAll();
    Entity  findByID(ID id);
}

