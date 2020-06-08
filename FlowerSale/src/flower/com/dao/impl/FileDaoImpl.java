package flower.com.dao.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import flower.com.dao.FileDao;
@Repository("fileDao")
public class FileDaoImpl extends HibernateDaoSupport implements FileDao{

}
