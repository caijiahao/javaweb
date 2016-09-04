package dao;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.GenericsUtils;
import util.Page;


public class HibernateDao<T> extends HibernateDaoSupport {
    protected Class<T> entityClass;

    public HibernateDao() {
        this.entityClass = GenericsUtils.getSuperClassGenricType(this
                .getClass());
    }

    // update
    public T get(Serializable id) {
        if (id == null) {
            return null;
        } else {
            return (T) this.getHibernateTemplate().get(entityClass, id);
        }
    }

    public List<T> getAll() {
        return this.getHibernateTemplate().loadAll(this.entityClass);
    }

    public T load(Serializable id) {
        return (T) this.getHibernateTemplate().load(entityClass, id);
    }

    public void save(Object entity) {
        this.getHibernateTemplate().saveOrUpdate(entity);
    }

    public void remove(Object entity) {
        this.getHibernateTemplate().delete(entity);
    }

    public void removeById(Serializable id) {
    	try{
        remove(get(id));
    	}catch (Exception e){    		
    	}
    }

    public void removeAll(Collection list) {
        for (Object obj : list) {
            remove(obj);
        }
    }

    public void removeAll() {
        this.removeAll(this.getAll());
    }

    // session
    public void flush() {
        this.getHibernateTemplate().flush();
    }

    public void clear() {
        this.getHibernateTemplate().clear();
    }

    public T initialize(Serializable id) {
        T entity = get(id);
        Hibernate.initialize(entity);

        return entity;
    }

    // query
    public List<T> getAll(String sort, boolean isAsc) {
        if ((sort == null) || sort.trim().equals("")) {
            return getAll();
        } else {
            Criteria criteria = createCriteria();

            if (isAsc) {
                criteria.addOrder(Order.asc(sort));
            } else {
                criteria.addOrder(Order.desc(sort));
            }

            return criteria.list();
        }
    }

    public Query createQuery(String hql, Object... values) {
        Query query = getSession().createQuery(hql);

        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }

        return query;
    }

    public Criteria createCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);

        for (Criterion c : criterions) {
            criteria.add(c);
        }

        return criteria;
    }

    public Criteria createCriteria(String sort, boolean isAsc,
        Criterion... criterions) {
        if ((sort == null) || sort.trim().equals("")) {
            return createCriteria(criterions);
        } else {
            Criteria criteria = createCriteria(criterions);

            if (isAsc) {
                criteria.addOrder(Order.asc(sort));
            } else {
                criteria.addOrder(Order.desc(sort));
            }

            return criteria;
        }
    }

    // find
    public List<T> find(String hql, Object... values) {
        return createQuery(hql, values).list();
    }

    public List<T> findBy(String name, Object value) {
        return createCriteria(Restrictions.eq(name, value)).list();
    }

    public List<T> findByLike(String name, Object value) {
        return createCriteria(Restrictions.like(name, value)).list();
    }

    public T findUnique(String hql, Object... values) {
        return (T) createQuery(hql, values).setMaxResults(1).uniqueResult();
    }

    public T findUniqueBy(String name, Object value) {
        return (T) createCriteria(Restrictions.eq(name, value))
                       .setMaxResults(1).uniqueResult();
    }

    public Page pagedQuery(Page page) {
        Long count = getCount();
        List<T> result = createCriteria(page.getSort(), page.isAsc())
                             .setFirstResult(page.getStart())
                             .setMaxResults(page.getLimit()).list();

        page.setTotalCount(count);
        page.setResult(result);

        return page;
    }

    public Page pagedQuery(int start, int limit, String sort, boolean isAsc) {
        return pagedQuery(new Page(start, limit, sort,
                isAsc ? "ASC" : "DESC"));
    }

    public Page pagedQuery(int start, int limit, String sort, String dir) {
        return pagedQuery(new Page(start, limit, sort, dir));
    }

    public Long getCount() {
        Object result = createCriteria()
                            .setProjection(Projections.rowCount())
                            .uniqueResult();

        if (result instanceof Integer) {
            return ((Integer) result).longValue();
        } else if (result instanceof Long) {
            return (Long) result;
        } else {
            return 0L;
        }
    }
    public Long getMax() {
        Object result = createCriteria()
                            .setProjection(Projections.rowCount())
                            .uniqueResult();

        if (result instanceof Integer) {
            return ((Integer) result).longValue();
        } else if (result instanceof Long) {
            return (Long) result;
        } else {
            return 0L;
        }
    }
    public Long getCount(String hql, Object... values) {
        Object result = createQuery(hql, values).uniqueResult();

        if (result instanceof Integer) {
            return ((Integer) result).longValue();
        } else if (result instanceof Long) {
            return (Long) result;
        } else {
            return 0L;
        }
    }
    
    public String generateNo(String prefix)
	{
		long no = this.getCount() + 1;
		long FirNo = no/10000000;
		long SecNo = (no-FirNo*10000000)/1000000;
		long ThirNo = (no-FirNo*10000000-SecNo*1000000)/100000;
		long ForNo = (no-FirNo*10000000-SecNo*1000000-ThirNo*100000)/10000;
		long FifNo = (no-FirNo*10000000-SecNo*1000000-ThirNo*100000-ForNo*10000)/1000;
		long SixNo = (no-FirNo*10000000-SecNo*1000000-ThirNo*100000-ForNo*10000-FifNo*1000)/100;
		long SevenNo = (no-FirNo*10000000-SecNo*1000000-ThirNo*100000-ForNo*10000-FifNo*1000-SixNo*100)/10;
		long LastNo = no-FirNo*10000000-SecNo*1000000-ThirNo*100000-ForNo*10000-FifNo*1000-SixNo*100-SevenNo*10;
		String back = prefix +getDateString()+ FirNo + SecNo + ThirNo + ForNo + FifNo + SixNo + SevenNo + LastNo;
		//System.out.println("back:"+back);
		return back;
	}
	
	public  String getDateString() {
		String strM = "";
		String dqrq = "";

		Calendar c = new GregorianCalendar();// 新建日期对象
		int year = c.get(Calendar.YEAR);// 获取年份
		int month = c.get(Calendar.MONTH) + 1;

		if (month < 10)
			strM = "0" + String.valueOf(month);
		else
			strM = String.valueOf(month);
		dqrq = String.valueOf(year) + strM;

		return dqrq;
	}
}