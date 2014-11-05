package com.chs.dao;

import java.util.List;
import com.chs.model.Person;
 
public interface PersonDAO {
 
    public void save(Person p);
     
    public List<Person> list();
     
}