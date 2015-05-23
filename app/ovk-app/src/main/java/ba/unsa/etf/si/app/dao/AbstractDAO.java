package ba.unsa.etf.si.app.dao;

import org.hibernate.Criteria;



import org.hibernate.Session;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;


import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

//genericka DAO klasa sa metodama findAll, findById, save, delete, findByExample

public abstract class AbstractDAO<T, ID extends Serializable>{  

private Class<T> persistentClass;
private Session session;  

@SuppressWarnings("unchecked")
public AbstractDAO() {  
this.persistentClass = (Class<T>) ((ParameterizedType) getClass()  
                        .getGenericSuperclass()).getActualTypeArguments()[0];  
}  

public void setSession(Session s) {  
this.session = s;  
}  

protected Session getSession() {  
if (session == null)  
    throw new IllegalStateException("Session has not been set on DAO before usage");  
return session;  
}  

public Class<T> getPersistentClass() {  
return persistentClass;  
}  

@SuppressWarnings("unchecked")
public T findById(ID id) {  
T entity;

entity = (T) getSession().get(getPersistentClass(), id);  
 
return entity;  
}  

public List<T> findAll() {  
return findByCriteria();  
}  

@SuppressWarnings("unchecked")  
public List<T> findByExample(T exampleInstance, String[] excludeProperty) {  
Criteria crit = getSession().createCriteria(getPersistentClass());  
Example example =  Example.create(exampleInstance);  
for (String exclude : excludeProperty) {  
    example.excludeProperty(exclude);  
}  
crit.add(example);  
return crit.list();  
}

// skracenica za findByExample
public List<T> findByExample(T exampleInstance) {
	return findByExample(exampleInstance, new String[] {});
}

public T save(T entity) {
try{
getSession().saveOrUpdate(entity);  
 
}
catch(Exception e)
	{
	throw new IllegalStateException("Nema bolan!");
	} 
return entity; 
}

public T merge(T entity) {  
getSession().merge(entity);  
return entity;  
}  

public void delete(ID id) {  
	
T entity = findById(id);
if (entity == null)  
    throw new IllegalStateException("Nema bolan!");
else
	getSession().delete(entity);  

}  

public void flush() {  
getSession().flush();  
}  

public void clear() {  
getSession().clear();  
}  

/** 
* Use this inside subclasses as a convenience method. 
*/  
@SuppressWarnings("unchecked")  
protected List<T> findByCriteria(Criterion... criterion) {  
Criteria crit = getSession().createCriteria(getPersistentClass());  
for (Criterion c : criterion) {  
    crit.add(c);  
}  
return crit.list();  
}  

}  
