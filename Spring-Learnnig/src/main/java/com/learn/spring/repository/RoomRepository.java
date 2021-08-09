package com.learn.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.spring.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
