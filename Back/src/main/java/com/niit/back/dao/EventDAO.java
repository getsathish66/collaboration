package com.niit.back.dao;

import java.util.List;

import com.niit.back.model.Event;

public interface EventDAO {

	public List<Event>list();
	public void saveOrUpdate(Event event);
	public void delete (int eventid);
	public Event getByEventcategory(String eventcategory);
	public Event getByEventid(int eventid);
	public void insert(Event event);

}
