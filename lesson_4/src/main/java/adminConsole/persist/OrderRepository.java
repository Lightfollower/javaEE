package adminConsole.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Transactional
    @PostConstruct
    public void init() {
    }


    @Transactional
    public void update(Order order) {
        em.merge(order);
    }

    @Transactional
    public Order findById(long id) {
        return em.find(Order.class, id);
    }

    @Transactional
    public List<Order> findAll() {
        return em.createQuery("from Order", Order.class).getResultList();
    }

    @Transactional
    public List<Cart> findByOrderId(long id) {
        return em.createQuery("from Cart ", Cart.class).getResultList();
    }

}
