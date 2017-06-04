package com.example.demo.repository;

import com.example.demo.model.Option;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by divine on 2017/06/04.
 */
public interface OptionRepo extends CrudRepository<Option, Long> {
}
