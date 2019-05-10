package com.meorient.geometry
 
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository
 
@Mapper
@Repository
interface H2Mapper {
		@Select("select * from TEST where id = #{id}")
		Customer find(id);
}
