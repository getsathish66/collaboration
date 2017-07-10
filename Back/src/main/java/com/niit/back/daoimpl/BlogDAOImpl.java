package com.niit.back.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.back.dao.BlogDAO;
import com.niit.back.model.Blog;

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>)sessionFactory.getCurrentSession().createCriteria(Blog.class)
		 .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlog;
	}
	@Transactional
	public Blog saveOrUpdate(Blog blog) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return blog;
	}

	@Transactional
	public void delete(int blogId) {
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogid(blogId);
		sessionFactory.getCurrentSession().delete(blogToDelete);
	}
	@Transactional
	public Blog getById(int blogId) {
		Blog BlogId = (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);

		return BlogId;
	}
	@Transactional
	public Blog getByTitle(String title) {
		Blog Title = (Blog) sessionFactory.getCurrentSession().get(Blog.class,title);

		return Title;
	}

	@Transactional
	public void insert(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}
	@Transactional
	public Blog getAllBlog(int blogid) {
		
		String hql = "from Blog where blogid ='" + blogid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) (query).list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
  
	}
	
}