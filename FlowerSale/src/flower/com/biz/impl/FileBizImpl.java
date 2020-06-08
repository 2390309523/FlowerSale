package flower.com.biz.impl;

import flower.com.biz.FileBiz;
import flower.com.dao.FileDao;

public class FileBizImpl implements FileBiz {
	private FileDao fileDao;

	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
}
