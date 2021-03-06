package com.niit.back.dao;

import java.util.List;

import com.niit.back.model.Friend;

public interface FriendDAO {
	public List<Friend> list();

	public List<Friend> getByUser(int userId);

	public List<Friend> getByUser1(int userId);

	public List<Friend> getByName(String username);

	public List<Friend> getByFriendName(String username);

	public void save(Friend friend);

	public Friend saveOrUpdate(Friend friend);

	public List<Friend> getByFriendAccepted(String friendname);

    public List<Friend> list(int userId);

    public void delete(int friendid);

    public Friend getByFriendId(int friendid);
    
    public List<Friend> getByFriendAccepted1(String name);
}
