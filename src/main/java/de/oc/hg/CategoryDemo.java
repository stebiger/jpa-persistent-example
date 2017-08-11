package de.oc.hg;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class CategoryDemo {

    List<Category> categories;

    @PersistenceContext(unitName = "DerbyPU")
    private EntityManager em;

    @Inject
    private Foo foo;

    @PostConstruct
    public void init() {
         categories = em.createQuery("Select c from Category c", Category.class).getResultList();
    }

    public Integer getCategoriesSize() {
        return categories.size();
    }

    public String getFoo() {
        return foo.getAttr();
    }


}
