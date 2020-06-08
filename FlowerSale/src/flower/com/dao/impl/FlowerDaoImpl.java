package flower.com.dao.impl;

import java.util.List;

import net.sf.ehcache.search.expression.Criteria;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import flower.com.dao.FlowerDao;
import flower.com.entity.Flower;

@Repository("flowerDao")
public class FlowerDaoImpl extends HibernateDaoSupport implements FlowerDao {

	@Override
	public List<Flower> findAllFlower() {
		// TODO Auto-generated method stub
		return (List<Flower>)this.getHibernateTemplate().find("from Flower");
	}

	@Override
	public Flower findFlowerById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Flower.class, id);
	}

	@Override
	public List<Flower> findFlowerByPrice(float price) {
		// TODO Auto-generated method stub
		String hql = "from Flower  where flowerUpdataPrice >= ? and flowerUpdataPrice <= ?";
		return (List<Flower>)this.getHibernateTemplate().getSessionFactory().openSession().
				createQuery(hql).setFloat(0, price-2).setFloat(1, price+2).list();
	}

	@Override
	public List<Flower> findFlowerByFlowerName(String searchInfo) {
		String hql = "from Flower f where f.flowerName like ? or f.storeName like ?";
		String[] findInfo = new String[]{"%"+searchInfo+"%","%"+searchInfo+"%"};
		return (List<Flower>)this.getHibernateTemplate().find(hql,findInfo);
	}

	@Override
	public List<Flower> findFlowerPage(int min, int max) {
		// TODO Auto-generated method stub
		org.springframework.orm.hibernate4.HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		org.hibernate.Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(Flower.class);
		criteria.setFirstResult(min);
		criteria.setMaxResults(max);
		return criteria.list();
	}

	@Override
	public List<Flower> findFlowersByStoreName(String storeName) {
		// TODO Auto-generated method stub
		return (List<Flower>)this.getHibernateTemplate().find("from Flower f where f.storeName=?", storeName);
	}

	@Override
	public boolean updataFlowerInfo(Flower flower) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(flower);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveFlower(Flower flower) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(flower);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Flower> findFlowerByFlowernameAndStoreName(String flowername,
			String storename) {
		// TODO Auto-generated method stub
		String hql = "from Flower flower where flower.flowerName=? and flower.storeName=?";
		String[] info = {flowername,storename};
		return (List<Flower>)this.getHibernateTemplate().find(hql, info);
	}

}
