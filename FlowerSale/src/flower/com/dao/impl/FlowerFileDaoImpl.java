package flower.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import flower.com.dao.FlowerFileDao;
import flower.com.entity.FlowerFile;

@Repository("flowerFileDao")
public class FlowerFileDaoImpl extends HibernateDaoSupport implements FlowerFileDao {

	@Override
	public List<FlowerFile> findFlowerFileById(int id) {
		String hql = "from FlowerFile ff where ff.id=?";
		return (List<FlowerFile>)this.getHibernateTemplate().find(hql, id);
	}

	@Override
	public List<FlowerFile> findFlowerFileByFlowerId(int flowerId) {
		String hql = "from FlowerFile ff where ff.flowerId=?";
		
		return (List<FlowerFile>)this.getHibernateTemplate().find(hql, flowerId);
	}

	@Override
	public boolean saveFlowerFiles(List<FlowerFile> flowerFiles) {
		// TODO Auto-generated method stub
		boolean result = true;
		for(FlowerFile flower:flowerFiles){
			try{
				this.getHibernateTemplate().save(flower);
			}catch(Exception e){
				e.printStackTrace();
				this.getHibernateTemplate().getSessionFactory().openSession().beginTransaction().rollback();
				result = false;
			}
		}
		return result;
	}

	@Override
	public boolean saveFlowerFile(FlowerFile flowerFile) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(flowerFile);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
