/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.model.auth;


import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name cannot be blank.")
    public String name;
    
    @NotEmpty(message = "Slug cannot be blank.")
    public String Slug;
    
     @ManyToMany(mappedBy = "role")
     private Set<Users> users;

    public Role(Long id, String name, String Slug, Set<Users> users) {
        this.id = id;
        this.name = name;
        this.Slug = Slug;
        this.users = users;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }



    public Role() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String Slug) {
        this.Slug = Slug;
    }

    
    
}
