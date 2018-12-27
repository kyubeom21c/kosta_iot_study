package test.com.model;

import java.util.List;

public interface MonsterDAO {
	
	public int insert(MonsterVO vo);	
	
	public int deleteAll();
	
	public int update(MonsterVO vo);
	
	public MonsterVO selectOne(MonsterVO vo);
	
	public void setStat();

}//end class
